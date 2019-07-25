package com.eric.leetcode

import java.util.*

class ExamRoom(N: Int) {
    private val N = N

    private val seats = TreeSet<Int>()

    fun seat(): Int {
        var seat = 0
        if (seats.isNotEmpty()) {
            var dist = seats.first()
            var pre: Int? = null
            for (s in seats) {
                if (pre != null) {
                    val d = (s - pre) / 2
                    if (d > dist) {
                        seat = pre + d
                        dist = d
                    }
                }
                pre = s
            }
            if (N - 1 - seats.last() > dist) {
                seat = N - 1
            }
        }
        seats.add(seat)
        return seat
    }

    fun leave(p: Int) {
        seats.remove(p)
    }
}

fun main(args: Array<String>) {
    val examRoom = ExamRoom(10)
    examRoom.seat()
    examRoom.seat()
    examRoom.seat()
    examRoom.seat()
}