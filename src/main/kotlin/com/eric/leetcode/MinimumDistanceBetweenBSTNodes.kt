package com.eric.leetcode

class MinimumDistanceBetweenBSTNodes {

    // Definition for a binary tree node.
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private var pre = -100
    private var diff = 100

    fun minDiffInBST(root: TreeNode?): Int {
        if (root == null) {
            return Int.MIN_VALUE
        }
        minDiffInBST(root.left)
        diff = minOf(diff, root.`val` - pre)
        pre = root.`val`
        minDiffInBST(root.right)
        return diff
    }
}

fun main(args: Array<String>) {
    val tree4 = MinimumDistanceBetweenBSTNodes.TreeNode(4)
    val tree2 = MinimumDistanceBetweenBSTNodes.TreeNode(2)
    val tree6 = MinimumDistanceBetweenBSTNodes.TreeNode(6)
    val tree1 = MinimumDistanceBetweenBSTNodes.TreeNode(1)
    val tree3 = MinimumDistanceBetweenBSTNodes.TreeNode(3)
    tree4.left = tree2
    tree4.right = tree6
    tree2.left = tree1
    tree2.right = tree3
    val minimumDistanceBetweenBSTNodes = MinimumDistanceBetweenBSTNodes()
    println(minimumDistanceBetweenBSTNodes.minDiffInBST(tree4))
}