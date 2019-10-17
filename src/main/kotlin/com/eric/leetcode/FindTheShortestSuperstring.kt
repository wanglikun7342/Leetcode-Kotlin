package com.eric.leetcode

class FindTheShortestSuperstring {
    fun shortestSuperstring(A: Array<String>): String {
        val list = A.toMutableList()
        while (list.size > 1) {
            var x = 0
            var y = 1
            for (iv in list.withIndex()) {
                for (index in iv.index + 1..list.lastIndex) {
                    if (getOverlapping(iv.value, list[index]) > getOverlapping(list[x], list[y])) {
                        x = iv.index
                        y = index
                    }
                }
            }
            val a = list[x]
            val b = list[y]
            list.remove(a)
            list.remove(b)
            list.add(getOverlappingString(a, b))
        }
        return list.single()
    }

    private fun getOverlapping(x: String, y: String): Int {
        return x.length + y.length - getOverlappingString(x, y).length
    }

    private fun getOverlappingString(str1: String, str2: String): String {
        var result = ""
        loop@ for (iv in str1.withIndex()) {
            if (iv.value != str2[0]) {
                continue
            }
            for (index in iv.index..str1.lastIndex) {
                if (str1[index] != str2[index - iv.index]) {
                     continue@loop
                }
            }
            result = str1 + str2.substring(str1.length-iv.index..str2.lastIndex)
            break
        }
        loop@ for (iv in str2.withIndex()) {
            if (iv.value != str1[0]) {
                continue
            }
            for (index in iv.index..str2.lastIndex) {
                if (str2[index] != str1[index - iv.index]) {
                    continue@loop
                }
            }
            val newResult = str2 + str1.substring(str2.length-iv.index..str1.lastIndex)
            if (newResult.length < result.length || result == "") {
                result = newResult
            }
            break
        }
        if (result == "") {
            result = str1 + str2
        }
        return result
    }
}

fun main(args: Array<String>) {
    val inputArray = arrayOf("sssv","svq","dskss","sksss")
    val findTheShortestSuperstring = FindTheShortestSuperstring()
    println(findTheShortestSuperstring.shortestSuperstring(inputArray))
}