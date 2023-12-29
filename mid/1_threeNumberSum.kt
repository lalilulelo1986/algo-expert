package com.algoexpert.program

fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    // Write your code here
    array.sort()
    val result = mutableListOf<List<Int>>()
    for (i in 0..array.size - 3) {
        var left = i + 1
        var right = array.size - 1
        while (left < right) {
            val curSum = array[i] + array[left] + array[right]
            if (curSum == targetSum) {
                result.add(listOf(array[i], array[left], array[right]))
                right--
            }
            if (curSum > targetSum)
                right--
            if (curSum < targetSum)
                left++
        }
    }

    return result
}
