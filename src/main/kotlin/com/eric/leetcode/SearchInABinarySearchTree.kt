package com.eric.leetcode

class SearchInABinarySearchTree {

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return null
        }
        if(root.`val` == `val`) {
            return root
        } else if (root.`val` > `val`) {
            return searchBST(root.left, `val`)
        } else {
            return searchBST(root.right, `val`)
        }
    }
}

fun main(args: Array<String>) {

}