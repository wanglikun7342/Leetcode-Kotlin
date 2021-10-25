package com.eric.leetcode

class BinaryTreeLevelOrderTraversalII {
    private val result = mutableMapOf<Int, MutableList<Int>>()
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        result.clear()
        root?.let { search(it, 0) }
        return result.values.reversed()
    }

    private fun search(root: TreeNode, depth: Int) {
        val list = result[depth]
        if (list == null) {
            result[depth] = mutableListOf(root.`val`)
        } else {
            list.add(root.`val`)
        }
        root.left?.let {
            search(it, depth + 1)
        }
        root.right?.let {
            search(it, depth + 1)
        }
    }
}