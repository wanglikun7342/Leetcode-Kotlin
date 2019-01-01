package com.eric.leetcode

class QuickSort {
    fun quickSort(array: IntArray, beginIndex: Int, endIndex: Int) {
        if (beginIndex > endIndex) {
            return
        }
        var left = beginIndex
        var right = endIndex
        var pivot = array[beginIndex]
        while (left < right) {
            while (left < right && array[right] >= pivot) {
                right--
            }
            swap(array, left, right)

            while (left < right && pivot >= array[left]) {
                left++
            }
            swap(array, left, right)
        }
        quickSort(array, beginIndex, left - 1)
        quickSort(array, left + 1, endIndex)
    }

    // 交换元素位置
    private fun swap(array: IntArray, i: Int, k: Int) {
        var temp = array[i]
        array[i] = array[k]
        array[k] = temp
    }
}

fun main(args: Array<String>) {
    val array = intArrayOf(1, 3, 4, 5, 2, 6, 9, 7, 8, 11, 12, 10, 11)
    val quickSort = QuickSort()
    quickSort.quickSort(array, 0, array.lastIndex)
    for (num in array) {
        print("$num, ")
    }
    print("\n")
}