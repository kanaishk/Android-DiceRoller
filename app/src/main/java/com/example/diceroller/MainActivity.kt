package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Roller Button Implementation
        val rollButton: Button = findViewById(R.id.rollButton)

        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val myDice = Dice(6)
        val toastMsg = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
        toastMsg.show()
        val rollResultText: TextView = findViewById(R.id.rollResultText)
        rollResultText.text = myDice.roll().toString()
    }
}

class Dice(numSides: Int) {
    private var range:IntRange

    init {
        range = 1..numSides
    }

    fun roll(): Int {
        return range.random()
    }
}