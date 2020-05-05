package com.eric.leetcode

class DayOfTheWeek {
    fun dayOfTheWeek(day: Int, month: Int, year: Int): String {
        var cal = 0
        val months = arrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        for (index in 1971 until year) {
            if ((index % 4 == 0 && index % 100 != 0) || index % 400 == 0) {
                cal += 366
            } else {
                cal += 365
            }
        }
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            months[1] = 29
        }
        for (index in 0 until month - 1) {
            cal += months[index]
        }
        cal += day
        when ((cal - 1) % 7) {
            0 -> return "Friday"
            1 -> return "Saturday"
            2 -> return "Sunday"
            3 -> return "Monday"
            4 -> return "Tuesday"
            5 -> return "Wednesday"
            6 -> return "Thursday"
            else -> return ""
        }
    }
}

fun main(args: Array<String>) {
    val dayOfTheWeek = DayOfTheWeek()
    print(dayOfTheWeek.dayOfTheWeek(31, 8, 2019))
}