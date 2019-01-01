package com.eric.leetcode

class NextGreatestLetter {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var result = 'z'
        var min = letters[0]
        var wrapAround = true
        for(ch in letters) {
            if (ch > target && ch <= result) {
                result = ch
                wrapAround = false
            }
            if (ch < min) {
                min = ch
            }
        }
        if (wrapAround) {
            return min
        }
        return result
    }
}

fun main(args: Array<String>) {
    val array = charArrayOf('c', 'f', 'j')
    val target = 'c'
    val nextGreatestLetter = NextGreatestLetter()
    val result = nextGreatestLetter.nextGreatestLetter(array, target)
    println("result: $result")
}