package com.eric.leetcode

import kotlin.math.abs

class MinimumTimeVisitingAllPoints {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var result = 0
        for (index in 0 until points.lastIndex) {
            val cur = points[index]
            val next = points[index+1]
            result += maxOf(abs(cur[0] - next[0]), abs( cur[1] - next[1]))
        }
        return result
    }
}