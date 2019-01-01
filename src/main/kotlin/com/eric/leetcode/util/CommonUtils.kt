package com.eric.leetcode.util

object CommonUtils {
    fun <T> printArray(array: Array<T>) {
        for (i in array.indices) {
            print(array[i])
            if (i != array.lastIndex) {
                print(", ")
            }
        }
    }

    fun print2DIntArray(array: Array<IntArray>) {
        for (i in array.indices) {
            for (j in array[0].indices) {
                print(array[i][j])
                if (j != array[0].lastIndex) {
                    print(", ")
                } else {
                    print("\n")
                }
            }
        }
    }
}