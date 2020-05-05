package com.eric.leetcode

class DeleteNodeInALinkedList {


    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun deleteNode(node: ListNode?) {
        node?.`val` = node?.next?.`val` ?: 0
        node?.next = node?.next?.next
    }
}

fun main(args: Array<String>) {

}