package com.eric.leetcode

class FindDuplicateSubtrees {
    val list = mutableListOf<TreeNode?>()
    val set = mutableSetOf<String>()
    val addedSet = mutableSetOf<String>()

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        t(root)
        return list
    }

    private fun t(root: TreeNode?): String {
        if (root == null) return "null&"
        val sb = StringBuilder()
        sb.append(root.`val`.toString() + "&")
        sb.append(t(root.left))
        sb.append(t(root.right))

        val subTreeText = sb.toString()
        if (set.contains(subTreeText)) {
            if (!addedSet.contains(subTreeText)) {
                list.add(root)
                addedSet.add(subTreeText)
            }
        } else {
            set.add(subTreeText)
        }

        return subTreeText
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

/**
 *      5
 *     / \
 *    2   2
 *    \   \
 *    4   4
 */
fun main(args: Array<String>) {
    val root = FindDuplicateSubtrees.TreeNode(5)
    root.left = FindDuplicateSubtrees.TreeNode(2)
    root.right = FindDuplicateSubtrees.TreeNode(2)
    (root.left)?.right = FindDuplicateSubtrees.TreeNode(4)
    (root.right)?.right = FindDuplicateSubtrees.TreeNode(4)
    val findDuplicateSubtrees = FindDuplicateSubtrees()
    val result = findDuplicateSubtrees.findDuplicateSubtrees(root)
    for (e in result) {
        FindDuplicateSubtrees.dfs(e)
        println()
    }
}