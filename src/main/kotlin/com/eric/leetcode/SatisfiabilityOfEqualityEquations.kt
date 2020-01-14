package com.eric.leetcode

class SatisfiabilityOfEqualityEquations {
    private class UnionFind(n: Int) {
        private val parent: Array<Int> = Array(n) {
            it
        }

        fun find(input: Int): Int {
            var x = input
            while (x != parent[x]) {
                parent[x] = parent[parent[x]]
                x = parent[x]
            }
            return x
        }

        fun union(x:Int, y:Int) {
            val rootX = find(x)
            val rootY = find(y)
            parent[rootX] = rootY
        }

        fun isConnected(x: Int, y: Int): Boolean {
            return find(x) == find(y)
        }
    }

    fun equationsPossible(equations: Array<String>): Boolean {
        val unionFind = UnionFind(26)
        for (equation in equations) {
            if (equation[1] == '=') {
                val index1 = equation[0] - 'a'
                val index2 = equation[3] - 'a'
                unionFind.union(index1, index2)
            }
        }

        for (equation in equations) {
            if (equation[1] == '!') {
                val index1 = equation[0] - 'a'
                val index2 = equation[3] - 'a'

                if (unionFind.isConnected(index1, index2)) {
                    // 如果合并失败，表示等式有矛盾，根据题意，返回 false
                    return false
                }
            }
        }
        // 如果检查了所有不等式，都没有发现矛盾，返回 true
        return true
    }
}

fun main(args: Array<String>) {
    val equations = arrayOf("a==c","c==d","d!=a")
    val satisfiabilityOfEqualityEquations = SatisfiabilityOfEqualityEquations()
    println(satisfiabilityOfEqualityEquations.equationsPossible(equations))
}