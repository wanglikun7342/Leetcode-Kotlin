package com.eric.leetcode

class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        var width = 0
        points.sortWith(compareBy { it[0] })
        for (index in 0 until points.lastIndex) {
            if (points[index+1][0] - points[index][0] > width) {
                width = points[index+1][0] - points[index][0]
            }
        }
        return width
    }
}

fun main() {

}