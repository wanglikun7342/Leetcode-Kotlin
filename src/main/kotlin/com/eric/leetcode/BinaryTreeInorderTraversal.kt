package com.eric.leetcode

class BinaryTreeInorderTraversal {
    private val result = mutableListOf<Int>()

    fun inorderTraversal(root: TreeNode?): List<Int> {
        result.clear()
        dfs(root)
        return result
    }

    private fun dfs(root: TreeNode?) {
        if (root == null) {
            return
        }
        dfs(root.left)
        result.add(root.`val`)
        dfs(root.right)
    }
}