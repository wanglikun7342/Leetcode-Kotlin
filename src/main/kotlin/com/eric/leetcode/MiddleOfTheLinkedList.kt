package com.eric.leetcode

class MiddleOfTheLinkedList {
    // Definition for singly-linked list.
    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }

    fun middleNode(head: ListNode?): ListNode? {
        return middleNode(head, 1)
    }

    fun getBackIndex(head: ListNode?): Int {
        if (head == null) {
            return 0
        }
        return getBackIndex(head.next) + 1
    }

    fun middleNode(head: ListNode?, frontIndex : Int): ListNode? {
        if (head == null) {
            return null
        }
        if (frontIndex == getBackIndex(head)
                || frontIndex - 1 == getBackIndex(head)) {
            return head
        } else{
            return middleNode(head.next, frontIndex + 1)
        }
    }
}

fun main(args: Array<String>) {

}