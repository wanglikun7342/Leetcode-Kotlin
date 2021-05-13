package com.eric.leetcode

class FindTheHighestAltitude {
    fun largestAltitude(gains: IntArray): Int {
        val altitudes = mutableListOf<Int>()
        altitudes.add(0)
        for (gain in gains) {
            altitudes.add(gain + altitudes.last())
        }
        return altitudes.max() ?: 0
    }
}