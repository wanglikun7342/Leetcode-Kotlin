package com.eric.leetcode

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.pow

class PrintBinaryTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun printTree(root: TreeNode?): List<List<String>> {
        val depth = dfs(root)
        val result = Array(depth) { Array(2.toDouble().pow(depth).toInt() - 1) { "" } }
        print(result, root, 0, 0, (result[0].size - 1) / 2)
        return result.map { it.toList() }
    }

    private fun print(result: Array<Array<String>>, root: TreeNode?, base: Int, level: Int, offset: Int) {
        if (root == null) {
            return
        }
        val new = base + offset
        result[level][new] = root.`val`.toString()
        print(result, root.left, new, level + 1, -((abs(new - base) - 1) / 2 + 1))
        print(result, root.right, new, level + 1, (abs(new - base) - 1) / 2 + 1)
    }

    private fun dfs(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return max(dfs(root.left) + 1, dfs(root.right) + 1)
    }
}

fun main() {
    val root = PrintBinaryTree.TreeNode(1)
    val left = PrintBinaryTree.TreeNode(2)
    root.left = left
    val right = PrintBinaryTree.TreeNode(5)
    root.right = right
    left.left = PrintBinaryTree.TreeNode(3)
    left.left?.left = PrintBinaryTree.TreeNode(4)
    val printBinaryTree = PrintBinaryTree()
    val result = printBinaryTree.printTree(root)
}