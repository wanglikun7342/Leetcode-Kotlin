package com.eric.leetcode

class FindLargestValueInEachTreeRow {
    private val mutableMap = mutableMapOf<Int, Int>()

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun largestValues(root: TreeNode?): List<Int> {
        findValues(root, 1)
        return mutableMap.values.toList()
    }

    private fun findValues(root: TreeNode?, level: Int) {
        if (root == null) {
            return
        }
        val value = mutableMap[level]
        if (value == null || value < root.`val`) {
            mutableMap.put(level, root.`val`)
        }
        findValues(root.left, level + 1)
        findValues(root.right, level + 1)
    }
}

fun main(args: Array<String>) {
    val root = FindLargestValueInEachTreeRow.TreeNode(5)
    root.left = FindLargestValueInEachTreeRow.TreeNode(3)
    root.right = FindLargestValueInEachTreeRow.TreeNode(6)
    (root.left)?.left = FindLargestValueInEachTreeRow.TreeNode(2)
    (root.left)?.right = FindLargestValueInEachTreeRow.TreeNode(4)
    (root.right)?.right = FindLargestValueInEachTreeRow.TreeNode(7)
    val findLargestValueInEachTreeRow = FindLargestValueInEachTreeRow()
    val result = findLargestValueInEachTreeRow.largestValues(root)
    for (e in result) {
        print("$e, ")
    }
}