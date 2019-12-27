package com.eric.leetcode

class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val map = mutableMapOf<Int, MutableList<Int>>()
        for (el in groupSizes.withIndex()) {
            val index = el.index
            val groupSize = el.value
            val list = map.getOrDefault(groupSize, mutableListOf())
            list.add(index)
            if (list.size == groupSize) {
                result.add(list)
                map.remove(groupSize)
            } else {
                map[groupSize] = list
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val groupSizes = intArrayOf(3, 3, 3, 3, 3, 1, 3)
    val groupThePeopleGivenTheGroupSizeTheyBelongTo = GroupThePeopleGivenTheGroupSizeTheyBelongTo()
    val result = groupThePeopleGivenTheGroupSizeTheyBelongTo.groupThePeople(groupSizes)
    println(result)
}