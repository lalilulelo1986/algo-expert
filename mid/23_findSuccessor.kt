package com.algoexpert.program.m23

// This is an input class. Do not edit.
open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
    var parent: BinaryTree? = null
}

// successor is not which be visited after some node(using inOrderTraverse)
fun findSuccessor(tree: BinaryTree, node: BinaryTree): BinaryTree? {
    return helper(tree, node).second
}

/*
    fun helper(node): Pair<Boolean, Int?> where first is wheather target was met,
                                            and second is result
*/
fun helper(tree: BinaryTree?, node: BinaryTree): Pair<Boolean, BinaryTree?> {
    if (tree == null) return false to null
    if (tree == node) return true to null

    val left = helper(tree.left, node)

    if (left.second != null) return left
    if (left.first) {
        return true to tree
    }

    return helper(tree.right, node)
}
