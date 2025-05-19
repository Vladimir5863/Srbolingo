package com.example.srbingo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.srbingo.databinding.ActivityTestReviewBinding
import com.example.srbingo.databinding.ItemReviewQuestionBinding
import com.example.srbingo.model.Question
import com.example.srbingo.utils.MusicManager

class TestReviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestReviewBinding
    private lateinit var musicManager: MusicManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.topAppBar)

        musicManager = MusicManager.getInstance(applicationContext)
        musicManager.startMusic()

        try {
            @Suppress("DEPRECATION")
            val questions = intent.getParcelableArrayListExtra<Question>("questions") ?: arrayListOf()
            val userAnswers = intent.getStringArrayListExtra("userAnswers") ?: arrayListOf()

            if (questions.isEmpty() || userAnswers.isEmpty()) {
                Toast.makeText(this, "No questions to review", Toast.LENGTH_SHORT).show()
                finish()
                return
            }

            // Show summary at the top
            val correctCount = questions.zip(userAnswers).count { (q, a) -> q.correctAnswer == a }
            binding.summaryText.text = getString(R.string.practice_score, correctCount, questions.size)

            binding.reviewRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@TestReviewActivity)
                adapter = ReviewAdapter(questions, userAnswers)
            }

            binding.finishButton.setOnClickListener {
                finish()
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            }
        } catch (e: Exception) {
            Log.e("TestReviewActivity", "Error setting up review", e)
            Toast.makeText(this, "Error showing review: ${e.message}", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onPause() {
        super.onPause()
        musicManager.pauseMusic()
    }

    override fun onResume() {
        super.onResume()
        musicManager.startMusic()
    }

    private inner class ReviewAdapter(
        private val questions: List<Question>,
        private val userAnswers: List<String>
    ) : RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {

        inner class ViewHolder(private val binding: ItemReviewQuestionBinding) :
            RecyclerView.ViewHolder(binding.root) {

            fun bind(question: Question, userAnswer: String, position: Int) {
                binding.questionText.text = "${position + 1}. ${question.questionText}"
                binding.optionsContainer.removeAllViews()

                // Feedback icon and text
                val isCorrect = userAnswer == question.correctAnswer
                binding.feedbackIcon.setImageResource(
                    if (isCorrect) android.R.drawable.checkbox_on_background else android.R.drawable.ic_delete
                )
                binding.feedbackIcon.visibility = android.view.View.VISIBLE
                binding.feedbackText.text = if (isCorrect) {
                    getString(R.string.correct_answer)
                } else {
                    getString(R.string.wrong_answer, question.correctAnswer)
                }
                binding.feedbackText.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        if (isCorrect) R.color.green_light else R.color.red_light
                    )
                )

                question.options.forEach { option ->
                    val optionView = TextView(this@TestReviewActivity).apply {
                        text = option
                        textSize = 16f
                        setPadding(32, 16, 32, 16)
                        setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
                        when {
                            option == userAnswer && option == question.correctAnswer -> {
                                setBackgroundColor(ContextCompat.getColor(context, R.color.green_light))
                                text = "$option (Correct)"
                            }
                            option == userAnswer -> {
                                setBackgroundColor(ContextCompat.getColor(context, R.color.red_light))
                                text = "$option (Your Answer)"
                            }
                            option == question.correctAnswer -> {
                                setBackgroundColor(ContextCompat.getColor(context, R.color.green_light))
                                text = "$option (Correct Answer)"
                            }
                        }
                    }
                    binding.optionsContainer.addView(optionView)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                ItemReviewQuestionBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(questions[position], userAnswers[position], position)
        }

        override fun getItemCount() = questions.size
    }
} 