package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class ShortestDistanceToACharacter {
    fun shortestToChar(S: String, C: Char): IntArray {
        val result = mutableListOf<Int>()
        var pre = Int.MIN_VALUE / 2
        for (index in S.indices) {
            if (S[index] == C) {
                pre = index
            }
            result.add(index - pre)
        }
        pre = Int.MAX_VALUE / 2
        for (index in S.lastIndex downTo 0) {
            if (S[index] == C) {
                pre = index
            }
            result[index] = Math.min(result[index], pre - index)
        }
        return result.toIntArray()
    }
}

fun main(args: Array<String>) {
    val shortestDistanceToACharacter = ShortestDistanceToACharacter()
    val S = "loveleetcode"
    val C = 'e'
    CommonUtils.printArray(shortestDistanceToACharacter.shortestToChar(S, C).toTypedArray())
}