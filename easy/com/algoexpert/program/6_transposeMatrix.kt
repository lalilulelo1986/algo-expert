package com.algoexpert.program

fun transposeMatrix(matrix: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    // Write your code here.
    val result = mutableListOf<MutableList<Int>>()

    for (y in 0..matrix[0].size - 1) {
        val arr = mutableListOf<Int>()
        for (x in 0..matrix.size - 1) {
            arr.add(matrix[x][y])
        }
        result.add(arr)
    }

    return result
}
