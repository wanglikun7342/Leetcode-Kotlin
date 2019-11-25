package com.eric.leetcode

class ConvertSortedListToBinarySearchTree {

    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     */
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     */
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun sortedListToBST(head: ListNode?): TreeNode? {
        var cur = head
        val list = mutableListOf<Int>()
        while (cur != null) {
            list.add(cur.`val`)
            cur = cur.next
        }
        return generate(list, 0, list.lastIndex)
    }
    
    private fun generate(list: List<Int>, start: Int, end: Int): TreeNode? {
        if (start > end) {
            return null
        }
        if (start == end) {
            return TreeNode(list[start])
        }
        val mid = (start + end) / 2
        val root = TreeNode(list[mid])
        root.left = generate(list, start, mid-1)
        root.right = generate(list, mid + 1, end)
        return root
    }
}

fun main(args: Array<String>) {
    val root = ConvertSortedListToBinarySearchTree.ListNode(-10)
    root.next = ConvertSortedListToBinarySearchTree.ListNode(-3)
    root.next?.next = ConvertSortedListToBinarySearchTree.ListNode(0)
    root.next?.next?.next = ConvertSortedListToBinarySearchTree.ListNode(5)
    root.next?.next?.next?.next = ConvertSortedListToBinarySearchTree.ListNode(9)
    val convertSortedListToBinarySearchTree = ConvertSortedListToBinarySearchTree()
    convertSortedListToBinarySearchTree.sortedListToBST(root)
}