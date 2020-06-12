package com.eric.leetcode

class SubdomainVisitCount {
    fun subdomainVisits(cpdomains: Array<String>): List<String> {
        val map = mutableMapOf<String, Int>()
        for (cpdomain in cpdomains) {
            val splits = cpdomain.split(" ")
            val count = splits[0]
            val domain = splits[1]
            val subs = domain.split(".")
            var subDomain = ""
            var index = subs.lastIndex
            do {
                subDomain = if (index == subs.lastIndex) {
                    subs[index]
                } else {
                    subs[index] + "." + subDomain
                }
                val oldCount = map.getOrDefault(subDomain, 0)
                map[subDomain] = oldCount + count.toInt()
                index--

            } while (index >= 0)
        }
        return map.map { it.value.toString() + " " + it.key }
    }
}

fun main(args: Array<String>) {
    val input = arrayOf("9001 discuss.leetcode.com")
    val subdomainVisitCount = SubdomainVisitCount()
    val result = subdomainVisitCount.subdomainVisits(input)
}