package com.algoexpert.program

/*
    [1, 0, 1, 0, 0, 0]
    best seat is ind: 4
    it the midle of most empty space
*/

// O(n) time | O(1) space
fun bestSeat(seats: MutableList<Int>): Int {
    // Write your code here.
    var left = 0
    var max = 0
    var result = -1
    var cur = 0
    for (i in seats.indices) {
        if (seats[i] == 0) {
            cur++
        } else {
            if (cur > 0 && cur > max) {
                max = cur
                result = (left + i) / 2 
            }
            left = i
            cur = 0
        }
    }

    return result
}
