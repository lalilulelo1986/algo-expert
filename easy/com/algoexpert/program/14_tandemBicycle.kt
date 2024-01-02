package com.algoexpert.program

/*
    если тру, то собрать самую скоростной результат для партых велосипедистов
 */

fun tandemBicycle(
        redShirtSpeeds: MutableList<Int>,
        blueShirtSpeeds: MutableList<Int>,
        fastest: Boolean
): Int {
    // Write your code here.
    redShirtSpeeds.sort()
    if (fastest) blueShirtSpeeds.sortDescending() else blueShirtSpeeds.sort()

    var speed = 0
    for (i in redShirtSpeeds.indices) {
        speed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i])
    }

    return speed
}
