package com.eric.leetcode

class MaxChunksToMakeSorted {
    fun maxChunksToSorted(arr: IntArray): Int {
        var sum = 0
        var result = 0
        for (el in arr.withIndex()) {
            sum += el.value
            sum -= el.index
            if (sum == 0) {
                result+=1
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(0, 2, 1)
    val maxChunksToMakeSorted = MaxChunksToMakeSorted()
    print(maxChunksToMakeSorted.maxChunksToSorted(input))
}