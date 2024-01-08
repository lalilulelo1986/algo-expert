package com.algoexpert.program

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null

    fun insert(value: Int) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = BST(value)
            } else {
                this.left!!.insert(value)
            }
        } else {
            if (this.right == null) {
                this.right = BST(value)
            } else {
                this.right!!.insert(value)
            }
        }
    }
}

fun main() {
    minHeightBst(listOf(1, 2, 3, 4, 5))
}

// O(n) time | O(n) space
fun minHeightBst(array: List<Int>): BST {
    val sorted = array.sorted()
    return minHeightBstHelper(sorted, 0, sorted.size - 1)!!
}

fun minHeightBstHelper(array: List<Int>, start: Int, end: Int): BST? {
    if (start > end) return null
    if (start == end) return BST(array[start])

    val mid = (start + end) / 2
    val cur = BST(array[mid])
    cur.left = minHeightBstHelper(array, start, mid - 1)
    cur.right = minHeightBstHelper(array, mid + 1, end)
    return cur
}
