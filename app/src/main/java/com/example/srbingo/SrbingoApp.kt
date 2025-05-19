package com.example.srbingo

// Potrebni importi za aplikaciju
import android.app.Application
import com.google.firebase.FirebaseApp

// Glavna klasa aplikacije koja se izvršava prva
class SrbingoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Inicijalizacija Firebase-a za celu aplikaciju
        FirebaseApp.initializeApp(this)
    }
} 