package com.eric.leetcode

class ObliquePrint {
    fun obliquePrint(array: Array<IntArray>) {
        var i = 0
        var j = 0
        while (j in array[0].indices) {
            var x = i
            var y = j
            while (x in array.indices && y in array[0].indices) {
                print("   ${array[x][y]}")
                x++
                y--
            }
            j++
        }

        i = 1
        j = array[0].lastIndex

        while (i in array.indices) {
            var x = i
            var y = j
            while (x in array.indices && y in array[0].indices) {
                print("   ${array[x][y]}")
                x++
                y--
            }
            i++
        }
    }
}

fun main(args: Array<String>) {
    val array = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12))
    val obliquePrint = ObliquePrint()
    obliquePrint.obliquePrint(array)
}