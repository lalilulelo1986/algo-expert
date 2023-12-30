package com.algoexpert.program

fun spiralTraverse(array: List<List<Int>>): List<Int> {
    // Write your code here.
    val result = mutableListOf<Int>()

    var dir = 0
    var mov = 0 to 1
    var x = 0
    var y = 0
    var top = -1
    var right = array[0].size
    var bottom = array.size
    var left = -1
    while (top + 1 < bottom && left + 1 < right) {
        result.add(array[x][y])

        if (dir == 0 && y + 1 == right) {
            top++
            dir = 1
            mov = 1 to 0
        } else if (dir == 1 && x + 1 == bottom) {
            right--
            dir = 2
            mov = 0 to -1
        } else if (dir == 2 && y - 1 == left) {
            bottom--
            dir = 3
            mov = -1 to 0
        } else if (dir == 3 && x - 1 == top) {
            left++
            dir = 0
            mov = 0 to 1
        }

        x += mov.first
        y += mov.second
    }

    return result
}

fun spiralTraverse2(array: List<List<Int>>): List<Int> {
    // Write your code here.
    val result = mutableListOf<Int>()

    var xStart = 0
    var xEnd = array.size - 1
    var yStart = 0
    var yEnd = array[0].size - 1
    
    while (xStart <= xEnd && yStart <= yEnd) {
        for (i in yStart..yEnd)
            result.add(array[xStart][i])
        for (i in xStart + 1..xEnd)
            result.add(array[i][yEnd])
        for (i in yEnd - 1 downTo yStart )
            if (xStart != xEnd)
                result.add(array[xEnd][i])
        for (i in xEnd - 1 downTo xStart + 1)
            if (yStart != yEnd)
                result.add(array[i][xStart])

        xStart++
        xEnd--
        yStart++
        yEnd--
    }

    return result
}
