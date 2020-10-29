package com.eric.leetcode

class SumOfNodesWithEvenValuedGrandparent {
    private var sum: Int = 0

    fun sumEvenGrandparent(root: TreeNode?): Int {
        sum = 0
        dfs(root, null, null)
        return sum
    }

    private fun dfs(root: TreeNode?, grandparent: TreeNode?, parent: TreeNode?) {
        if (root == null) {
            return
        }
        if (grandparent?.`val`?.rem(2) == 0) {
            sum += root.`val`
        }
        dfs(root.left, parent, root)
        dfs(root.right, parent, root)
    }
}

fun main() {

}