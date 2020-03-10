package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class CircularPermutationInBinaryRepresentation {
    fun circularPermutation(n: Int, start: Int): List<Int> {
        val vis = BooleanArray((1).shl(n)) { // 2^n
            false
        }
        val ans = mutableListOf<Int>()
        ans.add(start)
        vis[start] = true
        var cur = start
        for (i in 0 until (1).shl(n)) { // 2^n
            for (j in 0 until n) {
                val t = cur.xor((1).shl(j))
                if (!vis[t]) {
                    cur = t
                    vis[t] = true
                    ans.add(cur)
                    break
                }
            }
        }
        return ans
    }
}

fun main(args: Array<String>) {
    val circularPermutationInBinaryRepresentation = CircularPermutationInBinaryRepresentation()
    CommonUtils.printArray(circularPermutationInBinaryRepresentation.circularPermutation(3, 2).toTypedArray())
}