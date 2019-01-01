package com.eric.leetcode

class JewelsAndStones {
    fun numJewelsInStones(J: String, S: String): Int {
        val map = mutableSetOf<Char>()
        var count = 0
        for (ch in J) {
            map.add(ch)
        }
        for (ch in S) {
            if (map.contains(ch)) {
                count++
            }
        }
        return count
    }
}

fun main(args: Array<String>) {
    val J = "aA"
    val S = "aAAbbbb"
    val jewelsAndStones = JewelsAndStones()
    val result = jewelsAndStones.numJewelsInStones(J, S)
    println("result: $result")
}