package com.algoexpert.program

/*
    разбить на пары, если в паре одинаковое слово(но одно в обратном направлении)
*/
// O(n * m) time | O(n * m) space
// where m is max length of string
fun semordnilap(words: List<String>): List<List<String>> {
    // Write your code here.
    var pairs = mutableListOf<List<String>>()
    var visited = mutableSetOf<String>()
    for (i in words.indices) {
        val reversed = words[i].reversed()
        if (visited.contains(reversed)) {
            pairs.add(listOf(words[i], reversed))
        } else {
            visited.add(words[i])
        }
    }

    return pairs
}
