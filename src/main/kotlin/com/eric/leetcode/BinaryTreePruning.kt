package com.eric.leetcode

class BinaryTreePruning {
    // Definition for a binary tree node.
    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun pruneTree(root: TreeNode?): TreeNode? {
        prune(root)
        return root
    }

    private fun prune(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        val leftPrune = prune(root.left)
        val rightPrune = prune(root.right)
        if (leftPrune && rightPrune) {
            if (root.`val` == 0) {
                return true
            } else {
                root.left = null
                root.right = null
                return false
            }
        } else {
            if (leftPrune) {
                root.left = null
            }
            if (rightPrune) {
                root.right = null
            }
            return false
        }
    }
}



fun main(args: Array<String>) {
    //todo 实现测试用例
}