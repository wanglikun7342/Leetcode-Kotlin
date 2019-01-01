package com.eric.leetcode

class ConstructStringFromBinaryTree {
    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun tree2str(t: TreeNode?): String {
        if (t == null) {
            return ""
        }
        val sb = StringBuilder()
        sb.append(t.`val`)
        if (t.left != null && t.right == null) {
            sb.append("(${tree2str(t.left)})")
        } else if (t.right != null) {
            sb.append("(${tree2str(t.left)})")
            sb.append("(${tree2str(t.right)})")
        }
        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val root = ConstructStringFromBinaryTree.TreeNode(5)
    root.left = ConstructStringFromBinaryTree.TreeNode(3)
    root.right = ConstructStringFromBinaryTree.TreeNode(6)
    (root.left)?.left = ConstructStringFromBinaryTree.TreeNode(2)
    (root.left)?.right = ConstructStringFromBinaryTree.TreeNode(4)
    (root.right)?.right = ConstructStringFromBinaryTree.TreeNode(7)
    val constructStringFromBinaryTree = ConstructStringFromBinaryTree()
    val result = constructStringFromBinaryTree.tree2str(root)
    println("result $result")
}