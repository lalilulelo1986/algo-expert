package com.algoexpert.program

// open class BST(value: Int) {
//     var value = value
//     var left: BST? = null
//     var right: BST? = null
// }

fun findClosestValueInBst1(tree: BST, target: Int): Int {
    // Write your code here.
    var curr: BST? = tree
    var result = tree.value
    while(curr != null) {
        if (Math.abs(target - curr.value) < Math.abs(target - result)) 
            result = curr.value
        if (curr.value > target) {
            curr = curr.left
        } else if (curr.value < target) {
            curr = curr.right
        } else {
            break
        }
    }

    return result
}

fun findClosestValueInBst(tree: BST, target: Int): Int {
    // Write your code here.
    if (tree.value == target) {
        return target
    }
    var next: Int = tree.value
    if (tree.value > target && tree.left != null) {
        next = findClosestValueInBst(tree.left!!, target)
    } else if (tree.value < target && tree.right != null) {
        next = findClosestValueInBst(tree.right!!, target)
    }
    if (Math.abs(target - tree.value) < Math.abs(target - next)) 
        return tree.value
    else 
        return next
}