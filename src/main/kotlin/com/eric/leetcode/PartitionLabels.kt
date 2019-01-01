package com.eric.leetcode

class PartitionLabels {
    fun partitionLabels(S: String): List<Int> {
        val result = mutableListOf<Int>()

        val last = IntArray(26)

        for (i in S.indices) {
            last[S[i] - 'a'] = i
        }

        var j = 0
        var anchor = 0
        for (i in S.indices) {
            j = maxOf(j, last[S[i] - 'a'])
            if (i == j) {
                result.add(i - anchor + 1)
                anchor = i + 1
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val partitionLabels = PartitionLabels()
    var string = "ababcbacadefegdehijhklij"
    println(partitionLabels.partitionLabels(string))
}