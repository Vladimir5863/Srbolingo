package com.example.srbingo

// Potrebni importi za funkcionalnost registracije
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.srbingo.databinding.ActivityRegisterBinding
import com.example.srbingo.utils.MusicManager
import com.google.firebase.auth.FirebaseAuth

// Aktivnost za registraciju novih korisnika
class RegisterActivity : AppCompatActivity() {
    // Inicijalizacija potrebnih varijabli
    private lateinit var binding: ActivityRegisterBinding // Povezivanje sa XML layoutom
    private lateinit var auth: FirebaseAuth // Firebase autentifikacija
    private lateinit var musicManager: MusicManager // Upravljanje pozadinskom muzikom

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Postavljanje layouta
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicijalizacija Firebase autentifikacije i muzike
        auth = FirebaseAuth.getInstance()
        musicManager = MusicManager.getInstance(applicationContext)
        musicManager.startMusic()

        // Postavljanje dugmeta za registraciju
        binding.registerButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val confirmPassword = binding.confirmPasswordEditText.text.toString()

            // Provera da li su sva polja popunjena
            if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                // Provera da li se lozinke poklapaju
                if (password == confirmPassword) {
                    // Pokušaj kreiranja novog korisnika
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Uspešna registracija - prelazak na glavni ekran
                                startActivity(Intent(this, MainActivity::class.java))
                                finish()
                            } else {
                                // Neuspešna registracija - prikazivanje greške
                                Toast.makeText(this, "Registration failed: ${task.exception?.message}",
                                    Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    // Lozinke se ne poklapaju - prikazivanje poruke
                    Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Polja nisu popunjena - prikazivanje poruke
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
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