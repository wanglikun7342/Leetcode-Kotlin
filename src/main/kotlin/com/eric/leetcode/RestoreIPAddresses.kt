package com.eric.leetcode

import com.eric.leetcode.util.CommonUtils

class RestoreIPAddresses {
    fun restoreIpAddresses(s: String): List<String> {
        val result = mutableListOf<String>()
        if (s.isEmpty() || s.length > 12) {
            return result
        }
        dfs(s, 0, "", result, 0)
        return result
    }

    private fun dfs(s: String, end: Int, ip: String, result: MutableList<String>, count: Int) {
        for (start in end..end + 2) {
            val ipSegment = s.substring(end..start)
            if (ipSegment.length > 1 && ipSegment[0] == '0') {
                break
            }
            if (ipSegment.toInt() > 255) {
                break
            }
            if (start == s.lastIndex) {
                if (count == 3) {
                    result.add("$ip.$ipSegment")
                }
                break
            }
            if (ip != "") {
                dfs(s, start + 1, "$ip.$ipSegment", result, count+1)
            } else {
                dfs(s, start + 1, ipSegment, result, count+1)
            }
        }
    }
}

fun main(args: Array<String>) {
    val input = "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
    val restoreIPAddresses = RestoreIPAddresses()
    CommonUtils.printArray(restoreIPAddresses.restoreIpAddresses(input).toTypedArray())
}