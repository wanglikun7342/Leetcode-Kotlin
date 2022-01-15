package com.eric.leetcode

class RotateList {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        var cur = head
        var count = 1
        while (cur?.next != null) {
            count++
            cur = cur.next
        }
        val end = cur
        cur = head
        val j = k % count
        for (index in 1 until (count - j)) {
            cur = cur?.next
        }
        end?.next = head
        val result = cur?.next
        cur?.next = null
        return result
    }
}