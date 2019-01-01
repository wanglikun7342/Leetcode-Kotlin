package com.eric.leetcode

class MaxAreaOfIsland {
    private lateinit var grid: Array<IntArray>
    private lateinit var seen: Array<BooleanArray>
    private var count = 0

    var dr = intArrayOf(1, -1, 0, 0)
    var dc = intArrayOf(0, 0, 1, -1)

    private fun getArea(r: Int, c: Int): Int {
        count++
        if (r < 0 || r >= grid.size || c < 0 || c >= grid[0].size ||
                seen[r][c] || grid[r][c] == 0)
            return 0
        seen[r][c] = true
        return 1 + getArea(r + 1, c) + getArea(r - 1, c) + getArea(r, c - 1) + getArea(r, c + 1)
    }

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        this.grid = grid
        seen = Array(grid.size) { BooleanArray(grid[0].size) }
        var ans = 0
        for (r in grid.indices) {
            for (c in grid[0].indices) {
                count = 0
                ans = maxOf(ans, getArea(r, c))
                println("r: $r, c: $c, count: $count")
            }
        }
        return ans
    }

    fun maxAreaOfIsland2(grid: Array<IntArray>): Int {
        this.grid = grid
        seen = Array(grid.size) { BooleanArray(grid[0].size) }
        var queue = mutableListOf<IntArray>()
        var ans = 0
        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (!seen[r][c] && grid[r][c] == 1) {
                    var shape = 0
                    seen[r][c] = true
                    queue.add(intArrayOf(r, c))
                        while (queue.isNotEmpty()) {
                            var node = queue.removeAt(0)
                            var rIndex = node[0]
                            var cIndex = node[1]
                            shape++
                            for (k in 0..3) {
                                val nr = rIndex + dr[k]
                                val nc = cIndex + dc[k]
                                if (nr in grid.indices &&
                                        nc in grid[0].indices &&
                                        grid[nr][nc] == 1 && !seen[nr][nc]) {
                                    queue.add(intArrayOf(nr, nc))
                                    seen[nr][nc] = true
                                }
                            }
                        }
                    ans = maxOf(ans, shape)
                }
            }
        }
        return ans
    }
}

fun main(args: Array<String>) {
    val grid = arrayOf(
            intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
            intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
            intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0))
    val grid2 = arrayOf(intArrayOf(1, 1))
    val maxAreaOfIsland = MaxAreaOfIsland()
    println("result: " + maxAreaOfIsland.maxAreaOfIsland2(grid))
}