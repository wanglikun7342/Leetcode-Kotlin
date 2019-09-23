package com.eric.leetcode

class MinimumAbsoluteDifferenceInBST {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun getMinimumDifference(root: TreeNode?): Int {
        val list = mutableListOf<TreeNode>()
        dfs(root, list)
        var minDiff = Int.MAX_VALUE
        for (index in 1..list.lastIndex) {
            val diff = list[index].`val` - list[index - 1].`val`
            if (diff < minDiff) {
                minDiff = diff
            }
        }
        return minDiff
    }

    private fun dfs(root: TreeNode?, list: MutableList<TreeNode>) {
        if (root == null) {
            return
        } else {
            dfs(root.left, list)
            list.add(root)
            dfs(root.right, list)
        }
    }
}

fun main(args: Array<String>) {

}