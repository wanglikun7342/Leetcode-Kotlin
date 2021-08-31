package com.eric.leetcode

class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        val arr = x.toString()
        for (index in 0..arr.lastIndex / 2) {
            if (arr[index] != arr[arr.lastIndex - index]) {
                return false
            }
        }
        return true
    }
}