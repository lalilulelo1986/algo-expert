package com.algoexpert.program

/*{
  "array": [2, 1, 2, 2, 2, 3, 4, 2],
  "toMove": 2
} */

fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
    // Write your code here.
    var p = 0
    for (i in array.indices) {
        if (array[i] != toMove && i != p) {
            val tmp = array[p]
            array[p] = array[i]
            array[i] = tmp
            p++
        }
    }


    return array
}
