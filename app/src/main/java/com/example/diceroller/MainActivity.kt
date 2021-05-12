package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        // do a dice roll dice when app starts
        rollDice()
    }

    /*
     roll the dice and update the screen with the result
     */
    private fun rollDice() {
        // create a new dice object with 6 sides to roll it
        val dice = Dice(6)
        // call roll method and store the result in diceRoll
        val diceRoll = dice.roll()
        // find the imageView by id
        val diceImage: ImageView = findViewById(R.id.imageView)
        // set the image resource of the ImageView based on the value of diceRoll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // update the ImageView with the correct drawable resource id
        diceImage.setImageResource(drawableResource)
        // update content Description for screen readers
        diceImage.contentDescription = diceRoll.toString()
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