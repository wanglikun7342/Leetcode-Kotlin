package com.eric.leetcode

class DetectCapitalUse {
    fun detectCapitalUse(word: String): Boolean {
        return isAllLower(word) || isAllUpper(word) || isFirstUpper(word)
    }

    fun isLowerChar(char: Char): Boolean {
        if (char in 'a'..'z') {
            return true
        }
        return false
    }

    fun isUpperChar(char: Char): Boolean {
        if (char in 'A'..'Z') {
            return true
        }
        return false
    }

    fun isAllUpper(word: String): Boolean {
        for (i in word.indices) {
            if (isLowerChar(word[i])) {
                return false
            }
        }
        return true
    }

    fun isAllLower(word: String): Boolean {
        for (i in word.indices) {
            if (isUpperChar(word[i])) {
                return false
            }
        }
        return true
    }

    fun isFirstUpper(word: String): Boolean {
        if (!isUpperChar(word[0])) {
            return false
        }
        for (i in 1..word.lastIndex) {
            if (isUpperChar(word[i])) {
                return false
            }
        }
        return true
    }
}

fun main(args: Array<String>) {
    val word = "HellO"
    val detectCapitalUse = DetectCapitalUse()
    println("Ascii: A: " + 'A'.toInt() + ", Z: " + 'Z'.toInt() + ", a: " + 'a'.toInt() + ", z: " + 'z'.toInt())
    println("result: " + detectCapitalUse.detectCapitalUse(word))
}