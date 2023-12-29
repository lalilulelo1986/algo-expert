package com.algoexpert.program

fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    // Write your code here.
    val visited = mutableSetOf<Int>()

    for (i in array.indices) {
        val exists = visited.contains(targetSum - array[i])
        if (exists) {
            return listOf(array[i], targetSum - array[i])
        } else {
            visited.add(array[i])
        }
    }
    return listOf<Int>()
}