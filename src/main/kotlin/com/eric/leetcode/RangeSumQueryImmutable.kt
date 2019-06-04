package com.eric.leetcode

class RangeSumQueryImmutable(nums: IntArray) {
    val sums = IntArray(nums.size + 1)

    init {
        for (index in nums.indices) {
            sums[index + 1] = sums[index] + nums[index]
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * var obj = NumArray(nums)
     * var param_1 = obj.sumRange(i,j)
     */

    fun sumRange(i: Int, j: Int): Int {
        return sums[j + 1] - sums[i]
    }
}

fun main(args: Array<String>) {
    val rangeSumQueryImmutable = RangeSumQueryImmutable(intArrayOf(-2, 0, 3, -5, 2, -1))
    val sum = rangeSumQueryImmutable.sumRange(0, 2)
    println(sum)
}