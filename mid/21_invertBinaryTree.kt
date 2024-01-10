package com.algoexpert.program

// open class BinaryTree(value: Int) {
//     var value = value
//     var left: BinaryTree? = null
//     var right: BinaryTree? = null
// }

fun invertBinaryTree(tree: BinaryTree) {
    val temp = tree.left
    tree.left = tree.right
    tree.right = temp

    if (tree.left != null)
        invertBinaryTree(tree.left!!)
    if (tree.right != null)
        invertBinaryTree(tree.right!!)

    // Write your code here.
}
