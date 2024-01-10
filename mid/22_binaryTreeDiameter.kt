package com.algoexpert.program

// This is an input class. Do not edit.
// open class BinaryTree(value: Int) {
//     var value = value
//     var left: BinaryTree? = null
//     var right: BinaryTree? = null
// }

// O(n) time | O(d)
fun binaryTreeDiameter(tree: BinaryTree?): Int {
    return helper(tree).second
}

fun helper(tree: BinaryTree?): Pair<Int, Int> {
    if (tree == null) {
        return 0 to 0
    }

    val leftMax = helper(tree?.left)
    val rightMax = helper(tree?.right)

    val maxLenght = Math.max(leftMax.first, rightMax.first)
    val diam = Math.max(Math.max(leftMax.second, rightMax.second), leftMax.first + rightMax.first)

    return maxLenght + 1 to diam
}
