package com.abhisek.flashcardquiz

// QuizActivity.kt

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class QuizActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var optionsRadioGroup: RadioGroup
    private lateinit var submitAnswerButton: Button

    private lateinit var currentFlashcard: Flashcard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionTextView = findViewById(R.id.questionTextView)
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup)
        submitAnswerButton = findViewById(R.id.submitAnswerButton)

        currentFlashcard = intent.getSerializableExtra("flashcard") as Flashcard

        questionTextView.text = currentFlashcard.question

        for ((index, option) in currentFlashcard.options.withIndex()) {
            val radioButton = RadioButton(this)
            radioButton.id = index
            radioButton.text = option
            optionsRadioGroup.addView(radioButton)
        }

        submitAnswerButton.setOnClickListener {
            val selectedOptionId = optionsRadioGroup.checkedRadioButtonId

            if (selectedOptionId != -1) {
                val selectedOption = currentFlashcard.options[selectedOptionId]

                checkAnswer(selectedOption, currentFlashcard.correctAnswer)

                // Navigate to a new activity or perform any other action
                showQuizResult()
            } else {
                // Handle case where no option is selected
            }
        }
    }

    private fun checkAnswer(selectedOption: String, correctAnswer: String) {
        if (selectedOption == correctAnswer) {
            // Handle correct answer
            // You can update scores or perform other actions
        } else {
            // Handle incorrect answer
        }
    }

    private fun showQuizResult() {
        // Perform actions after the quiz is over
        // For example, you can navigate to a result screen
        val resultIntent = Intent(this, QuizResultActivity::class.java)
        startActivity(resultIntent)

        // Finish the current activity
        finish()
    }


}

