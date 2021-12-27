package com.eric.leetcode

import kotlin.text.StringBuilder

class SortingTheSentence {
    fun sortSentence(s: String): String {
        val sb = StringBuilder()
        val map = mutableMapOf<Int, String>()
        s.forEachIndexed { index, it ->
            if (it.isDigit()) {
                map[it.toString().toInt()] = sb.toString()
                sb.clear()
            } else if (!it.isWhitespace()) {
                sb.append(it)
            }
        }
        val result = StringBuilder()
        for (index in 1..map.size) {
            result.append(map[index])
            result.append(" ")
        }
        return result.trim().toString()
    }
}

fun main() {
    val input = "is2 sentence4 This1 a3"
    val sortingTheSentence = SortingTheSentence()
    sortingTheSentence.sortSentence(input)
}