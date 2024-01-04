package com.algoexpert.program

// O(n + m) time | O(c) spase
// c - unique chars
fun generateDocument(characters: String, document: String): Boolean {
    // Write your code here.
    val index = mutableMapOf<Char, Int>()
    
    for (i in characters.indices) {
        index.putIfAbsent(characters[i], 0)
        index.computeIfPresent(characters[i]) { _, v -> v + 1 }
    }

    for (i in document.indices) {
        if (index.containsKey(document[i]).not() || index[document[i]] == 0) 
            return false
        index.computeIfPresent(characters[i]) { _, v -> v - 1 }
    }

    return true
}