package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class FindEventualSafeStates {
    private lateinit var mColor : Array<Int>
    private lateinit var mGraph : Array<IntArray>

    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        // 图缓存
        mGraph = graph
        // 图着色，0代表未着色，1代表不安全节点，2代表安全节点
        mColor = Array(graph.size, {0})
        return graph.indices.filter { dfs(it) }
    }

    // 深度优先遍历
    private fun dfs(node : Int) : Boolean {
        if (mColor[node] > 0) {
            // 已被着色过返回是否为安全节点
            return mColor[node] == 2
        }
        // 着色
        mColor[node] = 1

        for (subNode in mGraph[node]) {
            val isSafe = dfs(subNode)
            if (!isSafe) {
                // 子节点是非安全节点，则该节点是非安全节点
                return false
            }
        }
        // 所有子节点都是安全节点，则为安全节点
        mColor[node] = 2
        return true
    }
}

// [[1,2,3,4],[1,2],[3,4],[0,4],[]]
fun main(args: Array<String>) {
    val graph = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(0, 4), intArrayOf())
    val findEventualSafeStates = FindEventualSafeStates()
    CommonUtils.printArray(findEventualSafeStates.eventualSafeNodes(graph).toTypedArray())
}