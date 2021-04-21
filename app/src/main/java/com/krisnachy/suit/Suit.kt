package com.krisnachy.suit

import kotlin.random.Random
import kotlin.random.nextInt

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
                    if (com == 2) {
                        comScore += 1
                        result = "LOSE"
                    }
                    if (com == 3) {
                        userScore += 1
                        result = "WIN"
                    }
                }
                2 -> {
                    if (com == 1) {
                        userScore += 1
                        result = "WIN"
                    }
                    if (com == 3) {
                        comScore += 1
                        result = "LOSE"
                    }
                }
                3 -> {
                    if (com == 1) {
                        comScore += 1
                        result = "LOSE"
                    }
                    if (com == 2) {
                        userScore += 1
                        result = "WIN"
                    }
                }
            }
        }
        return result
    }
}