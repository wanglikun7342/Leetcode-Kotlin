package com.eric.leetcode

class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        val list = mutableListOf<Int>()
        traverse(root, list)
        for(index in 0 until list.lastIndex) {
            if (list[index] >= list[index+1]) {
                return false
            }
        }
        return true
    }

    private fun traverse(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) {
            return
        }
        traverse(root.left, list)
        list.add(root.`val`)
        traverse(root.right, list)
    }
}

fun main(args: Array<String>) {

}