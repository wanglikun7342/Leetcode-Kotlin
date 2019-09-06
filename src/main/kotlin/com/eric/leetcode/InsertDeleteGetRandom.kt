package com.eric.leetcode

import kotlin.random.Random

class InsertDeleteGetRandom {
    /** Initialize your data structure here. */
    private val set = mutableSetOf<Int>()

    private val rand = Random(System.currentTimeMillis())


    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        return set.add(`val`)
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        return set.remove(`val`)
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        val index = rand.nextInt(0, set.size)
        return set.elementAt(index)
    }
}


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */