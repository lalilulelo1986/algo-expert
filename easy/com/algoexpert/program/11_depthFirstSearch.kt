package com.algoexpert.program

import java.util.Stack

class Node(name: String) {
    val name: String = name
    val children = mutableListOf<Node>()

    fun depthFirstSearch(): List<String> {
        // Write your code here.
        val result = mutableListOf<String>()
        result.add(name)
        val stack = Stack<Node>()
        for (i in children.indices.reversed()) {
            stack.add(children[i])
        }
        while (stack.isNotEmpty()) {
            val cur = stack.pop()
            result.add(cur.name)
            for (i in cur.children.indices.reversed()) {
                stack.add(cur.children[i])
            }
        }

        return result
    }

    fun depthFirstSearch2(): List<String> {
        // Write your code here.
        var result = listOf<String>()
        result = result + mutableListOf(name)
        result = result + depthFirstSearch2Helper(children)
        return result
    }

    fun depthFirstSearch2Helper(children: MutableList<Node>): List<String> {
        // Write your code here.
        var result = listOf<String>()
        for (i in children.indices) {
            result = result + children[i].name + depthFirstSearch2Helper(children[i].children)
        }
        return result
    }
}
