package com.algoexpert.program

// {
//     "arrayOne": [-1, 5, 10, 20, 28, 3],
//     "arrayTwo": [26, 134, 135, 15, 17]
// }
// time(sorting): nlog(n) + mlog(m)
// spase: O(1)
fun smallestDifference(arrayOne: MutableList<Int>, arrayTwo: MutableList<Int>): List<Int> {
    // Write your code here.
    arrayOne.sort()
    arrayTwo.sort()

    var p1 = 0
    var p2 = 0
    var pair = arrayOne[p1] to arrayTwo[p2]
    var diff = Int.MAX_VALUE

    // var diff = Math.abs(pair.first - pair.second)

    while (p1 < arrayOne.size && p2 < arrayTwo.size) {
        val newDiff = Math.abs(arrayOne[p1] - arrayTwo[p2])
        if (newDiff < diff) {
            diff = newDiff
            pair = arrayOne[p1] to arrayTwo[p2]
        }

        if (arrayOne[p1] < arrayTwo[p2] ) {
            p1++
        } else {
            p2++
        }
    }

    return listOf<Int>(pair.first, pair.second)
}