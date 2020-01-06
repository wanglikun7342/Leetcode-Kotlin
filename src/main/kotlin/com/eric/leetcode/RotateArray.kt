package com.eric.leetcode

class RotateArray {
    fun rotate(nums: IntArray, k: Int): Unit {
        for (step in 1..k) {
            val last = nums.last()
            for (index in nums.lastIndex downTo 1) {
                nums[index] = nums[index - 1]
            }
            nums[0] = last
        }
    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(-1,-100,3,99)
    val rotateArray = RotateArray()
    rotateArray.rotate(input, 2)
    println(input.toList())
}