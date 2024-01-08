package com.algoexpert.program

// open class BST(value: Int) {
//     var value = value
//     var left: BST? = null
//     var right: BST? = null
// }

// O(n) time | O(d) space
fun validateBst(tree: BST): Boolean {
    // Write your code here.
    return validateBstHelper(tree, Int.MIN_VALUE, Int.MAX_VALUE)
}

fun validateBstHelper(tree: BST?, left: Int, right: Int): Boolean {
    if (tree == null) return true
    if (tree.value < left || tree.value > right) return false

    return validateBstHelper(tree.left, left, tree.value - 1) &&
            validateBstHelper(tree.right, tree.value, right)
}