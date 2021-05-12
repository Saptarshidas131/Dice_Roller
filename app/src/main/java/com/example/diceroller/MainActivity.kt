package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/*
 * This activity allows the user to roll a dice and view the result on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find the button with the id of the button
        val rollButton: Button = findViewById(R.id.button)
        // set on click listener on the button and call rollDice function on button click
        rollButton.setOnClickListener { rollDice() }
    }

    /*
     roll the dice and update the screen with the result
     */
    private fun rollDice() {
        // create a new dice object with 6 sides to roll it
        val dice = Dice(6)
        // call roll method and store the result in diceRoll
        val diceRoll = dice.roll()

        // update the screen with dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        // convert the result to String and set it to the text attribute of TextView instance resultTextView
        resultTextView.text = diceRoll.toString()
    }
}

// create Dice class with fixed number of sides
class Dice(private val numSides: Int) {
    // roll method to return a random number within range 1 to 6(inclusive)
    fun roll(): Int {
        // randomly generate a number from 1 to numSides and return
        return (1..numSides).random()
    }
}