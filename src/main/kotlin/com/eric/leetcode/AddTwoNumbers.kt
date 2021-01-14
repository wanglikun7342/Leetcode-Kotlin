package com.eric.leetcode

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val root = ListNode(0)
        var left = l1
        var right = l2
        var cur: ListNode? = root
        var red = 0
        while (left != null || right != null) {
            if (left != null && right != null) {
                cur?.`val` = (left.`val` + right.`val` + red) % 10
                red = (left.`val` + right.`val` + red) / 10
            } else if (left != null) {
                cur?.`val` = (left.`val` + red) % 10
                red = (left.`val` + red) / 10
            } else if (right != null) {
                cur?.`val` = (right.`val` + red) % 10
                red = (right.`val` + red) / 10
            }

            if (left?.next != null || right?.next != null) {
                cur?.next = ListNode(0)
            } else if (red != 0) {
                cur?.next = ListNode(red)
            }
            cur = cur?.next
            left = left?.next
            right = right?.next
        }
        return root
    }
}

fun main() {
    val l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next!!.next = ListNode(3)
    val l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next!!.next = ListNode(4)
    val addTwoNumbers = AddTwoNumbers()
    addTwoNumbers.addTwoNumbers(l1, l2)
}