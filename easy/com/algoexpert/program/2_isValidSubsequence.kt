package com.algoexpert.program

fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    // Write your code here.
    var p1 = 0
    var p2 = 0
    while (p1 < array.size) {
        if (array[p1] == sequence[p2]) {
            p2++
        } 
        p1++

        if (p2 >= sequence.size) {
            return true
        }
    }

    return false
}
