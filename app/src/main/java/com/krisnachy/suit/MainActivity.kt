package com.krisnachy.suit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ivUser = findViewById<ImageView>(R.id.iv_user)
        val ivCom = findViewById<ImageView>(R.id.iv_com)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvUser = findViewById<TextView>(R.id.tv_user)
        val tvCom = findViewById<TextView>(R.id.tv_com)
        val btnRock = findViewById<ImageButton>(R.id.btn_rock)
        val btnPaper = findViewById<ImageButton>(R.id.btn_paper)
        val btnScissor = findViewById<ImageButton>(R.id.btn_scissor)
        val btnRematch = findViewById<ImageButton>(R.id.btn_rematch)

        fun showImage(user : Int, com : Int) {
            when(user) {
                1 -> ivUser.setImageResource(R.drawable.ic_rock)
                2 -> ivUser.setImageResource(R.drawable.ic_paper)
                3 -> ivUser.setImageResource(R.drawable.ic_scissors)
            }

            when(com) {
                1 -> ivCom.setImageResource(R.drawable.ic_rock)
                2 -> ivCom.setImageResource(R.drawable.ic_paper)
                3 -> ivCom.setImageResource(R.drawable.ic_scissors)
            }
        }

        btnRock.setOnClickListener {
            val suit = Suit(1)
            val result = suit.set(suit.user, suit.randomCom)
            showImage(suit.user, suit.randomCom)
            tvResult.text = suit.result
        }

        btnPaper.setOnClickListener {
            val suit = Suit(2)
            val result = suit.set(suit.user, suit.randomCom)
            showImage(suit.user, suit.randomCom)
            tvResult.text = suit.result
        }

        btnScissor.setOnClickListener {
            val suit = Suit(3)
            val result = suit.set(suit.user, suit.randomCom)
            showImage(suit.user, suit.randomCom)
            tvResult.text = suit.result
        }

        btnRematch.setOnClickListener {
            ivUser.setImageResource(android.R.color.transparent)
            ivCom.setImageResource(android.R.color.transparent)
        }
    }
}

//rock = 1
//paper = 2
//scissors = 3

class Suit(var user : Int) {
    val randomCom = Random.nextInt(1..3)
    var result = ""
    var userScore = 0
    var comScore = 0

    fun  set(user: Int, com: Int) : String {
        if (user == com) {
            result = "DRAW"
        } else {
            when (user) {
                1 -> {
                    if (com == 2) result = "LOSE"
                    if (com == 3) result = "WIN"
                }
                2 -> {
                    if (com == 1) result = "WIN"
                    if (com == 3) result = "LOSE"
                }
                3 -> {
                    if (com == 1) result = "LOSE"
                    if (com == 2) result = "WIN"
                }
            }
        }
        return result
    }
}