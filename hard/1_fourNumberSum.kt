package com.algoexpert.program

fun fourNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    // Write your code here.
    val result = mutableListOf<List<Int>>()

    val pairs = mutableMapOf<Int, MutableList<List<Int>>>()
    for (i in 0..array.size - 2) {
        for (ii in i + 1..array.size - 1) {
            val currentSum = array[i] + array[ii]
            val diferrence = targetSum - currentSum
            if (pairs.containsKey(diferrence)) {
                pairs[diferrence]?.forEach { it -> result.add(listOf(it[0], it[1], array[i], array[ii])) }
            }
            val pair = pairs[targetSum - (array[i] + array[ii])]
            if (pair != null) {
                pair.forEach { it -> result.add(listOf(it[0], it[1], array[i], array[ii])) }
            }
        }

        for (k in 0..i - 1) {
            val currentSum = array[i] + array[k]
            if (pairs.containsKey(currentSum)) {
                pairs[currentSum]?.add(listOf(array[k], array[i]))
            } else {
                pairs[array[k] + array[i]] = mutableListOf(listOf(array[k], array[i]))
            }
        }
    }

    return result
}
