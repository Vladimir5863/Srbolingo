package com.example.srbingo

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.srbingo.databinding.ActivityTextModeBinding
import com.example.srbingo.model.Question
import com.google.firebase.firestore.FirebaseFirestore
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import android.widget.NumberPicker
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat
import android.content.Intent
import com.example.srbingo.utils.MusicManager
import android.animation.ObjectAnimator

class PracticeModeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTextModeBinding
    private lateinit var timer: CountDownTimer
    private val questions = mutableListOf<Question>()
    private var currentQuestionIndex = 0
    private var score = 0
    private val db = FirebaseFirestore.getInstance()
    private lateinit var musicManager: MusicManager
    private val userAnswers = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextModeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.topAppBar)

        musicManager = MusicManager.getInstance(applicationContext)

        val level = intent.getIntExtra("level", 1)
        showQuestionCountDialog(level)
        setupAnswerButtons()
    }

    override fun onPause() {
        super.onPause()
        musicManager.pauseMusic()
    }

    override fun onResume() {
        super.onResume()
        musicManager.startMusic()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::timer.isInitialized) {
            timer.cancel()
        }
    }

    private fun showQuestionCountDialog(level: Int) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_question_count, null)
        val numberPicker = dialogView.findViewById<NumberPicker>(R.id.questionCountPicker)
        val startButton = dialogView.findViewById<Button>(R.id.startButton)

        numberPicker.apply {
            minValue = 5
            maxValue = 20
            value = 10
        }

        val dialog = MaterialAlertDialogBuilder(this)
            .setView(dialogView)
            .setCancelable(false)
            .create()

        startButton.setOnClickListener {
            loadQuestions(level, numberPicker.value)
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun loadQuestions(level: Int, questionCount: Int) {
        binding.loadingProgressBar.visibility = View.VISIBLE
        binding.questionContainer.visibility = View.GONE

        db.collection("questions")
            .whereEqualTo("level", level)
            .get()
            .addOnSuccessListener { documents ->
                binding.loadingProgressBar.visibility = View.GONE
                
                if (documents.isEmpty) {
                    Toast.makeText(this, getString(R.string.no_questions), Toast.LENGTH_LONG).show()
                    return@addOnSuccessListener
                }

                val allQuestions = documents.toObjects(Question::class.java)
                // Take only the requested number of questions
                questions.addAll(allQuestions.shuffled().take(questionCount))
                
                if (questions.isNotEmpty()) {
                    binding.questionContainer.visibility = View.VISIBLE
                    showQuestion()
                } else {
                    Toast.makeText(this, getString(R.string.no_questions), Toast.LENGTH_LONG).show()
                }
            }
            .addOnFailureListener { exception ->
                binding.loadingProgressBar.visibility = View.GONE
                Log.e("PracticeMode", "Error loading questions", exception)
                Toast.makeText(this, getString(R.string.error_loading, exception.message), Toast.LENGTH_LONG).show()
            }
    }

    private fun showQuestion() {
        try {
            val question = questions[currentQuestionIndex]
            
            binding.questionText.text = question.questionText
            binding.questionNumberText.text = getString(
                R.string.question_number_total, 
                currentQuestionIndex + 1, 
                questions.size
            )
            
            val shuffledOptions = question.options.shuffled()
            binding.apply {
                option1Button.text = shuffledOptions[0]
                option2Button.text = shuffledOptions[1]
                option3Button.text = shuffledOptions[2]
                option4Button.text = shuffledOptions[3]
            }

            startTimer()
        } catch (e: Exception) {
            Log.e("PracticeMode", "Error showing question", e)
            Toast.makeText(this, getString(R.string.error_loading, e.message), Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupAnswerButtons() {
        val buttons = listOf(
            binding.option1Button,
            binding.option2Button,
            binding.option3Button,
            binding.option4Button
        )

        buttons.forEach { button ->
            button.setOnClickListener {
                checkAnswer(button)
            }
        }
    }

    private fun checkAnswer(selectedButton: Button) {
        timer.cancel()
        val question = questions[currentQuestionIndex]
        
        userAnswers.add(selectedButton.text.toString())
        
        // Show immediate feedback
        val buttons = listOf(
            binding.option1Button,
            binding.option2Button,
            binding.option3Button,
            binding.option4Button
        )

        buttons.forEach { button ->
            button.isEnabled = false
            when {
                button.text == question.correctAnswer -> {
                    button.setBackgroundColor(ContextCompat.getColor(this, R.color.green_light))
                }
                button == selectedButton && button.text != question.correctAnswer -> {
                    button.setBackgroundColor(ContextCompat.getColor(this, R.color.red_light))
                }
            }
        }

        if (selectedButton.text == question.correctAnswer) {
            score++
        }

        // Delay before next question to show feedback
        Handler(Looper.getMainLooper()).postDelayed({
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                // Reset button colors
                buttons.forEach { button ->
                    button.isEnabled = true
                    button.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                }
                showQuestion()
            } else {
                showResults()
            }
        }, 1000) // Show feedback for 1 second
    }

    private fun startTimer() {
        binding.timerProgressBar.visibility = View.VISIBLE
        binding.timerProgressBar.progress = 100

        // Animate progress bar smoothly
        val progressAnimator = ObjectAnimator.ofInt(binding.timerProgressBar, "progress", 100, 0)
        progressAnimator.duration = 10000 // 10 seconds
        progressAnimator.start()

        timer = object : CountDownTimer(10000, 100) {
            override fun onTick(millisUntilFinished: Long) {
                // No need to update progress manually, ObjectAnimator handles it
            }

            override fun onFinish() {
                binding.timerProgressBar.progress = 0
                progressAnimator.cancel()
                currentQuestionIndex++
                if (currentQuestionIndex < questions.size) {
                    showQuestion()
                } else {
                    showResults()
                }
            }
        }.start()
    }

    private fun showResults() {
        binding.apply {
            questionContainer.visibility = View.GONE
            resultsContainer.visibility = View.VISIBLE
            scoreText.text = getString(R.string.practice_score, score, questions.size)

            finishButton.setOnClickListener {
                try {
                    val intent = Intent(this@PracticeModeActivity, TestReviewActivity::class.java).apply {
                        putParcelableArrayListExtra("questions", ArrayList(questions))
                        putStringArrayListExtra("userAnswers", ArrayList(userAnswers))
                    }
                    startActivity(intent)
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                } catch (e: Exception) {
                    Log.e("PracticeModeActivity", "Error starting review", e)
                    Toast.makeText(
                        this@PracticeModeActivity,
                        "Error showing review: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                finish()
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            }
        }
    }
} 