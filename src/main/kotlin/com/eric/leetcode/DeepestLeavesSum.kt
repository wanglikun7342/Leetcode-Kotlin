package com.eric.leetcode

class DeepestLeavesSum {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    var sum = 0
    var maxDepth = 0

    fun deepestLeavesSum(root: TreeNode?): Int {
        sum = 0
        root?.let { dfs(it, 0) }
        return sum
    }

    private fun dfs(root: TreeNode, depth: Int) {
        root.left?.let { dfs(it, depth + 1) }
        root.right?.let { dfs(it, depth + 1) }
        if (root.left == null && root.right == null) {
            if (maxDepth == depth) {
                sum+=root.`val`
            } else if (maxDepth < depth) {
                sum = root.`val`
                maxDepth = depth
            }
        }
    }
}

fun main() {

}