package com.eric.leetcode

class DiameterOfBinaryTree {
    var result = 0;
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        diameter(root)
        return result
    }

    private fun diameter(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val left = diameter(root.left)
        val right = diameter(root.right)

        result = maxOf(1 + left + right, result)
        return 1 + maxOf(left, right)
    }
}