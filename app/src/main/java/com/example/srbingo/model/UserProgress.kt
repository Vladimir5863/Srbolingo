package com.example.srbingo.model

// Model podataka koji prati napredak korisnika
data class UserProgress(
    val userId: String = "", // Jedinstveni identifikator korisnika
    val completedLevels: Int = 0 // Broj završenih nivoa (čuva se najviši završeni nivo)
) {
    // Provera da li korisnik može pristupiti određenom nivou
    fun canAccessLevel(level: Int): Boolean {
        // Prvi nivo je uvek dostupan, a ostali su dostupni ako je prethodni nivo završen
        return level == 1 || level <= completedLevels + 1
    }
} 