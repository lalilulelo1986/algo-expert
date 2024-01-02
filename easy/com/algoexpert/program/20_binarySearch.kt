package com.algoexpert.program

// O(long(n)) time O(1) space
fun binarySearch(array: List<Int>, target: Int): Int {
    // Write your code here.
    var l = 0
    var r = array.size - 1
    while (r >= l) {
        val mid = (r + l) / 2
        if (array[mid] == target) {
            return mid
        }
        if (array[mid] < target) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }

    return -1
}

// O(long(n)) time O(long(n)) space
fun binarySearch2(array: List<Int>, target: Int, l: Int = 0, r: Int = array.size - 1): Int {
    if (r < l) return -1

    val mid = (r + l) / 2
    if (array[mid] == target) {
        return mid
    }
    if (array[mid] < target) {
        return binarySearch2(array, target, mid + 1, r)
    } else {
        return binarySearch2(array, target, l, mid - 1)
    }
}
