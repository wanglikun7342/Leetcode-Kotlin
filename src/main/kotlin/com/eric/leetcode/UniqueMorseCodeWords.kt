package com.eric.leetcode

class UniqueMorseCodeWords {
    private val morse = arrayOf(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..")

    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val mutableSet = words
                .map { trans(it) }
                .toSet()
        return mutableSet.size
    }

    private fun trans(str : String): String {
        val sb = StringBuilder()
        for (ch in str) {
            sb.append(morse[ch.toInt() % 'a'.toInt()])
        }
        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val words = arrayOf("gin", "zen", "gig", "msg")
    val uniqueMorseCodeWords = UniqueMorseCodeWords()
    println(uniqueMorseCodeWords.uniqueMorseRepresentations(words))
}