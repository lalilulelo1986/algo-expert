package com.algoexpert.program

/*
    same as sorting gaming cards
*/

// O(n^2) time | O(1) space
fun insertionSort(array: MutableList<Int>): List<Int> {
    // Write your code here.
    for (i in 1..array.size - 1) {
        var j = i
        while (j > 0 && array[j] < array[j - 1]) {
            val tmp = array[j - 1]
            array[j - 1] = array[j]
            array[j] = tmp
            j--
        }
    }

    return array
}
