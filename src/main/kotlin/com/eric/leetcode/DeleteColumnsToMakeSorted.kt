package com.eric.leetcode

class DeleteColumnsToMakeSorted {
    fun minDeletionSize(A: Array<String>): Int {
        var lastChar: Char
        var result = 0
        for (j in A[0].indices) {
            lastChar = 'a'
            for (i in A.indices) {
                if (A[i][j] < lastChar) {
                    result++
                    break
                }
                lastChar = A[i][j]
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val input = arrayOf("zyx","wvu","tsr")
    val deleteColumnsToMakeSorted = DeleteColumnsToMakeSorted()
    println(deleteColumnsToMakeSorted.minDeletionSize(input))
}