package com.eric.leetcode

class RectangleOverlap {
    fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
        val x1 = rec1[0]
        val y1 = rec1[1]
        val x2 = rec1[2]
        val y2 = rec1[3]

        val x3 = rec2[0]
        val y3 = rec2[1]
        val x4 = rec2[2]
        val y4 = rec2[3]

        if(x1 >= x3 && x1 < x4) {
            if (y1 >= y3 && y1 < y4) {
                return true
            } else if (y1 >= y4) {
                return false
            } else {
                if (y2 > y3) {
                    return true
                } else {
                    return false
                }
            }
        } else if (x1 >= x4) {
            return false
        } else {
            if (x2 > x3) {
                if (y1 >= y3 && y1 < y4) {
                    return true
                } else if (y1 >= y4) {
                    return false
                } else {
                    if (y2 > y3) {
                        return true
                    } else {
                        return false
                    }
                }
            } else {
                return false
            }
        }
    }
}

fun main(args: Array<String>) {
    val rectangleOverlap = RectangleOverlap()
    println(rectangleOverlap.isRectangleOverlap(intArrayOf(-7,-3,10,5), intArrayOf(-6,-5,5,10)))
}