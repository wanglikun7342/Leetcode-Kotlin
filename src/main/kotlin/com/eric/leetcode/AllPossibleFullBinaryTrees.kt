package com.eric.leetcode

class AllPossibleFullBinaryTrees {
    // Definition for a binary tree node.
    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private val map = mutableMapOf<Int, List<TreeNode?>>(1 to listOf(TreeNode(0)))

    fun allPossibleFBT(N: Int): List<TreeNode?> {
        if (!map.containsKey(N)) {
            val ans = mutableListOf<TreeNode?>()
            for (x in 0 until N) {
                val y = N - 1 - x
                for (left in allPossibleFBT(x)) {
                    for (right in allPossibleFBT(y)) {
                        val bns = TreeNode(0)
                        bns.left = left
                        bns.right = right
                        ans.add(bns)
                    }
                }
            }
            map.put(N, ans)
        }
        return map[N].orEmpty()
    }
}

fun main(args: Array<String>) {

}