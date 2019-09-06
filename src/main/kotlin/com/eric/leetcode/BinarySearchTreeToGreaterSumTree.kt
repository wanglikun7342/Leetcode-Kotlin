package com.eric.leetcode

class BinarySearchTreeToGreaterSumTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private var gst = 0

    fun bstToGst(root: TreeNode?): TreeNode? {
        gst = 0
        dfs(root)
        return root
    }

    private fun dfs(root: TreeNode?) {
        if (root == null) {
            return
        }
        dfs(root.right)
        root.`val` += gst
        gst = root.`val`
        dfs(root.left)
    }
}