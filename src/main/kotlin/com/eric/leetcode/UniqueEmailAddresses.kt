package com.eric.leetcode

class UniqueEmailAddresses {
    fun numUniqueEmails(emails: Array<String>): Int {
        val set = mutableSetOf<String>()
        for (email in emails) {
            val sb = StringBuilder()
            var ignore = false
            var skip = false
            for (ch in email) {
                if (!ignore) {
                    if(ch == '@') {
                        ignore = true
                        skip = false
                    } else if(ch == '.' || skip) {
                        continue
                    } else if (ch == '+') {
                        skip = true
                    }
                }
                sb.append(ch)
            }
            set.add(sb.toString())
        }
        return set.size
    }
}

fun main(args: Array<String>) {
    val input = arrayOf("test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com")
    val uniqueEmailAddresses = UniqueEmailAddresses()
    println(uniqueEmailAddresses.numUniqueEmails(input))
}