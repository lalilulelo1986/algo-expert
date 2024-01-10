package com.algoexpert.program.m20

// This is an input class. Do not edit.
open class BST(value: Int, left: BST? = null, right: BST? = null) {
    var value = value
    var left = left
    var right = right
}

fun main(args: Array<String>) {
    val bst = reconstructBst(listOf(10, 4, 2, 1, 3, 5, 6, 9, 7, 17, 19, 18))
    // println(bst?.value)
    // println(bst?.left?.value)
    // println(bst?.right?.value)
}

data class TreeInfo(var idx: Int)

fun reconstructBst(preOrderTraversalValues: List<Int>): BST? {
    if (preOrderTraversalValues.isEmpty()) return null

    val root = BST(preOrderTraversalValues[0])
    val treeInfo = TreeInfo(1)

    helper(preOrderTraversalValues, root, treeInfo, Int.MIN_VALUE, Int.MAX_VALUE)

    return root
}

fun helper(
        preOrderTraversalValues: List<Int>,
        node: BST,
        treeInfo: TreeInfo,
        start: Int,
        end: Int
): BST {
    if (treeInfo.idx > preOrderTraversalValues.size - 1) return node
    var newVal = preOrderTraversalValues[treeInfo.idx]

    if (newVal < node.value && newVal >= start) {
        treeInfo.idx = treeInfo.idx + 1
        node.left = helper(preOrderTraversalValues, BST(newVal), treeInfo, start, node.value)
    }

    if (treeInfo.idx > preOrderTraversalValues.size - 1) return node
    newVal = preOrderTraversalValues[treeInfo.idx]
    if (newVal >= node.value && newVal < end) {
        treeInfo.idx = treeInfo.idx + 1
        node.right = helper(preOrderTraversalValues, BST(newVal), treeInfo, node.value, end)
    }
    return node
}
