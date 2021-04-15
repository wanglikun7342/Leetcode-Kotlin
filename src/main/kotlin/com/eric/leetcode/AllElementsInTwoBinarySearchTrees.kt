package com.eric.leetcode

class AllElementsInTwoBinarySearchTrees {
    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val x = mutableListOf<Int>()
        midOrder(root1, x)
        val y = mutableListOf<Int>()
        midOrder(root2, y)
        val result = mutableListOf<Int>()
        var i = 0
        var j = 0
        while (x.isNotEmpty() || y.isNotEmpty()) {
            if (x.isEmpty()) {
                result.add(y.removeAt(0))
            } else if (y.isEmpty()) {
                result.add(x.removeAt(0))
            } else if (x.first() < y.first()) {
                result.add(x.removeAt(0))
            } else {
                result.add(y.removeAt(0))
            }
        }
        return result
    }

    private fun midOrder(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) {
            return
        }
        midOrder(root.left, list)
        list.add(root.`val`)
        midOrder(root.right, list)
    }
}