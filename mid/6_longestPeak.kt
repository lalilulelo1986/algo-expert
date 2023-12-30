package com.algoexpert.program

fun longestPeak(array: List<Int>): Int {
    // Write your code here.
    var maxPick = 0
    var currPick = 0
    for (i in 1..array.size - 1) {
        val diff = array[i] - array[i - 1]

        var up = 0
        var down = 0
        if (diff > 0) {
            if (down > 0) {
                up = 0
            }
            up++
            down = 0
        } else if (diff < 0) {
            down++
        } else {
            up = 0
            down = 0
        }
        if (up > 0 && down > 0) {
            maxPick = Math.max(maxPick, up + down)
        }

        if (diff > 0) {
            if (currPick < 0) {
                currPick = 0
            }
            currPick++
        } else if (diff < 0 && currPick != 0) {
            if (currPick > 0) {
                currPick *= -1
            }
            currPick--
        } else {
            currPick = 0
        }
        if (currPick < 0) maxPick = Math.max(maxPick, Math.abs(currPick))
    }

    return maxPick
}
