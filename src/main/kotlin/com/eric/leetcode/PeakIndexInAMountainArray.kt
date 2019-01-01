package com.eric.leetcode

class PeakIndexInAMountainArray {
    fun peakIndexInMountainArray(A: IntArray): Int {
        var peakIndex = 0
        for (i in A.indices) {
            if (A[i] > A[peakIndex]) {
                peakIndex = i
            }
        }
        return peakIndex
    }
}

fun main(args: Array<String>) {
    val array = intArrayOf(0,1,0)
    val peakIndexInAMountainArray = PeakIndexInAMountainArray()
    println("result: ${peakIndexInAMountainArray.peakIndexInMountainArray(array)}")
}