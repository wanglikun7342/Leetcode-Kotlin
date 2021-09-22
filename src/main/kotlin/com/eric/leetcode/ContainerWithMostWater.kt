package com.eric.leetcode

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var i = 0
        var j = height.lastIndex
        var max = minOf(height[i], height[j]) * (j - i)
        while (i < j) {
            val cur = minOf(height[i], height[j]) * (j - i)
            if (cur > max) {
                max = cur
            }
            if (height[i] < height[j]) {
                i++
            } else {
                j--
            }
        }
        return max
    }
}