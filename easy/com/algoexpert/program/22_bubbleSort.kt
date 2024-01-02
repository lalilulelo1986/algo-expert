package com.algoexpert.program

// O(n^2) time | O(1) space
fun bubbleSort(array: MutableList<Int>): List<Int> {
    // Write your code here.

    var sorted = false
    while (sorted.not()) {
        sorted = true
        for (i in 1..array.size - 1) {
            if (array[i - 1] > array[i]) {
                val tmp = array[i]
                array[i] = array[i - 1]
                array[i - 1] = tmp
                sorted = false
            }
        }
    }

    return array
}
