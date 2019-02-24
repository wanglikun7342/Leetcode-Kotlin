package com.eric.leetcode

class NumberOfRecentCalls {
    private val mutableList = mutableListOf<Int>()

    fun ping(t: Int): Int {
        mutableList.add(t)
        while (mutableList[0] < t - 3000) {
            mutableList.removeAt(0)
        }
        return mutableList.size
    }
}

fun main(args: Array<String>) {
    val numberOfRecentCalls = NumberOfRecentCalls()
    print(numberOfRecentCalls.ping(1))
    print(numberOfRecentCalls.ping(100))
    print(numberOfRecentCalls.ping(3001))
    print(numberOfRecentCalls.ping(3002))
}