package com.algoexpert.program

// O(n) time | O(1) space (because size of map will be maximum 26, for each char)
fun firstNonRepeatingCharacter(string: String): Int {
    // Write your code here.
    val visits = mutableMapOf<Char, Int>()

    for (i in string.indices) {
        if (visits.containsKey(string[i]).not()) {
            visits[string[i]] = i
        } else {
            visits[string[i]] = -1
        }
    }

    var min = -1
    visits.forEach { k, v ->
        if (v >= 0) {
            if (min == -1) min = v
            else {
                min = Math.min(min, v)
            }
        }
    }

    return min
}
