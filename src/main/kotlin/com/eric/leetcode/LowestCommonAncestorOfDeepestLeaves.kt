package com.eric.leetcode

class LowestCommonAncestorOfDeepestLeaves {

    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     **/
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    var result: TreeNode? = null
    var maxDepth = 0

    fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
        dfs(root, 0)
        return result
    }

    private fun dfs(root: TreeNode?, depth: Int): Int {
        if (root == null) {
            return depth - 1
        }
        val left = dfs(root.left, depth + 1)
        val right = dfs(root.right, depth + 1)
        if (left == right && maxDepth <= left) {
            maxDepth = left
            result = root
        }
        return if (left > right) left else right
    }
}

fun main(args: Array<String>) {
    val one = LowestCommonAncestorOfDeepestLeaves.TreeNode(1)
    val two = LowestCommonAncestorOfDeepestLeaves.TreeNode(2)
    val three = LowestCommonAncestorOfDeepestLeaves.TreeNode(3)
    val four = LowestCommonAncestorOfDeepestLeaves.TreeNode(4)
    one.left = two
    one.right = three
    two.left = four
    val lowestCommonAncestorOfDeepestLeaves = LowestCommonAncestorOfDeepestLeaves()
    lowestCommonAncestorOfDeepestLeaves.lcaDeepestLeaves(one)
}