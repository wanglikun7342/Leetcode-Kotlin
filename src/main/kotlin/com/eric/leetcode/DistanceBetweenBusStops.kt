package com.eric.leetcode

class DistanceBetweenBusStops {
    fun distanceBetweenBusStops(distance: IntArray, start: Int, destination: Int): Int {
        var sum = 0
        var result: Int
        val length = distance.size
        var from: Int
        var to: Int
        if (start < destination) {
            from = start
            to = destination
        } else {
            to = start
            from = destination
        }
        for (index in from until to) {
            sum += distance[index]
        }
        result = sum
        sum = 0
        for (index in to until from + length) {
            sum += if (index >= length) {
                distance[index - length]
            } else {
                distance[index]
            }
        }
        return if (sum < result) {
            sum
        } else {
            result
        }
    }
}

fun main(args: Array<String>) {
    val distance = intArrayOf(7, 10, 1, 12, 11, 14, 5, 0)
    val distanceBetweenBusStops = DistanceBetweenBusStops()
    print(distanceBetweenBusStops.distanceBetweenBusStops(distance, 7, 2))
}