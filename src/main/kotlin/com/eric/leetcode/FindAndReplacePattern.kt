package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class FindAndReplacePattern {
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        val result = mutableListOf<String>()
        loop@ for (word in words) {
            val map = mutableMapOf<Char, Char>()
            for (i in word.indices) {
                if (map.containsKey(word[i])) {
                    val char = map[word[i]]
                    if (char != pattern[i]) {
                        continue@loop
                    }
                } else {
                    if (map.containsValue(pattern[i])) {
                        continue@loop
                    }
                }
                map.put(word[i], pattern[i])
            }
            result.add(word)
        }
        return result
    }
}

fun main(args: Array<String>) {
    val words = arrayOf("abc","deq","mee","aqq","dkd","ccc")
    val pattern = "abb"
    val findAndReplacePattern = FindAndReplacePattern()
    CommonUtils.printArray(findAndReplacePattern.findAndReplacePattern(words, pattern).toTypedArray())
}