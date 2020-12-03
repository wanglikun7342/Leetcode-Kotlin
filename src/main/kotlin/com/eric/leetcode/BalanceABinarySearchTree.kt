package com.eric.leetcode

class BalanceABinarySearchTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun balanceBST(root: TreeNode?): TreeNode? {
        val list = mutableListOf<TreeNode>()
        traverse(root, list)
        if (list.isEmpty()) {
            return null
        } else {
            return balance(0, list.lastIndex, list)
        }
    }

    private fun balance(start: Int, end: Int, list: MutableList<TreeNode>): TreeNode? {
        if (start > end) {
            return null
        }
        val mid = (end + start) / 2
        val root = list[mid]
        root.right = balance(mid + 1, end, list)
        root.left = balance(start, mid -1, list)
        return root
    }

    private fun traverse(root: TreeNode?, list: MutableList<TreeNode>) {
        if (root == null) {
            return
        }
        traverse(root.left, list)
        list.add(root)
        traverse(root.right, list)
    }
}

fun main() {

}