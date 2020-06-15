package com.eric.leetcode


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class PathSumII {
    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root != null) {
            val list = mutableListOf<Int>()
            dfs(root, list, result, sum)
        }
        return result
    }

    private fun dfs(root: TreeNode, list: MutableList<Int>, lists: MutableList<List<Int>>, sum: Int) {
        val new = mutableListOf<Int>()
        new.addAll(list)
        new.add(root.`val`)
        if (root.left == null && root.right == null) {
            if (new.sum() == sum) {
                lists.add(new)
            }
        } else {
            root.left?.let { dfs(it, new, lists, sum) }
            root.right?.let { dfs(it, new, lists, sum) }
        }
    }
}

fun main(args: Array<String>) {

}