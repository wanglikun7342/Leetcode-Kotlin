package com.eric.leetcode

class ProjectionAreaOf3DShapes {
    fun projectionArea(grid: Array<IntArray>): Int {
        var top = 0
        var left = 0
        var front = 0

        grid.indices.forEach { i ->
            grid[0].indices.forEach { j ->
                if (grid[i][j] > 0) {
                    top++
                }
            }
        }

        var yMax = 0
        grid.indices.forEach { i ->
            grid[0].indices.forEach { j ->
                if (grid[i][j] > yMax) {
                    yMax = grid[i][j]
                }
            }
            left += yMax
            yMax = 0
        }

        var xMax = 0
        grid[0].indices.forEach { j ->
            grid.indices.forEach { i ->
                if (grid[i][j] > xMax) {
                    xMax = grid[i][j]
                }
            }
            front += xMax
            xMax = 0
        }
        return top + left + front
    }
}

fun main(args: Array<String>) {
    val input = arrayOf(intArrayOf(1, 0), intArrayOf(0, 2))
    val projectionAreaOf3DShapes = ProjectionAreaOf3DShapes()
    println(projectionAreaOf3DShapes.projectionArea(input))
}