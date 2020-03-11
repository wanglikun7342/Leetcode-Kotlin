package com.eric.leetcode


class DesignSkiplist {
    companion object {
        const val MAX_LEVEL = 16
        const val P = 0.5
    }

    private val head = Node(-1, MAX_LEVEL + 1)

    class Node(value: Int, size: Int) {
        val num = value
        val forward = Array<Node?>(size) { null }
        var backward: Node? = null
    }

    fun search(target: Int): Boolean {
        val pos = searchNode(target)
        return pos?.num == target
    }

    fun add(num: Int) {
        val pos = searchNode(num)
        val new = Node(num, randomLevel())
        new.backward = pos
        for (level in 0 until new.forward.size) {
            var f = pos
            while (f?.backward != null && f.forward.size < level + 1) {
                f = f.backward // 前向查找
            }
            if (level == 0 && f?.forward?.get(level) != null) {
                f.forward[level]?.backward = new // 串联进中间
            }

            new.forward[level] = f?.forward?.get(level) // 连接
            f?.forward?.set(level, new)
        }
    }

    fun erase(num: Int): Boolean {
        val pos = searchNode(num)
        if (pos?.num != num) {
            return false
        } else {
            for (level in 0 until pos.forward.size) {
                var f = pos.backward
                while (f?.backward != null && f.forward.size < level + 1) {
                    f = f.backward // 前向查找
                }
                if (level == 0 && f?.forward?.get(level)?.forward?.get(level) != null) {
                    f.forward[level]?.forward?.get(level)?.backward = f // 删掉中间
                }
                f?.forward?.set(level, f.forward[level]?.forward?.get(level))
            }
            return true
        }
    }

    private fun randomLevel(): Int {
        var level = 1
        while (Math.random() < P && level + 1 < MAX_LEVEL) {
            level++
        }
        return level
    }

    private fun searchNode(num: Int): Node? {
        if (isEmpty()) {
            return head
        }
        var cur: Node? = head
        for (level in MAX_LEVEL downTo 0) {
            while (cur?.forward?.get(level) != null && cur.forward[level]!!.num <= num) {
                cur = cur.forward[level]
            }
        }
        return cur
    }

    private fun isEmpty(): Boolean {
        return head.forward[0] == null
    }
}

fun main(args: Array<String>) {
    // Your Skiplist object will be instantiated and called as such:
    val obj = DesignSkiplist()
    obj.add(10)
    var param_1 = obj.search(10)
    obj.add(10)
    var param_2 = obj.search(20)
    var param_3 = obj.erase(10)
}