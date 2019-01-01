package com.eric.leetcode

class HeapSort {
    fun heapSort(array: IntArray) {
        // 初始化堆
        for (i in array.lastIndex  downTo 0) {
            heapAdjust(array, i, array.size)
        }

        // 进行n-1次循环，完成排序
        for (i in array.lastIndex downTo 1) {
            val temp = array[i]
            array[i] = array[0]
            array[0] = temp
            heapAdjust(array, 0, i)
            for (num in array) {
                print("num: $num, ")
            }
            print("\n")
        }
    }

    private fun heapAdjust(array: IntArray, parent: Int, length: Int) {
        val temp = array[parent]
        var parentIndex = parent
        var childIndex = 2 * parentIndex + 1

        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex] < array[childIndex + 1]) {
                childIndex++
            }
            if (temp > array[childIndex]) {
                break
            }
            array[parentIndex] = array[childIndex]
            parentIndex = childIndex
            childIndex = parentIndex * 2 + 1
        }
        array[parentIndex] = temp
    }
}


fun main(args: Array<String>) {
    val array = intArrayOf(1, 3, 4, 5, 2, 6, 9, 7, 8, 0)
    val heapSort = HeapSort()
    heapSort.heapSort(array)
}