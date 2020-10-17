package com.eric.leetcode

class CountNumberOfTeams {
    fun numTeams(rating: IntArray): Int {
        var result = 0
        for (i in 0 until rating.lastIndex - 1) {
            val first = rating[i]
            for (j in i + 1 until rating.lastIndex) {
                val second = rating[j]
                for (k in j + 1..rating.lastIndex) {
                    val third = rating[k]
                    if (second in (first + 1) until third || second in (third + 1) until first) {
                        result++
                    }
                }
            }
        }
        return result
    }
}

fun main() {
    val rating = intArrayOf(2, 5, 3, 4, 1)
    val countNumberOfTeams = CountNumberOfTeams()
    print(countNumberOfTeams.numTeams(rating))
}