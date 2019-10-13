package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
    }

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    private fun initViews() {

        btnLower.setOnClickListener {
            onLowerClick()
        }
        btnEqual.setOnClickListener {
            onEqualClick()
        }
        btnHigher.setOnClickListener {
            onHigherClick()
        }

        UpdateUI()
    }
    private fun UpdateUI() {

        LastThrow.text = getString(R.string.last_throw, lastThrow)

        when (currentThrow) {
            1 -> dice.setImageResource(R.drawable.dice1)
            2 -> dice.setImageResource(R.drawable.dice2)
            3 -> dice.setImageResource(R.drawable.dice3)
            4 -> dice.setImageResource(R.drawable.dice4)
            5 -> dice.setImageResource(R.drawable.dice5)
            6 -> dice.setImageResource(R.drawable.dice6)
        }
    }

    private  fun rollDice() {

        lastThrow = currentThrow
        currentThrow = (1..6).random()
        UpdateUI()
    }

    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }
    private fun onAnswerInCorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }
    private fun onHigherClick() {
        rollDice()

        if (currentThrow > lastThrow) {
            onAnswerCorrect()
        }
        else onAnswerInCorrect()
    }
    private  fun onEqualClick() {
        rollDice()

        if (currentThrow == lastThrow) {
            onAnswerCorrect()
        } else onAnswerInCorrect()
    }
    private fun onLowerClick() {
        rollDice()

        if (currentThrow < lastThrow){
            onAnswerCorrect()
        }
        else onAnswerInCorrect()
    }
}
