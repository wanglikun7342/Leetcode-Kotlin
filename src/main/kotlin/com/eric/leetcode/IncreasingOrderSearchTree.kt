package com.eric.leetcode

class IncreasingOrderSearchTree {
    // Definition for a binary tree node.
    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun increasingBST(root: TreeNode?): TreeNode? {
        val list = mutableListOf<TreeNode>()
        inorder(root, list)
        for (index in 0 until list.lastIndex) {
            list[index].left = null
            list[index].right = list[index + 1]
        }
        list[list.lastIndex].left = null
        list[list.lastIndex].right = null
        val result = list[0]
        list.clear()
        return result
    }

    private fun inorder(root: TreeNode?, list: MutableList<TreeNode>) {
        if (root == null) {
            return
        }
        inorder(root.left, list)
        list.add(root)
        inorder(root.right, list)
    }
}

fun main(args: Array<String>) {
    
}