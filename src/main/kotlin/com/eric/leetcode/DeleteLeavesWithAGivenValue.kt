package com.eric.leetcode

class DeleteLeavesWithAGivenValue {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        if (root == null) {
            return root
        }
        return dfs(root, target)
    }

    private fun dfs(root: TreeNode, target: Int): TreeNode? {
        root.left = root.left?.let { dfs(it, target) }
        root.right = root.right?.let { dfs(it, target) }
        if (root.left == null && root.right == null && root.`val` == target) {
            return null
        }
        return root
    }
}