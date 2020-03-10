package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class SingleNumberIII {
    fun singleNumber(nums: IntArray): IntArray {
        var bitMask = 0
        nums.forEach { bitMask = bitMask.xor(it) }
        val bitPos = bitMask.and(-bitMask)
        var x = 0
        nums.filter { it.and(bitPos) != 0}.forEach {
            x = x.xor(it)
        }
        return intArrayOf(x, bitMask.xor(x))
    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(2, 1, 2, 3, 4, 1)
    val singleNumberIII = SingleNumberIII()
    CommonUtils.printArray(singleNumberIII.singleNumber(input).toTypedArray())
}