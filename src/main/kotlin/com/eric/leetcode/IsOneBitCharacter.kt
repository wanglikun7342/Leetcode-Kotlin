package com.eric.leetcode

class IsOneBitCharacter {
    fun isOneBitCharacter(bits: IntArray): Boolean {
        var i = 0
        while (i <= bits.lastIndex - 1) {
            if (bits[i] == 0) {
                i++
            } else if (bits[i] == 1) {
                i += 2
            }
        }
        if (i == bits.lastIndex) {
            return true
        }
        return false
    }
}

fun main(args: Array<String>) {
    val array = intArrayOf(0, 0, 0, 0)
    val isOneBitCharacter = IsOneBitCharacter()
    val result = isOneBitCharacter.isOneBitCharacter(array)
    println("result: $result")
}