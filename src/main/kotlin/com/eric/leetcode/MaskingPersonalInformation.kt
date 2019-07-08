package com.eric.leetcode

class MaskingPersonalInformation {
    fun maskPII(S: String): String {
        val atIndex = S.indexOf("@")
        if (atIndex >= 0) {
            return (S[0] + "*****" + S[atIndex - 1] + S.substring(atIndex)).toLowerCase()
        } else {
            val digits = S.replace(Regex("[^\\d]"), "")
            if (digits.length == 10) {
                return "***-***-" + digits.substring(digits.lastIndex - 3)
            } else {
                var ans = "+"
                for (i in 0 until digits.length - 10)
                    ans += "*"
                return ans + "-" + "***-***-" + digits.substring(digits.lastIndex - 3)
            }
        }
    }
}

fun main(args: Array<String>) {
    val maskingPersonalInformation = MaskingPersonalInformation()
    println(maskingPersonalInformation.maskPII("1(234)567-890"))
}