package com.eric.leetcode

class Maximum69Number {
    fun maximum69Number (num: Int): Int {
        val arr = num.toString().toCharArray()
        for (index in 0..arr.lastIndex) {
            if (arr[index] == '6') {
                arr[index] = '9'
                break
            }
        }
        return arr.joinToString("").toInt()
    }
}

fun main() {
    val maximum69Number = Maximum69Number()
    print(maximum69Number.maximum69Number(6699))
}