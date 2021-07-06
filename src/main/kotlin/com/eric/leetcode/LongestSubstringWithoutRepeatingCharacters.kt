package com.eric.leetcode

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length < 2) {
            return s.length
        }
        var maxLength = 1
        val map = mutableMapOf<Char, Int>()
        map[s[0]] = 0
        var index = 1
        while (index <= s.lastIndex) {
            val ch = s[index]
            if (map.containsKey(ch)) {
                map[ch]?.let {
                    index = it + 1
                    map.clear()
                }
                continue
            }
            map[ch] = index
            if (map.size > maxLength) {
                maxLength = map.size
            }
            index++
        }
        return maxLength
    }
}

fun main() {
    val input = "dvdf"
    val longestSubstringWithoutRepeatingCharacters = LongestSubstringWithoutRepeatingCharacters()
    print(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input))
}