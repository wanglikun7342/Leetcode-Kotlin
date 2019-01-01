package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class RevealCardsInIncreasingOrder {
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        val sortArray = mutableListOf<Int>()
        sortArray.addAll(deck.toList())
        sortArray.sort()
        val result = mutableListOf<Int>()
        for (index in sortArray.lastIndex downTo 0) {
            if (result.isNotEmpty()) {
                result.add(result.removeAt(0))
            }
            result.add(sortArray[index])
        }
        result.reverse()
        return result.toIntArray()
    }
}

fun main(args: Array<String>) {
    val input = intArrayOf(17,13,11,2,3,5,7)
    val revealCardsInIncreasingOrder = RevealCardsInIncreasingOrder()
    CommonUtils.printArray(revealCardsInIncreasingOrder.deckRevealedIncreasing(input).toTypedArray())
}