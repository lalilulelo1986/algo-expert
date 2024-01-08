package com.algoexpert.program

// open class BST(value: Int) {
//     var value = value
//     var left: BST? = null
//     var right: BST? = null
// }
fun main(args: Array<String>) {
    val bst = BST(3)
    bst.insert(2)
    bst.insert(3)
    bst.insert(4)

    println(inOrderTraverse(bst, mutableListOf()))
}

// O(n) time | O(d) space
fun inOrderTraverse(tree: BST, array: MutableList<Int>): List<Int> {
    if (tree.left != null) inOrderTraverse(tree.left!!, array)
    array.add(tree.value)
    if (tree.right != null) inOrderTraverse(tree.right!!, array)

    return array
}

// O(n) time | O(d) space
fun preOrderTraverse(tree: BST, array: MutableList<Int>): List<Int> {
    array.add(tree.value)
    if (tree.left != null) preOrderTraverse(tree.left!!, array)
    if (tree.right != null) preOrderTraverse(tree.right!!, array)

    return array
}

// O(n) time | O(d) space
fun postOrderTraverse(tree: BST, array: MutableList<Int>): List<Int> {
    if (tree.left != null) postOrderTraverse(tree.left!!, array)
    if (tree.right != null) postOrderTraverse(tree.right!!, array)
    array.add(tree.value)

    return array
}