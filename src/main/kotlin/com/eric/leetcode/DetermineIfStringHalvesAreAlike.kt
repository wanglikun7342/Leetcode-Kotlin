package com.eric.leetcode

class DetermineIfStringHalvesAreAlike {
    private val characters = listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    fun halvesAreAlike(s: String): Boolean {
        val halfOne = s.substring(0, s.lastIndex / 2 + 1)
        val halfTwo = s.substring(s.lastIndex / 2 + 1, s.lastIndex + 1)
        var sumOne = 0
        var sumTwo = 0
        for (ch in halfOne) {
            if (characters.contains(ch)) {
                sumOne++
            }
        }
        for (ch in halfTwo) {
            if (characters.contains(ch)) {
                sumTwo++
            }
        }
        return sumOne == sumTwo
    }
}

fun main() {
    val s = "book"
    val determineIfStringHalvesAreAlike = DetermineIfStringHalvesAreAlike()
    determineIfStringHalvesAreAlike.halvesAreAlike(s)
}