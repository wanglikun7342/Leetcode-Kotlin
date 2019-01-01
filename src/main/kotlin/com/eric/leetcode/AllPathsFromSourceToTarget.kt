package com.eric.leetcode

class AllPathsFromSourceToTarget {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        path.add(0)
        dfsSearch(graph, path, result, 0)
        path.remove(0)
        return result
    }

    private fun dfsSearch(graph: Array<IntArray>, path: MutableList<Int>, result: MutableList<List<Int>>, node: Int) {
        if (node == graph.lastIndex) {
            result.add(ArrayList<Int>(path))
            return
        }
        for (nextNode in graph[node]) {
            path.add(nextNode)
            dfsSearch(graph, path, result, nextNode)
            path.remove(nextNode)
        }
    }
}

fun main(args: Array<String>) {
    val arrays = arrayOf(intArrayOf(1,2), intArrayOf(3), intArrayOf(3), intArrayOf())
    val allPathsFromSourceToTarget = AllPathsFromSourceToTarget()
    val result = allPathsFromSourceToTarget.allPathsSourceTarget(arrays)
}