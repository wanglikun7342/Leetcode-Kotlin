package com.eric.leetcode

class SumRootToLeafNumbers {
    var result = 0
    fun sumNumbers(root: TreeNode?): Int {
        result = 0
        root?.let { sum(it, 0) }
        return result
    }

    private fun sum(root: TreeNode, num: Int) {
        val newNum = num * 10 + root.`val`
        if (root.left == null && root.right == null) {
            result += newNum
        } else {
            root.left?.let { sum(it, newNum) }
            root.right?.let { sum(it, newNum) }
        }
    }
}