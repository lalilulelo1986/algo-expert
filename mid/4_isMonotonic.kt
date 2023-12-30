package com.algoexpert.program

// monotonic if all element are entirely non-increasing or non-decreasing

fun isMonotonic(array: List<Int>): Boolean {
    // Write your code here.
    if (array.size <= 2)
        return true

    var isIncreasing: Boolean = true
    var isDecreasing: Boolean = true
    for (i in 1..array.size - 1) {
        val diff = array[i] - array[i-1]
        if (diff < 0 && isIncreasing) {
            isIncreasing = false
        }
        if (diff > 0 && isDecreasing) {
            isDecreasing = false
        }
    }

    return isIncreasing || isDecreasing
}