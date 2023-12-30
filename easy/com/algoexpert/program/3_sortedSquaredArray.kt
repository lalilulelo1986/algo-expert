package com.algoexpert.program

fun sortedSquaredArray(array: List<Int>): List<Int> {
    // Write your code here.
    val result = MutableList<Int>(array.size) { 0 }
    array.forEachIndexed { ind, it -> result[ind] = it * it }

    return result.sorted()
}

fun sortedSquaredArray2(array: List<Int>): List<Int> {
    // Write your code here.
    if (array.size == 1)
        return listOf(array[0] * array[0])

    var left: Int = -1
    var right: Int
    for (i in array.indices) {
        if (array[i] < 0)
            left++
    }
    right = left + 1

    val result = MutableList<Int>(array.size) { 0 }
    var p = 0
    while(left >= 0 || right < array.size) {
        val lval = if (left < 0) Int.MAX_VALUE else array[left]
        val rval = if (right >= array.size) Int.MAX_VALUE else array[right]

        if (Math.abs(lval) < Math.abs(rval)) {
            result[p] = lval * lval
            left--
        } else {
            result[p] = rval * rval
            right++
        }
        p++
    }
    
    return result
}