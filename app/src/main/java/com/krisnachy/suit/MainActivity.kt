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

        fun changeBackground(result : String) {
            when(result) {
                "DRAW" -> tvResult.setBackgroundResource(R.drawable.ic_rectangle_draw)
                "LOSE" -> tvResult.setBackgroundResource(R.drawable.ic_rectangle_lose)
                "WIN" -> tvResult.setBackgroundResource(R.drawable.ic_rectangle_win)
            }
        }

        btnRock.setOnClickListener {
            val suit = Suit(1)
            val score = suit.set(suit.user, suit.randomCom)
            showImage(suit.user, suit.randomCom)
            changeBackground(suit.result)
            tvResult.text = suit.result
            tvUser.text = suit.userScore.toString()
            tvCom.text = suit.comScore.toString()
        }

        btnPaper.setOnClickListener {
            val suit = Suit(2)
            val score = suit.set(suit.user, suit.randomCom)
            showImage(suit.user, suit.randomCom)
            changeBackground(suit.result)
            tvResult.text = suit.result
            tvUser.text = suit.userScore.toString()
            tvCom.text = suit.comScore.toString()
        }

        btnScissor.setOnClickListener {
            val suit = Suit(3)
            val score = suit.set(suit.user, suit.randomCom)
            showImage(suit.user, suit.randomCom)
            changeBackground(suit.result)
            tvResult.text = suit.result
            tvUser.text = suit.userScore.toString()
            tvCom.text = suit.comScore.toString()
        }

        btnRematch.setOnClickListener {
            ivUser.setImageResource(android.R.color.transparent)
            ivCom.setImageResource(android.R.color.transparent)
            tvResult.setText(R.string.result)
            tvResult.setBackgroundResource(R.drawable.ic_rectangle_result)
            tvUser.setText(R.string.score_user)
            tvCom.setText(R.string.score_com)
        }
    }
}

//rock = 1
//paper = 2
//scissors = 3

