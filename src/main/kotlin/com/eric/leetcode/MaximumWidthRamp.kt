package com.eric.leetcode

class MaximumWidthRamp {
    fun maxWidthRamp(A: IntArray): Int {
        val indices = A.indices.sortedBy { A[it] }
        var width = 0
        var minIndex = A.lastIndex
        for (index in indices) {
            width = maxOf(width, index - minIndex)
            minIndex = minOf(index, minIndex)
        }
        return width
    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(6, 0, 8, 2, 1, 5)
    val maximumWidthRamp = MaximumWidthRamp()
    print(maximumWidthRamp.maxWidthRamp(input))
}