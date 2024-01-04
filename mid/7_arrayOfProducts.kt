package com.algoexpert.program

// O(n) time | O(n) space
fun arrayOfProducts(array: List<Int>): List<Int> {
    val result = MutableList<Int>(array.size) { 1 }

    ArrayList(array)
    val fromLeft = ArrayList(array)
    val fromRight = ArrayList(array)

    for (i in 1..array.size - 1) {
        fromLeft[i] = fromLeft[i - 1] * array[i]
    }

    for (i in array.size - 2 downTo 0) {
        fromRight[i] = fromRight[i + 1] * array[i]
    }

    for (i in result.indices) {
        if (i == 0) {
            result[i] = fromRight[i + 1]
        } else if (i == result.size - 1) {
            result[i] = fromLeft[i - 1]
        } else {
            result[i] = fromLeft[i - 1] * fromRight[i + 1]
        }
    }

    return result
}
