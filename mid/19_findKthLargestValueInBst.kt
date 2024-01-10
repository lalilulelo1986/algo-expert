package com.algoexpert.program.m19

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
    val bst = BST(5)
    bst.insert(4)
    bst.insert(2)
    bst.insert(4)

    bst.insert(9)
    bst.insert(7)
    bst.insert(12)

    println(findKthLargestValueInBst(bst, 3))
}

/* v2
 */
data class TreeInfo(var visitedTimes: Int, var lastVisited: Int)

// O(h + k) time | O(h) space
fun findKthLargestValueInBst(tree: BST, k: Int): Int {
    val treeInfo = TreeInfo(0, -1)

    helper(tree, k, treeInfo)

    return treeInfo.lastVisited
}

fun helper(tree: BST, k: Int, info: TreeInfo) {
    tree.right?.let { helper(it, k, info) }

    if (info.visitedTimes == k ) return
    info.visitedTimes = info.visitedTimes + 1
    info.lastVisited = tree.value

    tree.left?.let { helper(it, k, info) }
}

// O(h + k) time | O(h + k) space
fun findKthLargestValueInBst2(tree: BST, k: Int): Int {
    val array = mutableListOf<Int>()
    helper(tree, k, array)

    return array[k - 1]
}

fun helper(tree: BST, k: Int, array: MutableList<Int>) {
    if (array.size >= k) return

    tree.right?.let { helper(it, k, array) }
    array.add(tree.value)
    tree.left?.let { helper(it, k, array) }
}


