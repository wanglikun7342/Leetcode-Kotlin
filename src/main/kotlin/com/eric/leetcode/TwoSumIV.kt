package com.eric.leetcode

class TwoSumIV {
    private val map = mutableMapOf<Int, Int>()
    private var target = 0

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int = 0) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        target = k
        return find(root)
    }

    private fun find(root: TreeNode?): Boolean {
        if (root == null) {
            return false
        }
        if (map[root.`val`] != null) {
            return true
        }
        map.put(target - root.`val`, 1)
        return find(root.left) || find(root.right)
    }
}

/**
 *      5
 *     / \
 *    3   6
 *   / \   \
 *  2   4   7
 */
fun main(args: Array<String>) {
    val root = TwoSumIV.TreeNode(5)
    root.left = TwoSumIV.TreeNode(3)
    root.right = TwoSumIV.TreeNode(6)
    (root.left)?.left = TwoSumIV.TreeNode(2)
    (root.left)?.right = TwoSumIV.TreeNode(4)
    (root.right)?.right = TwoSumIV.TreeNode(7)
    val twoSumIV = TwoSumIV()
    val result = twoSumIV.findTarget(root, 15)
    println("result $result")
}