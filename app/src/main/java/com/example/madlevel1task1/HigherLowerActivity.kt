package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding
import kotlinx.android.synthetic.main.activity_higher_lower.*
import kotlin.math.floor

class HigherLowerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var lastThrow: Int = 1
    private var currentThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    /**
     *Sets the initial state(UI) of the game
     */
    private fun initViews() {
        higherBtn.setOnClickListener {
            onHigherClick()
        }
        lowerBtn.setOnClickListener {
            onLowerClick()
        }
        equalBtn.setOnClickListener {
            onEqualClick()
        }
        updateUI()
    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */
    private fun updateUI() {
        binding.tvLastThrow.text = getString(R.string.lastThrowLabel, lastThrow)
        when(currentThrow) {
            1 -> binding.diceImageV.setImageResource(R.drawable.dice1)
            2 -> binding.diceImageV.setImageResource(R.drawable.dice2)
            3 -> binding.diceImageV.setImageResource(R.drawable.dice3)
            4 -> binding.diceImageV.setImageResource(R.drawable.dice4)
            5 -> binding.diceImageV.setImageResource(R.drawable.dice5)
            6 -> binding.diceImageV.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onAnswerCorrect() {
        return Toast.makeText(this, "Correct answer!", Toast.LENGTH_SHORT).show()
    }

    private fun onAnswerIncorrect() {
        return Toast.makeText(this, "Incorrect answer!", Toast.LENGTH_SHORT).show()
    }

    private fun onEqualClick() {
        rollDice()
        if (currentThrow == lastThrow) {
            onAnswerCorrect()
        } else onAnswerIncorrect()
    }

    private fun onLowerClick() {
        rollDice()
        if (currentThrow < lastThrow) {
            onAnswerCorrect()
        } else onAnswerIncorrect()
    }

    private fun onHigherClick() {
        rollDice()
        if (currentThrow > lastThrow) {
            onAnswerCorrect()
        } else onAnswerIncorrect()
    }
}