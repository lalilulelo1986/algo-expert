package com.algoexpert.program

/*
    you can reorder execution of queries in order to find minimum total waiting time of hole run
*/

fun minimumWaitingTime(queries: MutableList<Int>): Int {
    // Write your code here.
    queries.sort()

    var total = 0
    var curr = 0
    for (i in 1..queries.size - 1) {
        curr = curr + queries[i - 1]
        total += curr
    }
    
    return total
}
