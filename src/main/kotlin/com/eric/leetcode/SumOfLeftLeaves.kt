package com.eric.leetcode

class SumOfLeftLeaves {
    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun sumOfLeftLeaves(root: TreeNode?): Int {
        return sumOfLeftLeaves(root, false)
    }

    private fun sumOfLeftLeaves(root: TreeNode?, left: Boolean): Int {
        if (root == null) {
            return 0
        }
        if (root.left == null
                && root.right == null) {
            return if (left) {
                root.`val`
            } else {
                0
            }
        } else if (root.left == null) {
            return sumOfLeftLeaves(root.right, false)
        } else if (root.right == null) {
            return sumOfLeftLeaves(root.left, true)
        }
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false)
    }
}

fun main(args: Array<String>) {
    val root = SumOfLeftLeaves.TreeNode(5)
    root.left = SumOfLeftLeaves.TreeNode(3)
    root.right = SumOfLeftLeaves.TreeNode(6)
    (root.left)?.left = SumOfLeftLeaves.TreeNode(2)
    (root.left)?.right = SumOfLeftLeaves.TreeNode(4)
    (root.right)?.right = SumOfLeftLeaves.TreeNode(7)
    val sumOfLeftLeaves = SumOfLeftLeaves()
    val result = sumOfLeftLeaves.sumOfLeftLeaves(root)
    println("result $result")
}