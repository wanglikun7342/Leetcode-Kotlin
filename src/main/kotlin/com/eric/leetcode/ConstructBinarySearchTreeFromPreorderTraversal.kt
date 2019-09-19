package com.eric.leetcode


class ConstructBinarySearchTreeFromPreorderTraversal {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) {
            return null
        } else {
            val root = TreeNode(preorder[0])
            for (value in preorder.sliceArray(1..preorder.lastIndex)) {
                build(root, value)
            }
            return root
        }
    }

    private fun build(root: TreeNode, value: Int) {
        if (value > root.`val`) {
            if (root.right != null) {
                root.right?.let { build(it, value) }
            } else {
                root.right = TreeNode(value)
            }
        } else {
            if (root.left != null) {
                root.left?.let { build(it, value) }
            } else {
                root.left = TreeNode(value)
            }
        }
    }
}

fun main(args: Array<String>) {
    val inputArray = intArrayOf(8, 5, 1, 7, 10, 12)
    val constructBinarySearchTreeFromPreorderTraversal = ConstructBinarySearchTreeFromPreorderTraversal()
    constructBinarySearchTreeFromPreorderTraversal.bstFromPreorder(inputArray)
}