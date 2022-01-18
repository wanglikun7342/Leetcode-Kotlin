package com.eric.leetcode

class LargestNumber {
    fun largestNumber(nums: IntArray): String {
        val sb = StringBuilder()
        val list = Array<MutableList<String>>(10) {
            mutableListOf()
        }
        for (num in nums) {
            val real = num.toString().first().toString().toInt()
            list[real].add(num.toString())
        }

        for (arr in list.reversed()) {
            if (arr.isNotEmpty()) {
                arr.sortedWith(Comparator { o1, o2 -> (o2 + o1).compareTo(o1 + o2) }).forEachIndexed { index, str ->
                    sb.append(str)
                }
            }
        }

        if (sb.first() == '0') {
            return "0"
        }
        return sb.toString()
    }
}