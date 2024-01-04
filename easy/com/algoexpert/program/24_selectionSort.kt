package com.algoexpert.program

/*
    прегаем много раз, находя самый маленький элемент и двигаем в начало
*/

// O(n^2) time | O(1) space
fun selectionSort(array: MutableList<Int>): List<Int> {
    // Write your code here.
    var p = 0
    while (p < array.size - 1) {
        var smallIdx = p
        for (i in p + 1..array.size - 1) {
            if (array[i] < array[smallIdx]) {
                smallIdx = i
            }
        }
        val tmp = array[p]
        array[p] = array[smallIdx]
        array[smallIdx] = tmp

        p++
    }
    return array
}
