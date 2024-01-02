package com.algoexpert.program

fun getNthFib(n: Int): Int {
    // Write your code here.
    var a = 1
    var b = 1
    for (i in 2..n) {
        val tmp = b
        b = a + b
        a = tmp
    }

    return b
}
