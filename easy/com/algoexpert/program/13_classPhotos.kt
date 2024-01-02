package com.algoexpert.program

/*
    студенты с их ростом. синие студенты должны быть на заднем ряду и должны быть выше передних
*/

fun classPhotos(redShirtHeights: MutableList<Int>, blueShirtHeights: MutableList<Int>): Boolean {
    // Write your code here.
    redShirtHeights.sort()
    blueShirtHeights.sort()

    for (i in redShirtHeights.indices) {
        if (redShirtHeights[i] >= blueShirtHeights[i]) {
            return false
        }
    }
    
    return true
}
