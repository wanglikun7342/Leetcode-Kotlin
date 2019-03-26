package com.eric.leetcode

class InsertInterval {
    // Definition for an interval.
    class Interval(var start: Int = 0, var end: Int = 0) {
        override fun toString(): String {
            return "Interval(start=$start, end=$end)"
        }
    }

    fun insert(intervals: List<Interval>, newInterval: Interval): List<Interval> {
        val result = mutableListOf<Interval>()
        result.add(newInterval)
        for (interval in intervals) {
            if (interval.end < newInterval.start) {
                result.add(result.lastIndex, interval)
            } else if (interval.start > newInterval.end) {
                result.add(result.lastIndex+1, interval)
            } else if (interval.start <= newInterval.start && interval.end >= newInterval.end ) {
                newInterval.start = interval.start
                newInterval.end = interval.end
            } else if (interval.start <= newInterval.start && interval.end < newInterval.end) {
                newInterval.start = interval.start
            } else if (interval.start > newInterval.start && interval.end >= newInterval.end) {
                newInterval.end = interval.end
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val intervals = listOf(InsertInterval.Interval(2, 6), InsertInterval.Interval(7, 9))
    val newInterval = InsertInterval.Interval(15, 18)
    val insertInterval = InsertInterval()
    for (ele in insertInterval.insert(intervals, newInterval)) {
        println(ele)
    }
}