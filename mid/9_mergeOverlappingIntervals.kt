package com.algoexpert.program

// O(nlog(n)) | O(n)
fun mergeOverlappingIntervals(intervals: List<List<Int>>): List<List<Int>> {
    // Write your code here.
    val sorted = intervals.sortedBy { it[0] }

    var rightBorder = Int.MIN_VALUE
    var result = mutableListOf<MutableList<Int>>()
    for (i in sorted.indices) {
        if (sorted[i][0] > rightBorder) {
            result.add(mutableListOf(sorted[i][0], sorted[i][1]))
            rightBorder = sorted[i][1]
        } else {
            val newMaxRightBorder = Math.max(sorted[i][1], result[result.size - 1][1])
            result[result.size - 1][1] = newMaxRightBorder
            rightBorder = newMaxRightBorder
        }
    }

    return result
}

fun main(args: Array<String>) {
    println(
            mergeOverlappingIntervals(
                    mutableListOf(
                            mutableListOf(9, 10),
                            mutableListOf(1, 2),
                            mutableListOf(3, 5),
                            mutableListOf(4, 7),
                            mutableListOf(6, 8),
                    )
            )
    )
}