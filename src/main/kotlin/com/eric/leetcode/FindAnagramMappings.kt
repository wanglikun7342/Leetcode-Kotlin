package com.eric.leetcode

class FindAnagramMappings {
    fun anagramMappings(A: IntArray, B: IntArray): IntArray {
        val result = arrayListOf<Int>()
        for (i in A.indices) {
            for (j in B.indices) {
                if (A[i] == B[j]) {
                    result.add(j)
                    break
                }
            }
        }
        return result.toIntArray()
    }
}

fun main(args: Array<String>) {
    val A = intArrayOf(12, 28, 46, 32, 50)
    val B = intArrayOf(50, 12, 32, 46, 28)
    val findAnagramMappings = FindAnagramMappings()
    val result = findAnagramMappings.anagramMappings(A, B)
    for (e in result) {
        print("$e ,")
    }
}