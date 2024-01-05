package com.algoexpert.program

/*
   values are from 1..n where n is lenght of array
   you can modify the array
*/
fun main() {
    val result = firstDuplicateValue(mutableListOf(2, 1, 5, 2, 3, 3, 4))
    print("Result: $result")
}

/*
    if visited we mark index by multiply by -1
*/
// O(n) time | O(1) space
fun firstDuplicateValue(array: MutableList<Int>): Int {
    // Write your code here.
    for (i in array.indices) {
        if (array[Math.abs(array[i]) - 1] < 0) return Math.abs(array[i])
        else array[Math.abs(array[i]) - 1] = -1 * array[Math.abs(array[i]) - 1]
    }

    return -1
}
