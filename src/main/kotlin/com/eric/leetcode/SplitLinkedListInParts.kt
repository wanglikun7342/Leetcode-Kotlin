package com.eric.leetcode

class SplitLinkedListInParts {
    /*
    * Example:
    * var li = ListNode(5)
    * var v = li.`val`
    * Definition for singly-linked list.
    */
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun splitListToParts(root: ListNode?, k: Int): Array<ListNode?> {
        var num = k
        val result = arrayListOf<ListNode?>()
        var head = root
        var size = 0
        while (head != null) {
            size++
            head = head.next
        }
        var extra = size % k
        var len = size / k
        var cur = root
        var next: ListNode?
        var start = cur
        while (cur != null) {
            if (extra > 0) {
                for (i in 1..len) {
                    cur = cur?.next
                }
                extra--
            } else {
                for (i in 1 until len) {
                    cur = cur?.next
                }
            }
            next = cur?.next
            result.add(start)
            num--
            cur?.next = null
            cur = next
            start = cur
        }
        while (num >= 1) {
            num--
            result.add(null)
        }
        return result.toTypedArray()
    }
}

fun main(args: Array<String>) {
    val one = SplitLinkedListInParts.ListNode(1)
    val two = SplitLinkedListInParts.ListNode(2)
    one.next = two
    val three = SplitLinkedListInParts.ListNode(3)
    two.next = three
    val four = SplitLinkedListInParts.ListNode(4)
    three.next = four
    val five = SplitLinkedListInParts.ListNode(5)
    four.next = five
    val six = SplitLinkedListInParts.ListNode(6)
    five.next = six
    val seven = SplitLinkedListInParts.ListNode(7)
    six.next = seven
    val splitLinkedListInParts = SplitLinkedListInParts()
    splitLinkedListInParts.splitListToParts(one, 3)
}