package com.algoexpert.program

/*
   values are from 1..n where n is lenght of array
   you can modify the array
*/
fun main() {
    val result = firstDuplicateValue(mutableListOf(2, 1, 5, 2, 3, 3, 4))
    print("Result: $result")
}

fun firstDuplicateValue(array: MutableList<Int>): Int {
    // Write your code here.
    for (i in array.indices) {
        if (array[i] == -2) return i + 1
        if (array[i] == array[array[i] - 1]) array[array[i] - 1] = -2

        if (i != array[i]) {
            if (array[i] == array[array[i]]) {
                return array[i]
            } else {
                val tmp = array[i]
                array[i] = array[array[i]]
                array[array[i]] = tmp
            }
        }
    }

    return -1
}
