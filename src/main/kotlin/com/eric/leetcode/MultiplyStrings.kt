package com.eric.leetcode

class MultiplyStrings {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") {
            return "0"
        }
        val result = Array(num1.length + num2.length) {
            0
        }
        for (index1 in num1.lastIndex downTo 0) {
            for (index2 in num2.lastIndex downTo 0) {

                val mul = num1[index1].toString().toInt() * num2[index2].toString().toInt()
                val s = mul / 10
                val g = mul % 10
                val pos = result.lastIndex - (num1.lastIndex - index1 + num2.lastIndex - index2)
                result[pos] += g
                if (result[pos] >= 10) {
                    result[pos] = result[pos] % 10
                    result[pos - 1] += 1
                }
                result[pos - 1] += s
                if (result[pos - 1] >= 10) {
                    result[pos - 1] = result[pos - 1] % 10
                    result[pos - 2] += 1
                }
            }
        }
        val sb = StringBuilder()
        for (index in result.indexOfFirst { it != 0 }..result.lastIndex) {
            sb.append(result[index])
        }
        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val multiplyStrings = MultiplyStrings()
    println(multiplyStrings.multiply("0", "0"))
}