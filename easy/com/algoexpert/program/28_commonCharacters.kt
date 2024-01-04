package com.algoexpert.program

/*
    найти общие символы и массивах
*/

// O(n * m) time | O(m) space
fun commonCharacters(strings: MutableList<String>): List<String> {
    // Write your code here.
    val visited = mutableMapOf<Char, Int>()
    var result = mutableListOf<String>()

    strings[0].forEach { c -> visited[c] = -1 }
    for (i in 0..strings.size - 1) {
        strings[i].forEach { c ->
            val times = visited[c] ?: Int.MIN_VALUE
            if (times + 1 == strings.size - 1) {
                result.add(c.toString())
                visited.remove(c)
            } else if (times + 1 == i) {
                visited[c] = i
            }
        }
    }

    return result
}

fun commonCharacters2(strings: MutableList<String>): List<String> {
    // Write your code here.
    val visited = mutableMapOf<Char, Int>()
    var result = mutableListOf<String>()

    for (i in 0..strings.size - 1) {
        strings[i].forEach { c ->
            var lastOcur = visited[c] ?: -1
            if (lastOcur == -1 && i == 0 || lastOcur + 1 == i) {
                visited[c] = i
                lastOcur = i
            }
            
            if (lastOcur == strings.size - 1) {
                result.add(c.toString())
                visited.remove(c)
            }
        }
    }

    return result
}
