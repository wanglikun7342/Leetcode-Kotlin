package com.eric.leetcode

class FactorialTrailingZeroes {
    fun trailingZeroes(input: Int): Int {
        var n = input
        var result = 0
        while (n > 0) {
            n /= 5
            result += n
        }
        return result
    }
}

fun main(args: Array<String>) {
    val factorialTrailingZeroes = FactorialTrailingZeroes()
    print(factorialTrailingZeroes.trailingZeroes(14))
}