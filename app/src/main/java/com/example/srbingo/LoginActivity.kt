package com.example.srbingo

// Potrebni importi za funkcionalnost prijave
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.srbingo.databinding.ActivityLoginBinding
import com.example.srbingo.utils.MusicManager
import com.google.firebase.auth.FirebaseAuth

// Aktivnost za prijavu korisnika u aplikaciju
class
LoginActivity : AppCompatActivity() {
    // Inicijalizacija potrebnih varijabli
    private lateinit var binding: ActivityLoginBinding // Povezivanje sa XML layoutom
    private lateinit var auth: FirebaseAuth // Firebase autentifikacija
    private lateinit var musicManager: MusicManager // Upravljanje pozadinskom muzikom

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Postavljanje layouta
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicijalizacija Firebase autentifikacije i muzike
        auth = FirebaseAuth.getInstance()
        musicManager = MusicManager.getInstance(applicationContext)
        musicManager.startMusic()

        // Postavljanje dugmeta za prijavu
        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            // Provera da li su sva polja popunjena
            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Pokušaj prijave korisnika
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Uspešna prijava - prelazak na glavni ekran
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        } else {
                            // Neuspešna prijava - prikazivanje greške
                            Toast.makeText(this, "Authentication failed: ${task.exception?.message}",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                // Polja nisu popunjena - prikazivanje poruke
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Postavljanje dugmeta za registraciju
        binding.registerButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
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
} 