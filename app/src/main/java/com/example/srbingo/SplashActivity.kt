package com.example.srbingo

// Potrebni importi za funkcionalnost početnog ekrana
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.srbingo.databinding.ActivitySplashBinding
import com.example.srbingo.utils.MusicManager
import kotlin.random.Random

// Početni ekran aplikacije koji se prikazuje dok se učitavaju potrebni resursi
class SplashActivity : AppCompatActivity() {
    // Inicijalizacija potrebnih varijabli
    private lateinit var binding: ActivitySplashBinding // Povezivanje sa XML layoutom
    private val handler = Handler(Looper.getMainLooper()) // Handler za ažuriranje UI-a
    private var currentProgress = 0 // Trenutni napredak učitavanja
    private lateinit var musicManager: MusicManager // Upravljanje pozadinskom muzikom

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Postavljanje layouta
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Pokretanje pozadinske muzike
        musicManager = MusicManager.getInstance(applicationContext)
        musicManager.startMusic()

        // Nasumično vreme čekanja između 5 i 10 sekundi
        val totalTimeMillis = Random.nextLong(5000, 10001)
        val updateInterval = 50L // Ažuriranje napretka na svakih 50ms

        // Postavljanje maksimalne vrednosti progress bara
        binding.progressBar.max = 100

        // Kreiranje objekta za ažuriranje progress bara
        val progressRunnable = object : Runnable {
            override fun run() {
                if (currentProgress < 100) {
                    currentProgress++
                    binding.progressBar.progress = currentProgress
                    handler.postDelayed(this, totalTimeMillis / 100)
                } else {
                    // Kada se učitavanje završi, prelazak na LoginActivity
                    startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                    finish()
                }
            }
        }

        // Pokretanje procesa učitavanja
        handler.post(progressRunnable)
    }

    // Upravljanje životnim ciklusom aktivnosti
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
        // Čišćenje handler-a da se izbegne memory leak
        handler.removeCallbacksAndMessages(null)
    }
} 