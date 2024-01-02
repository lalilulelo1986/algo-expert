package com.algoexpert.program

/*
    same as sorting gaming cards
*/

// O(n^2) time | O(1) space
fun insertionSort(array: MutableList<Int>): List<Int> {
    // Write your code here.
    for (i in 0..array.size - 2) {
        for (ii in i + 1..array.size - 1) {
            if (array[i] > array[ii]) {
                val tmp = array[ii]
                array[ii] = array[i]
                array[i] = tmp

                for (iii in i downTo 1) {
                    if (array[iii] < array[iii - 1]) {
                        val tmp2 = array[iii]
                        array[iii] = array[iii - 1]
                        array[iii - 1] = tmp2
                    }
                }
            }
        }
    }

    return array
}
