package com.eric.leetcode

class InsertIntoABinarySearchTree {

    // Definition for a binary tree node.
    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return root
        }
        if (`val` < root.`val`) {
            if (root.left == null) {
                root.left = TreeNode(`val`)
            } else {
                insertIntoBST(root.left, `val`)
            }
        } else {
            if (root.right == null) {
                root.right = TreeNode(`val`)
            } else {
                insertIntoBST(root.right, `val`)
            }
        }
        return root
    }
}

fun main(args: Array<String>) {

}