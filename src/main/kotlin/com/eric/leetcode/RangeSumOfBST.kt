package com.eric.leetcode

class RangeSumOfBST {
    // Definition for a binary tree node.
    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
        if (root == null) {
            return 0
        }
        if (root.`val` in L..R) {
            return root.`val` + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R)
        } else {
            return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R)
        }
    }
}

fun main(args: Array<String>) {

}