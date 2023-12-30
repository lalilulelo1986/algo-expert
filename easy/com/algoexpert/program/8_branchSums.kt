package com.algoexpert.program

/*
    return list of all posible path summs. path summ is sum of all node from root to some leaf
*/

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

fun branchSums(root: BinaryTree): List<Int> {
    // Write your code here.
    val result = mutableListOf<Int>()
    branchSumsHelper(root, 0, result)
    return result
}

fun branchSumsHelper(root: BinaryTree?, sum: Int, result: MutableList<Int>) {
    // Write your code here.
    if (root == null) 
        return
    val curSum = sum + root.value
    if (root.left == null && root.right == null) {
        result.add(curSum)
    } else {
        branchSumsHelper(root.left, curSum, result)
        branchSumsHelper(root.right, curSum, result)
    }

}