package com.eric.leetcode

class MaximumPopulationYear {
    fun maximumPopulation(logs: Array<IntArray>): Int {
        var earliest = 0
        var populationMax = 0
        for (i in 0..logs.lastIndex) {
            val log = logs[i]
            val birth = log[0]
            val death = log[1]
            var population = 1
            for (j in 0..logs.lastIndex) {
                val logJ = logs[j]
                val birthJ = logJ[0]
                val deathJ = logJ[1]
                if (deathJ > birth && birthJ <= birth) {
                    population++
                }
            }
            if (population > populationMax) {
                populationMax = population
                earliest = birth
            } else if (population == populationMax && birth < earliest) {
                earliest = birth
            }
        }
        return earliest
    }
}