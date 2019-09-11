package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }

    private fun initView() {
        btnHigher.setOnClickListener { onHigherClick() }
        btnLower.setOnClickListener { onLowerClick() }
        btnEqual.setOnClickListener { onEqualClick() }
        updateUI();
    }

    private fun updateUI() {
        tvLastThrow.text = getString(R.string.last_throw, lastThrow)

        when (currentThrow) {

//            1 -> Picasso.get().load(R.drawable.d1).into(ivDice)
//            2 -> Picasso.get().load(R.drawable.d2).into(ivDice)
//            3 -> Picasso.get().load(R.drawable.d3).into(ivDice)
//            4 -> Picasso.get().load(R.drawable.d4).into(ivDice)
//            5 -> Picasso.get().load(R.drawable.d5).into(ivDice)
//            6 -> Picasso.get().load(R.drawable.d6).into(ivDice)

            1 -> ivDice.setImageResource(R.drawable.dice1)
            2 -> ivDice.setImageResource(R.drawable.dice2)
            3 -> ivDice.setImageResource(R.drawable.dice3)
            4 -> ivDice.setImageResource(R.drawable.dice4)
            5 -> ivDice.setImageResource(R.drawable.dice5)
            6 -> ivDice.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick() {
        rollDice()
        if (currentThrow > lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    private fun onLowerClick() {
        rollDice()
        if (currentThrow < lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    private fun onEqualClick() {
        rollDice()
        if (currentThrow == lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }

    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }


}
