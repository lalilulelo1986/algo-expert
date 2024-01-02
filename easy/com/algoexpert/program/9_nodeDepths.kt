package com.algoexpert.program

import java.util.Stack

// open class BinaryTree(value: Int) {
//     var value = value
//     var left: BinaryTree? = null
//     var right: BinaryTree? = null
// }

/*
    sum of all depth between root and each node
*/

fun nodeDepths(root: BinaryTree): Int {
    // Write your code here.

    return nodeDepthsHelper(root, 0)
}

fun nodeDepthsHelper(node: BinaryTree?, depth: Int): Int {
    // Write your code here.
    if (node == null) return 0
    return nodeDepthsHelper(node.left, depth + 1) + nodeDepthsHelper(node.right, depth + 1) + depth
}

fun nodeDepths2(root: BinaryTree): Int {
    // Write your code here.
    var result = 0
    val stack = Stack<Pair<BinaryTree, Int>>()
    stack.add(root to 0)
    while (stack.isNotEmpty()) {
        val curr = stack.pop()
        result += curr.second
        if (curr.first.left != null) {
            stack.add(curr.first.left!! to curr.second + 1)
        }
        if (curr.first.right != null) {
            stack.add(curr.first.right!! to curr.second + 1)
        }
    }

    return result
}
