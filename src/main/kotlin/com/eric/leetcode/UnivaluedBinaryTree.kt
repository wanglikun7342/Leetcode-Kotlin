package com.eric.leetcode

class UnivaluedBinaryTree {
    // Definition for a binary tree node.
    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private var uniValue = 0

    fun isUnivalTree(root: TreeNode?): Boolean {
        if(root == null) {
            return false
        } else {
            uniValue = root.`val`
            return isUnivalTreeInternal(root.left) && isUnivalTreeInternal(root.right)
        }
    }

    fun isUnivalTreeInternal(root: TreeNode?): Boolean {
        if(root == null) {
            return true
        } else {
            return isUnivalTreeInternal(root.left) && isUnivalTreeInternal(root.right) && root.`val` == uniValue
        }
    }
}

fun main(args: Array<String>) {

}