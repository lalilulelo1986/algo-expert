package com.algoexpert.program

// This is an input class. Do not edit.
// open class BinaryTree(value: Int) {
//     var value = value
//     var left: BinaryTree? = null
//     var right: BinaryTree? = null
// }

fun evaluateExpressionTree(tree: BinaryTree): Int {
    // Write your code here.
    if (tree.value == -1) {
        return evaluateExpressionTree(tree.left!!) + evaluateExpressionTree(tree.right!!)
    } else if (tree.value == -2) {
        return evaluateExpressionTree(tree.left!!) - evaluateExpressionTree(tree.right!!)
    } else if (tree.value == -3) {
        return evaluateExpressionTree(tree.left!!) / evaluateExpressionTree(tree.right!!)
    } else if (tree.value == -4) {
        return evaluateExpressionTree(tree.left!!) * evaluateExpressionTree(tree.right!!)
    } else {
        return tree.value
    }
}