package com.example.srbingo

// Potrebni importi za funkcionalnost aplikacije
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.srbingo.databinding.ActivityMainBinding
import com.example.srbingo.databinding.DialogLevelOptionsBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.example.srbingo.utils.DatabaseSeeder
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.example.srbingo.model.UserProgress
import com.example.srbingo.utils.MusicManager

// Glavna aktivnost aplikacije koja prikazuje listu nivoa
class MainActivity : AppCompatActivity() {
    // Inicijalizacija potrebnih varijabli
    private lateinit var binding: ActivityMainBinding // Povezivanje sa XML layoutom
    private val db = FirebaseFirestore.getInstance() // Instanca Firestore baze
    private val auth = FirebaseAuth.getInstance() // Instanca Firebase autentifikacije
    private var userProgress: UserProgress? = null // Praćenje napretka korisnika
    private lateinit var musicManager: MusicManager // Upravljanje pozadinskom muzikom
    private var isMusicPlaying = true // Status reprodukcije muzike

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Postavljanje layouta
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the MaterialToolbar as the app bar
        setSupportActionBar(binding.topAppBar)

        // Inicijalizacija muzike
        musicManager = MusicManager.getInstance(applicationContext)
        musicManager.startMusic()

        // Učitavanje napretka korisnika
        loadUserProgress()

        // Postavljanje dugmeta za kontrolu muzike
        binding.musicToggleButton.setOnClickListener {
            if (isMusicPlaying) {
                musicManager.pauseMusic()
                binding.musicToggleButton.setImageResource(R.drawable.ic_music_off)
            } else {
                musicManager.startMusic()
                binding.musicToggleButton.setImageResource(R.drawable.ic_music_on)
            }
            isMusicPlaying = !isMusicPlaying
        }
    }

    // Funkcija za učitavanje napretka korisnika iz Firestore baze
    private fun loadUserProgress() {
        val userId = auth.currentUser?.uid ?: return
        
        binding.loadingProgressBar?.visibility = View.VISIBLE
        
        db.collection("userProgress")
            .document(userId)
            .get()
            .addOnSuccessListener { document ->
                userProgress = document.toObject(UserProgress::class.java) ?: UserProgress(userId)
                setupLevelsRecyclerView()
                binding.loadingProgressBar?.visibility = View.GONE
            }
            .addOnFailureListener {
                userProgress = UserProgress(userId)
                setupLevelsRecyclerView()
                binding.loadingProgressBar?.visibility = View.GONE
            }
    }

    // Postavljanje liste nivoa u RecyclerView
    private fun setupLevelsRecyclerView() {
        // Opisi za svaki nivo
        val levelDescriptions = mapOf(
            1 to "Prevod reči",
            2 to "Proste rečenice",
            3 to "Present simple and present continuous",
            4 to "Naprednije rečenice",
            5 to "Present simple and past simple",
            6 to "Present and past napredno",
            7 to "Buduća vremena",
            8 to "Modalni glagoli",
            9 to "Kondicionali",
            10 to "Idiomi i fraze"
        )

        // Kreiranje liste nivoa
        val levels = (1..10).map { number ->
            Level(
                number = number,
                description = levelDescriptions[number] ?: "",
                isLocked = !(userProgress?.canAccessLevel(number) ?: (number == 1))
            )
        }

        // Postavljanje RecyclerView adaptera
        binding.levelsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = LevelsAdapter(levels) { level ->
                if (!level.isLocked) {
                    showLevelOptionsDialog(level)
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.level_locked),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    // Prikazivanje dijaloga za izbor moda igre
    private fun showLevelOptionsDialog(level: Level) {
        val dialogBinding = DialogLevelOptionsBinding.inflate(layoutInflater)
        dialogBinding.dialogTitleText.text = getString(R.string.select_mode)

        MaterialAlertDialogBuilder(this)
            .setView(dialogBinding.root)
            .create()
            .apply {
                // Postavljanje dugmeta za tekstualni mod
                dialogBinding.textModeButton.setOnClickListener {
                    val intent = if (level.number == 3 || level.number == 5) {
                        Intent(this@MainActivity, TextModeTwoOptionsActivity::class.java)
                    } else {
                        Intent(this@MainActivity, TextModeActivity::class.java)
                    }
                    intent.putExtra("level", level.number)
                    startActivity(intent)
                    dismiss()
                }
                // Postavljanje dugmeta za mod vežbanja
                dialogBinding.practiceButton.setOnClickListener {
                    val intent = if (level.number == 3 || level.number == 5) {
                        Intent(this@MainActivity, PracticeModeTwoOptionsActivity::class.java)
                    } else {
                        Intent(this@MainActivity, PracticeModeActivity::class.java)
                    }
                    intent.putExtra("level", level.number)
                    startActivity(intent)
                    dismiss()
                }
            }.show()
    }

    // Upravljanje životnim ciklusom aktivnosti
    override fun onPause() {
        super.onPause()
        musicManager.pauseMusic()
    }

    override fun onResume() {
        super.onResume()
        musicManager.startMusic()
        loadUserProgress()
    }

    override fun onDestroy() {
        super.onDestroy()
        musicManager.release()
    }
}