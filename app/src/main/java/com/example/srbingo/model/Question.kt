package com.example.srbingo.model

// Potrebni importi za Parcelable
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Model podataka koji predstavlja pitanje u igri
@Parcelize
data class Question(
    val questionText: String = "", // Tekst pitanja
    val options: List<String> = listOf(), // Lista mogućih odgovora
    val correctAnswer: String = "", // Tačan odgovor
    val level: Int = 1 // Nivo na kom se pitanje nalazi
) : Parcelable // Omogućava prosleđivanje objekta kroz Intent 