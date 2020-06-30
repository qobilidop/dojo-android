package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var diceText : TextView
    lateinit var diceImage : ImageView
    lateinit var rollButton : Button
    lateinit var cheatButton : Button
    lateinit var clearButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceText = findViewById(R.id.dice_text)
        diceImage = findViewById(R.id.dice_image)
        rollButton = findViewById(R.id.roll_button)
        cheatButton = findViewById(R.id.cheat_button)
        clearButton = findViewById(R.id.clear_button)

        rollButton.setOnClickListener { roll() }
        cheatButton.setOnClickListener { cheat() }
        clearButton.setOnClickListener { clear() }
    }

    private fun roll() {
        toast("roll button clicked")
        setDice((1..6).random())
    }

    private fun cheat() {
        toast("cheat button clicked")
        val diceInt = getDiceInt()
        if (diceInt != null && diceInt < 6) {
            setDice(diceInt + 1)
        }
    }

    private fun clear() {
        toast("clear button clicked")
        setDice(null)
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun getDiceInt() = diceText.text.toString().toIntOrNull()

    private fun setDice(diceInt: Int?) {
        if (diceInt != null) {
            diceText.text = diceInt.toString()
        } else {
            diceText.text = ""
        }

        val drawableResource = when (diceInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        diceImage.setImageResource(drawableResource)
    }
}