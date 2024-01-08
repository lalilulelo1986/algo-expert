package com.algoexpert.program.bst

import java.util.Stack

// Do not edit the class below except for
// the insert, contains, and remove methods.
// Feel free to add new properties and methods
// to the class.

fun main(args: Array<String>) {
    val bst = BST(1)
    bst.insert(2)
    bst.insert(3)
    bst.insert(4)

    val rem = bst.remove(1)
    // bst.remove(15)
    // bst.remove(10)

    rem.print()
    println()

}

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null

    fun print() {
        print("${this.value}, ")
        if (this.left != null) print(this.left!!)
        if (this.right != null) print(this.right!!)
    }

    fun insert(value: Int) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = BST(value)
            } else {
                this.left!!.insert(value)
            }
        } else {
            if (this.right == null) {
                this.right = BST(value)
            } else {
                this.right!!.insert(value)
            }
        }
    }

    fun contains(value: Int): Boolean {
        // Write your code here.
        var cur: BST? = this
        while (cur != null) {
            if (cur.value == value) {
                return true
            } else {
                if (value < cur.value) cur = cur.left else cur = cur.right
            }
        }
        return false
    }

    fun remove(value: Int): BST {
        var cur: BST? = this
        var prev: BST? = null
        while (cur != null) {
            if (cur.value == value) {
                if (prev == null) {
                    println("prev is null")
                    var newRoot: BST? = null
                    if (cur?.right != null) {
                        newRoot = cur?.right
                        cur?.left?.let { newRoot!!.add(it) }
                    } else if (cur?.left != null) {
                        newRoot = cur?.left
                        cur?.right?.let { newRoot!!.add(it) }
                    } else {
                        return BST(3)
                    }
                    return newRoot!!
                }

                if (cur.value < prev!!.value) {
                    prev?.left = cur?.right
                    //cur?.left?.let { add(it) }
                } else {
                    prev?.right = cur?.right
                    //cur?.left?.let { add(it) }
                }
                break
            } else {
                prev = cur
                if (value < cur.value) cur = cur.left else cur = cur.right
            }
        }

        return this
    }

    fun add(bst: BST) {
        var stack = Stack<BST>()
        stack.add(bst)
        while (stack.isNotEmpty()) {
            val cur = stack.pop()
            insert(cur.value)

            if (cur.left != null) stack.add(cur.left)
            if (cur.right != null) stack.add(cur.right)
        }
    }
}
