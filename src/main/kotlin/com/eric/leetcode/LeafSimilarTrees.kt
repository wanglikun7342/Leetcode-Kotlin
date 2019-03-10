package com.eric.leetcode

class LeafSimilarTrees {

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val leftLeafs = getLeafs(root1)
        val rightLeafs = getLeafs(root2)
        if (leftLeafs.size != rightLeafs.size) {
            return false
        }
        for (index in leftLeafs.indices) {
            if (leftLeafs[index].`val` != rightLeafs[index].`val`) {
                return false
            }
        }
        return true
    }

    private fun getLeafs(root: TreeNode?): List<TreeNode> {
        if (root == null) {
            return emptyList()
        }
        val result = mutableListOf<TreeNode>()
        traverseLeafs(root, result)
        return result
    }

    private fun traverseLeafs(root: TreeNode?, result: MutableList<TreeNode>) {
        if(root == null) {
            return
        }
        if (root.left != null) {
            traverseLeafs(root.left, result)
        }
        if (root.right != null) {
            traverseLeafs(root.right, result)
        }
        if (root.left == null && root.right == null) {
            result.add(root)
        }
    }
}