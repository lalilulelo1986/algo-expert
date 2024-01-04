package com.algoexpert.program

/*
{
  "string": "AAAAAAAAAAAAABBCCCCDD"
}

result "9A4A2B4C2D" - в пары (длина, символ)
*/

// O(n) time | O(n) space
fun runLengthEncoding(string: String): String {
    // Write your code here.
    if (string.length == 0) return ""

    var length = 1
    var prev: Char = string[0]
    var result = StringBuilder()
    for (i in 1..string.length - 1) {
        if (length == 9 || prev != string[i]) {
            result.append("" + length)
            result.append(prev)
            length = 1
            prev = string[i]
        } else {
            length++
        }
    }

    if (length > 0) {
        result.append("" + length)
        result.append(prev)
    }
    

    return result.toString()
}
