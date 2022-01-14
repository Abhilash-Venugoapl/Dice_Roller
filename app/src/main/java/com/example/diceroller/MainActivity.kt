package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
        rollDice()
    }

    private fun rollDice() {/**here the result of the rolled dice is stored and displayed*/
        val dice = Dice(6)//sending value of numsides to the dice class for 1st dice.
        val diceRoll = dice.roll()

        //to find the image view in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        //determine the drawable resource id from the dice roll value.
        val drawableResource= when(diceRoll)
        {
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else ->R.drawable.dice_6
        }

        //update the image view with the correct drawable resource id
        diceImage.setImageResource(drawableResource)

        //update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}
class Dice(private val numSides:Int) {/** Rolling of the dice*/
    fun roll(): Int{
        return (1..numSides).random()
    }
}