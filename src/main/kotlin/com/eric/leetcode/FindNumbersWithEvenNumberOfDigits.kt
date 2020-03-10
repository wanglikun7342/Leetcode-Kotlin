package com.eric.leetcode

class FindNumbersWithEvenNumberOfDigits {
    fun findNumbers(nums: IntArray): Int {
        var sum = 0
        nums.filter { it.toString().length.rem(2) == 0 }.forEach {
            sum++
        }
        return sum
    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(12, 345, 2, 6, 7896)
    val findNumbersWithEvenNumberOfDigits = FindNumbersWithEvenNumberOfDigits()
    print(findNumbersWithEvenNumberOfDigits.findNumbers(input))
}