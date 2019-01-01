package com.eric.leetcode

class PrimeNumberOfSetBitsInBinaryRepresentation {
    fun countPrimeSetBits(L: Int, R: Int): Int {
        var count = 0
        for (i in L..R) {
            if (isPrimeNum(getBits(i))) {
                count++
            }
        }
        return count
    }

    private fun getBits(num: Int): Int {
        var cacheNum = num
        var bits = 0
        while (cacheNum != 0) {
            if (cacheNum % 2 == 1) {
                bits++
            }
            cacheNum /= 2
        }
        return bits
    }

    private fun isPrimeNum(num: Int): Boolean {
        if (num == 1) {
            return false
        } else {
            for (i in 2 until num) {
                if (num % i == 0) {
                    return false
                }
            }
            return true
        }
    }
}

fun main(args: Array<String>) {
    val primeNumberOfSetBitsInBinaryRepresentation = PrimeNumberOfSetBitsInBinaryRepresentation()
    val result = primeNumberOfSetBitsInBinaryRepresentation.countPrimeSetBits(990, 1048)
    println("result: $result")
}