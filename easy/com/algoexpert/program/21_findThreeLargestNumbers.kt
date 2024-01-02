package com.algoexpert.program

import java.util.PriorityQueue

// O(log(n)) time | O(n) space
fun findThreeLargestNumbers(array: List<Int>): List<Int> {
    // Write your code here.
    val heap = PriorityQueue<Int>(Comparator() { a, b -> b - a })
    array.forEach { heap.add(it) }
    val result = MutableList(3) { 0 }
    result[2] = heap.poll()
    result[1] = heap.poll()
    result[0] = heap.poll()
    return result
}

fun findThreeLargestNumbers2(array: List<Int>): List<Int> {
    // Write your code here.
    val result = MutableList(3) { Int.MIN_VALUE }

    array.forEach {
        if (it > result[2]) {
            result[0] = result[1]
            result[1] = result[2]
            result[2] = it
        } else if (it > result[1]) {
            result[0] = result[1]
            result[1] = it
        } else if (it > result[0]) {
            result[0] = it
        }
    }

    return result
}
