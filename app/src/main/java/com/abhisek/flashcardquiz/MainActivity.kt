package com.abhisek.flashcardquiz

// MainActivity.kt

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // MainActivity.kt



    private lateinit var flashcardListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flashcardListView = findViewById(R.id.flashcardListView)

        val flashcards = listOf(
            Flashcard("What is the capital of France?", "A. Paris", listOf("A. Paris", "B. Berlin", "C. Madrid", "D. Rome")),
            Flashcard("What is the largest mammal?", "B. Blue whale", listOf("A. Elephant", "B. Blue whale", "C. Giraffe", "D. Dolphin"))
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, flashcards.map { it.question })
        flashcardListView.adapter = adapter

        flashcardListView.setOnItemClickListener { _, _, position, _ ->
            val selectedFlashcard = flashcards[position]
            startQuizActivity(selectedFlashcard)
        }
    }

    // MainActivity.kt

    // Inside the MainActivity class
    private fun startQuizActivity(flashcard: Flashcard) {
        val intent = Intent(this, QuizActivity::class.java)
        intent.putExtra("flashcard", flashcard)
        startActivity(intent)
    }

}
