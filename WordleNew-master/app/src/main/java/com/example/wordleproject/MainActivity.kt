package com.example.wordleproject

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val fourLetterWordList = listOf("Fork", "Ball", "Peak") // Add more words as needed
    private var currentGuess = 0 // Track the current guess

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.Guessbutton)

        val guess1 = findViewById<TextView>(R.id.Guess1)
        val guess1check = findViewById<TextView>(R.id.Guess1Check)
        val guess2 = findViewById<TextView>(R.id.Guess2)
        val guess2check = findViewById<TextView>(R.id.Guess2Check)
        val guess3 = findViewById<TextView>(R.id.Guess3)
        val guess3check = findViewById<TextView>(R.id.Guess3Check)
        val et_simple: EditText = findViewById<EditText>(R.id.et_simple)



        button.setOnClickListener {
            val strValue: String = et_simple.text.toString()
            if (strValue.isNotBlank()) {
                when (currentGuess) {
                    0 -> {
                        guess1.text = strValue
                        guess1check.text = if (strValue.equals(fourLetterWordList[currentGuess], ignoreCase = true)) "Correct" else "Incorrect"
                    }
                    1 -> {
                        guess2.text = strValue
                        guess2check.text = if (strValue.equals(fourLetterWordList[currentGuess], ignoreCase = true)) "Correct" else "Incorrect"
                    }
                    2 -> {
                        guess3.text = strValue
                        guess3check.text = if (strValue.equals(fourLetterWordList[currentGuess], ignoreCase = true)) "Correct" else "Incorrect"
                    }
                }
                currentGuess++
                et_simple.text.clear() // Clear EditText after each guess
                Toast.makeText(this, "Nice Guess", Toast.LENGTH_SHORT).show()
                if (currentGuess > 2) {
                    button.isEnabled = false // Disable button after all guesses are made
                }
            } else {
                Toast.makeText(this, "Please enter a word", Toast.LENGTH_SHORT).show()
            }
        }
    }
}