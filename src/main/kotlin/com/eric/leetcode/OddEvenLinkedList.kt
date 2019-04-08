package com.eric.leetcode

class OddEvenLinkedList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun oddEvenList(head: ListNode?): ListNode? {
        val oddRoot = head
        val evenRoot = head?.next
        var oddCur = oddRoot
        var evenCur = evenRoot
        while (oddCur?.next != null || evenCur?.next != null) {
            oddCur?.next = evenCur?.next
            if (oddCur?.next != null) {
                oddCur =  oddCur.next
            }
            evenCur?.next = oddCur?.next
            evenCur = evenCur?.next
        }
        oddCur?.next = evenRoot
        return oddRoot
    }
}

fun main(args: Array<String>) {

}