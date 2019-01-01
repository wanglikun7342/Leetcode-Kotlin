package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class DIStringMatch {
    fun diStringMatch(S: String): IntArray {
        var ins = S.length
        var des = 0
        val result = arrayOfNulls<Int>(S.length + 1)
        var index = 0
        for (ch in S) {
            if(ch == 'I') {
                result[index] = des
                des++
            } else {
                result[index] = ins
                ins--
            }
            index++
        }
        // result[index] = ins
        result[index] = des
        return result.requireNoNulls().toIntArray()
    }
}

fun main(args: Array<String>) {
    val input = "IIID"
    val diStringMatch = DIStringMatch()
    CommonUtils.printArray(diStringMatch.diStringMatch(input).toTypedArray())
}