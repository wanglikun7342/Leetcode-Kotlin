package com.eric.leetcode

class ConvertBSTtoGreaterTree {
    var sum = 0
    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun convertBST(root: TreeNode?): TreeNode? {
        if(root == null) {
            return null
        }
        convertBST(root.right)
        root.`val` += sum
        sum = root.`val`
        convertBST(root.left)
        return root
    }

    companion object {
        fun dfs(root: TreeNode?) {
            if (root == null) {
                return
            }
            print("${root?.`val`}  ")
            dfs(root.left)
            dfs(root.right)
        }
    }
}

fun main(args: Array<String>) {
    val root = ConvertBSTtoGreaterTree.TreeNode(4)
    root.left = ConvertBSTtoGreaterTree.TreeNode(2)
    root.right = ConvertBSTtoGreaterTree.TreeNode(8)
    (root.left)?.left = ConvertBSTtoGreaterTree.TreeNode(1)
    (root.left)?.right = ConvertBSTtoGreaterTree.TreeNode(3)
    (root.right)?.right = ConvertBSTtoGreaterTree.TreeNode(9)
    val convertBSTtoGreaterTree = ConvertBSTtoGreaterTree()
    val result = convertBSTtoGreaterTree.convertBST(root)
    ConvertBSTtoGreaterTree.dfs(result)
    println()
}