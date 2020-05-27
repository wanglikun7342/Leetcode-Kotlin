package com.eric.leetcode

class ClumsyFactorial {
    fun clumsy(N: Int): Int {
        var result = 0
        var cur = N
        var temp = 0
        while (cur > 0) {
            val case = (N - cur) % 4
            when(case) {
                3 -> {
                    result += cur
                }
                0 -> temp = cur
                1 -> temp *= cur
                2 -> temp /= cur
            }
            cur--
            if (case == 3 || cur == 0) {
                if (N - cur <= 4) {
                    result += temp
                } else {
                    result -= temp
                }
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val input = 10
    val clumsyFactorial = ClumsyFactorial()
    print(clumsyFactorial.clumsy(input))
}