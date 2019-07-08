package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        intervals.sortWith(Comparator { o1, o2 ->
            o1[0] - o2[0]
        })
        for (interval in intervals) {
            if (result.isEmpty()) {
                result.add(interval)
            } else {
                val lastInterval = result.last()
                if (lastInterval[1] < interval[0]) {
                    result.add(interval)
                } else {
                    if (lastInterval[0] > interval[0]) {
                        lastInterval[0] = interval[0]
                    }
                    if (interval[1] > lastInterval[1]) {
                        lastInterval[1] = interval[1]
                    }
                }
            }
        }
        return result.toTypedArray()
    }
}


fun main(args: Array<String>) {
    val intervals = arrayOf(intArrayOf(1, 4), intArrayOf(0, 0))
    val mergeIntervals = MergeIntervals()
    CommonUtils.print2DIntArray(mergeIntervals.merge(intervals))
}