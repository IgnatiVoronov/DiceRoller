package com.example.diceroller

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.databinding.ActivityMainBinding

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rollButton.setOnClickListener{ rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //The button click made the message pop up
        val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
        toast.show()

        // Update the screen with the dice roll
        binding.textView.text = diceRoll.toString()
        binding.diceImage.setImageResource(when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> {R.drawable.dice_1}
        })

    }
}

/**
 * This is a dice. The number of sides can be set
 */
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}