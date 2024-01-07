package com.algoexpert.program

fun main(args: Array<String>) {
    // assert(1 == majorityElement(mutableListOf(1, 2, 1)))
    // assert(3 == majorityElement(mutableListOf(3, 3, 1)))
    // assert(2 == majorityElement(mutableListOf(1, 2, 2, 2, 1)))
    // assert(2 == majorityElement(mutableListOf(1, 2, 3, 2, 3, 2, 2, 4, 2)))
    assert(2 == majorityElement(mutableListOf(1, 1, 1, 1, 2, 2, 2, 2, 2)))
}

fun majorityElement(array: MutableList<Int>): Int {
    var majority = array[0]
    var counter = 1
    for (i in 1..array.size - 1) {
        if (counter == 0) {
            majority = array[i]
            counter = 1
        } else {
            if (majority != array[i]) {
                counter--
            } else {
                counter++
            }
        }
    }

    return majority
}

fun majorityElement2(array: MutableList<Int>): Int {
    // Write your code here.
    var start = 0
    var end = array.size - 1
    var leftSame = false
    var leftFirst = 0
    var leftDiffs = 0
    var leftDiffs2 = 0
    var rightSame = false
    var rigthFirst = 0
    var rightDiffs = 0
    var rightDiffs2 = 0
    while (true) {

        println("$start : $end -> ")
        if (start == end) return array[start]

        val mid = (start + end) / 2

        leftSame = true
        leftFirst = 0
        leftDiffs = 0
        leftDiffs2 = 0
        rightSame = true
        rigthFirst = array[mid + 1]
        rightDiffs = 0
        rightDiffs2 = 0

        for (i in start..mid step 2) {
            if (i < mid) {
                if (array[i] != leftFirst || array[i + 1] != leftFirst) leftSame = false
                leftDiffs += if (array[i] == array[i + 1]) 1 else 0
            } else {
                if (array[i] != leftFirst || start == mid) leftSame = false
                leftDiffs2 += 1
            }
        }

        for (i in mid + 1..end step 2) {
            if (i < end) {
                if (array[i] != rigthFirst || array[i + 1] != rigthFirst) rightSame = false
                rightDiffs += if (array[i] == array[i + 1]) 1 else 0
            } else {
                if (array[i] != rigthFirst || mid + 1 == end) rightSame = false
                rightDiffs2 += 1
            }
        }

        if (leftSame.xor(rightSame) == true) {
            if (leftSame) end = mid else start = mid + 1
        } else if (leftDiffs.xor(rightDiffs) != 0) {
            if (leftDiffs > rightDiffs) end = mid else start = mid + 1
        } else if (leftDiffs2.xor(rightDiffs2) != 0) {
            if (leftDiffs2 > rightDiffs2) end = mid else start = mid + 1
        } else {
            start = mid + 1
        }
    }
}

fun majorityElementBroken(array: MutableList<Int>): Int {
    // Write your code here.
    var start = 0
    var end = array.size - 1
    var leftDiffs = 0
    var rightDiffs = 0
    while (true) {
        println("$start : $end -> ")
        if (start == end) return array[start]

        leftDiffs = 0
        rightDiffs = 0
        val mid = (start + end) / 2
        for (i in start..end) {
            if (i < mid) {
                leftDiffs += if (array[i] == array[i + 1]) 1 else 0
            } else if (i == mid) {
                leftDiffs += 1
            } else if (i < end) {
                rightDiffs += if (array[i] == array[i + 1]) 1 else 0
            } else {
                rightDiffs += 1
            }
        }

        if (leftDiffs > rightDiffs) {
            end = mid
        } else {
            start = mid + 1
        }
    }
}
