package com.abhisek.flashcardquiz

// Flashcard.kt

import java.io.Serializable

data class Flashcard(val question: String, val correctAnswer: String, val options: List<String>) : Serializable
