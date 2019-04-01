package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class EvaluateDivision {
    fun calcEquation(equations: Array<Array<String>>, values: DoubleArray, queries: Array<Array<String>>): DoubleArray {
        val result = mutableListOf<Double>()
        val rels = mutableMapOf<String, MutableMap<String, Double>>()
        for ((index, equation) in equations.withIndex()) {
            val x = equation[0]
            val y = equation[1]
            if (rels.containsKey(x)) {
                rels[x]?.put(y, values[index])
            } else {
                rels.put(x, mutableMapOf(y to values[index]))
            }
            if (rels.containsKey(y)) {
                rels[y]?.put(x, 1.0 / values[index])
            } else {
                rels.put(y, mutableMapOf(x to 1.0 /values[index]))
            }
        }
        for (rel in rels) {
            for (x in rel.value) {
                for (y in rel.value) {
                    rels[x.key]?.put(y.key, y.value / x.value)
                    rels[y.key]?.put(x.key, x.value / y.value)
                }
            }
        }
        for (query in queries) {
            val x = rels[query[0]]
            if (x == null) {
                result.add(-1.0)
            } else {
                val y = x[query[1]]
                if (y == null) {
                    result.add(-1.0)
                } else {
                    result.add(y)
                }
            }
        }
        return result.toDoubleArray()
    }
}

fun main(args: Array<String>) {
    val equations = arrayOf(arrayOf("a", "b"), arrayOf("b", "c"))
    val values = doubleArrayOf(2.0, 3.0)
    val queries = arrayOf(arrayOf("a", "c"), arrayOf("b", "a"), arrayOf("a", "e"), arrayOf("a", "a"), arrayOf("x", "x"))
    val evaluateDivision = EvaluateDivision()
    val result = evaluateDivision.calcEquation(equations, values, queries)
    CommonUtils.printArray(result.toTypedArray())
}