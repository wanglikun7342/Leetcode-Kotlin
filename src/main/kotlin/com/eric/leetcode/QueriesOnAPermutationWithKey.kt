package com.eric.leetcode

class QueriesOnAPermutationWithKey {
    // todo FenwickTree
    fun processQueries(queries: IntArray, m: Int): IntArray {
        val result = IntArray(queries.size) { 0 }
        val p = mutableListOf<Int>()
        for (index in 1..m) {
            p.add(index)
        }
        for (index in 0..queries.lastIndex) {
            val query = queries[index]
            for (i in 0 until m) {
                if (p[i] == query) {
                    result[index] = i
                    p.remove(query)
                    p.add(0, query)
                    break
                }
            }

        }
        return result
    }
}

fun main() {
    val q = QueriesOnAPermutationWithKey()
    q.processQueries(intArrayOf(), 5)
}