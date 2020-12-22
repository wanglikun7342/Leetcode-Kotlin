package com.eric.leetcode

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class MergeInBetweenLinkedLists {
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        var aNode: ListNode? = null
        var bNode: ListNode? = null
        var index = 0
        var cur = list1
        while (cur != null) {
            if (index == a - 1) {
                aNode = cur
            }
            if (index == b + 1) {
                bNode = cur
            }
            cur = cur.next
            index++
        }
        aNode?.next = list2
        cur = list2
        while (cur?.next != null) {
            cur = cur.next
        }
        cur?.next = bNode
        return list1
    }
}

fun main() {

}