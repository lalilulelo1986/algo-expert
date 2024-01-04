package com.algoexpert.program

/*
    is string like mirror
*/

// O(n) time | O(1) space
fun isPalindrome(string: String): Boolean {
    // Write your code here.
    var start = 0
    var end = string.length - 1
    while (start <= end) {
        if (string[start] != string[end])
            return false
        start++
        end--
    }

    return true
}
