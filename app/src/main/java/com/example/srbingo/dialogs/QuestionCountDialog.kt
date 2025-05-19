package com.example.srbingo.dialogs

// Potrebni importi za dijalog
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import com.example.srbingo.R
import com.google.android.material.button.MaterialButton

// Dijalog za izbor broja pitanja u igri
class QuestionCountDialog(
    context: Context,
    private val onCountSelected: (Int) -> Unit // Callback funkcija koja se poziva kada korisnik izabere broj pitanja
) : Dialog(context) {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Postavljanje layouta i zabrana zatvaranja dijaloga
        setContentView(R.layout.dialog_question_count)
        setCancelable(false)

        // Dobijanje referenci na view elemente
        val numberPicker = findViewById<NumberPicker>(R.id.questionCountPicker)
        val startButton = findViewById<Button>(R.id.startButton)

        // Konfigurisanje NumberPicker-a za izbor broja pitanja
        numberPicker.apply {
            minValue = 1 // Minimalni broj pitanja
            maxValue = 20 // Maksimalni broj pitanja
            value = 10 // Podrazumevani broj pitanja
        }

        // Postavljanje listener-a za dugme za početak
        startButton.setOnClickListener {
            onCountSelected(numberPicker.value) // Pozivanje callback funkcije sa izabranim brojem
            dismiss() // Zatvaranje dijaloga
        }
    }
} 