package com.algoexpert.program

fun smallestDifference(arrayOne: MutableList<Int>, arrayTwo: MutableList<Int>): List<Int> {
    // Write your code here.
    arrayOne.sort()
    arrayTwo.sort()

    var p1 = 0
    var p2 = 0
    var pair = arrayOne[p1] to arrayTwo[p2]
    var diff = Math.abs(pair.first - pair.second)

    while (p1 < arrayOne.size && p2 < arrayTwo.size) {
        if (p1 < p2) {
            p1++
        } else {
            p2++
        }

        val newDiff = arrayOne[p1] to arrayTwo[p2]
        if (newDiff )
    }

    return listOf<Int>()
}