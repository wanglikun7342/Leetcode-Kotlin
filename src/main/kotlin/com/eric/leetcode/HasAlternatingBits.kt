package com.eric.leetcode

class HasAlternatingBits {
    fun hasAlternatingBits(n: Int): Boolean {
        val binary_n = Integer.toBinaryString(n)
        return (0..binary_n.length).none { it + 1 < binary_n.length && binary_n[it] == binary_n[it +1] }
    }
}

fun main(args: Array<String>) {
    val h = HasAlternatingBits()
    val result = h.hasAlternatingBits(4)
    println("result: " + result)
}