package com.example.srbingo

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.srbingo.databinding.ActivityTextModeTwoOptionsBinding
import com.example.srbingo.model.Question
import com.example.srbingo.model.UserProgress
import com.example.srbingo.utils.MusicManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class TextModeTwoOptionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTextModeTwoOptionsBinding
    private lateinit var timer: CountDownTimer
    private val questions = mutableListOf<Question>()
    private var currentQuestionIndex = 0
    private var score = 0
    private val db = FirebaseFirestore.getInstance()
    private lateinit var musicManager: MusicManager
    private val userAnswers = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextModeTwoOptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.topAppBar)

        musicManager = MusicManager.getInstance(applicationContext)

        val level = intent.getIntExtra("level", 1)
        loadQuestions(level)
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

    private fun loadQuestions(level: Int) {
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
                questions.addAll(allQuestions.shuffled().take(10))
                
                if (questions.isNotEmpty()) {
                    binding.questionContainer.visibility = View.VISIBLE
                    showQuestion()
                } else {
                    Toast.makeText(this, getString(R.string.no_questions), Toast.LENGTH_LONG).show()
                }
            }
            .addOnFailureListener { exception ->
                binding.loadingProgressBar.visibility = View.GONE
                Log.e("TextMode", "Error loading questions", exception)
                Toast.makeText(this, getString(R.string.error_loading, exception.message), Toast.LENGTH_LONG).show()
            }
    }

    private fun showQuestion() {
        try {
            val question = questions[currentQuestionIndex]
            
            binding.questionText.text = question.questionText
            binding.questionNumberText.text = getString(R.string.question_number, currentQuestionIndex + 1)
            
            val shuffledOptions = question.options.shuffled().take(2)
            binding.apply {
                option1Button.text = shuffledOptions[0]
                option2Button.text = shuffledOptions[1]
            }

            startTimer()
        } catch (e: Exception) {
            Log.e("TextMode", "Error showing question", e)
            Toast.makeText(this, getString(R.string.error_loading, e.message), Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupAnswerButtons() {
        val buttons = listOf(
            binding.option1Button,
            binding.option2Button
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
        
        if (selectedButton.text == question.correctAnswer) {
            score++
        }

        currentQuestionIndex++
        if (currentQuestionIndex < questions.size) {
            showQuestion()
        } else {
            showResults()
        }
    }

    private fun startTimer() {
        binding.timerProgressBar.visibility = View.VISIBLE
        binding.timerProgressBar.progress = 100

        timer = object : CountDownTimer(10000, 100) {
            override fun onTick(millisUntilFinished: Long) {
                val progress = (millisUntilFinished / 10000.0 * 100).toInt()
                binding.timerProgressBar.progress = progress
            }

            override fun onFinish() {
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
            scoreText.text = getString(R.string.score, score)
            
            // Save progress to Firebase
            val userId = FirebaseAuth.getInstance().currentUser?.uid
            if (userId != null) {
                val level = intent.getIntExtra("level", 1)
                if (score >= 7) {  // Only save if score is passing (7 or higher)
                    saveProgress(userId, level)
                }
            }

            finishButton.setOnClickListener {
                val intent = Intent(this@TextModeTwoOptionsActivity, TestReviewActivity::class.java).apply {
                    putParcelableArrayListExtra("questions", ArrayList(questions))
                    putStringArrayListExtra("userAnswers", ArrayList(userAnswers))
                }
                startActivity(intent)
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                finish()
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            }
        }
    }

    private fun saveProgress(userId: String, level: Int) {
        binding.loadingProgressBar.visibility = View.VISIBLE
        binding.finishButton.isEnabled = false

        db.collection("userProgress")
            .document(userId)
            .get()
            .addOnSuccessListener { document ->
                val currentProgress = document.toObject(UserProgress::class.java) 
                    ?: UserProgress(userId)
                
                if (level > currentProgress.completedLevels) {
                    val updatedProgress = currentProgress.copy(
                        completedLevels = level
                    )

                    db.collection("userProgress")
                        .document(userId)
                        .set(updatedProgress)
                        .addOnSuccessListener {
                            binding.loadingProgressBar.visibility = View.GONE
                            binding.finishButton.isEnabled = true
                            Toast.makeText(this, "Nivo ${level} otključan!", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener { e ->
                            binding.loadingProgressBar.visibility = View.GONE
                            binding.finishButton.isEnabled = true
                            Toast.makeText(this, "Greška pri čuvanju: ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                } else {
                    binding.loadingProgressBar.visibility = View.GONE
                    binding.finishButton.isEnabled = true
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::timer.isInitialized) {
            timer.cancel()
        }
    }
} 