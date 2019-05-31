package com.eric.leetcode

class InsertionSortList {
    // Definition for singly-linked list.
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    private val list = mutableListOf<ListNode>()

    fun insertionSortList(head: ListNode?): ListNode? {
        var curNode = head
        while (curNode != null) {
            list.add(curNode)
            curNode = curNode.next
        }
        for (index in list.indices) {
            var j = index
            val num = list[index].`val`
            while (j > 0 && num < list[j - 1].`val`) {
                list[j].`val` = list[j - 1].`val`
                j--
            }
            list[j].`val` = num
        }
        list.clear()
        return head
    }
}

fun main(args: Array<String>) {

}