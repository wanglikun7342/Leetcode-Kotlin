package com.eric.leetcode

class BinaryTreeLevelOrderTraversal {
    val result = mutableMapOf<Int, MutableList<Int>>()
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        dfs(root, 0)
        return result.values.toList()
    }

    private fun dfs(root: TreeNode?, level: Int) {
        if (root == null) {
            return
        }
        val list = result.getOrDefault(level, mutableListOf())
        list.add(root.`val`)
        result[level] = list
        dfs(root.left, level + 1)
        dfs(root.right, level + 1)
    }
}