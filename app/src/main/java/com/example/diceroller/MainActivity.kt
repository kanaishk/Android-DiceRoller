package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Roller Button Implementation
        val luckyNum: Int = (1..6).random()
        val rollButton: Button = findViewById(R.id.rollButton)

        rollButton.setOnClickListener {
            rollDice(luckyNum)
        }
        rollDice(luckyNum)
    }

    private fun rollDice(luckyNum: Int) {
        val myDice = Dice(6)

        val rollResultText: TextView = findViewById(R.id.rollResultText)
        val rollResult:Int = myDice.roll()
        rollResultText.text = rollResult.toString()

        val diceImage: ImageView = findViewById(R.id.diceImage)
        val rollDiceDrawableResource = when(rollResult) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(rollDiceDrawableResource)
        diceImage.contentDescription = rollResult.toString()

        val toastMsg: String = if(rollResult == luckyNum) {
            "You win!"
        } else {
            "You didn't win, try again!"
        }
        val toastEle = Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT)
        toastEle.show()
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