package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class BeautifulArrangementII {
    fun constructArray(n: Int, k: Int): IntArray {
        val result = IntArray(n) {
            0
        }
        for (index in 0..k step 2) {
            result[index] = index / 2 + 1
        }
        for (index in 1..k step 2) {
            result[index] = k + 1 - index / 2
        }
        for (index in k + 1..(n - 1)) {
            result[index] = index + 1
        }
        return result
    }
}

fun main(args: Array<String>) {
    val beautifulArrangementII = BeautifulArrangementII()
    val result = beautifulArrangementII.constructArray(8, 6)
    CommonUtils.printArray(result.toTypedArray())
}