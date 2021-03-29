package com.eric.leetcode

class LetterTilePossibilities {
    fun numTilePossibilities(tiles: String): Int {
        val visit = BooleanArray(tiles.length) {false}
        val result = mutableSetOf<String>()
        dfs(visit, tiles, "", result)
        return result.size - 1
    }

    private fun dfs(visit: BooleanArray, tiles: String, series: String, result: MutableSet<String>) {
        for (index in visit.indices) {
            if (visit[index]) {
                continue
            }
            visit[index] = true
            dfs(visit, tiles, series + tiles[index], result)
            visit[index] = false
        }
        result.add(series)
    }
}

fun main() {
    val letterTilePossibilities = LetterTilePossibilities()
    print(letterTilePossibilities.numTilePossibilities("VV"))
}