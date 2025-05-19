package com.example.srbingo

// Model podataka koji predstavlja nivo u igri
data class Level(
    val number: Int, // Broj nivoa
    val description: String, // Opis nivoa
    val isLocked: Boolean = false // Da li je nivo zaključan
) 