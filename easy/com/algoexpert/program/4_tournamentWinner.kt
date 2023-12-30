package com.algoexpert.program

fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    // Write your code here.
    val map = HashMap<String, Int>(10)
    

    for (i in competitions.indices) {
        val winner = if (results[i] == 0) 1 else 0
        val old = map.computeIfPresent(competitions[i][winner]) { k, v -> v + 1 }
        if (old == null)
            map.putIfAbsent(competitions[i][winner], 1)
    }

    var maxScore = 0
    var winner: String = ""
    map.forEach { it -> 
        if (it.value > maxScore) {
            winner = it.key
            maxScore = it.value
        }
    }

    return winner
}


fun tournamentWinner2(competitions: List<List<String>>, results: List<Int>): String {
    // Write your code here.
    val map = HashMap<String, Int>(3)
    
    var maxScore = 0
    var bestTeam = ""
    for (i in competitions.indices) {
        val curWinner = competitions[i][if (results[i] == 0) 1 else 0]
        var curWinnerScore = map.computeIfPresent(curWinner) { k, v -> v + 1 }?.plus(1)
        if (curWinnerScore == null) {
            map.putIfAbsent(curWinner, 1)
            curWinnerScore = 1
        }
        if (curWinnerScore > maxScore) {
            bestTeam = curWinner
            maxScore = curWinnerScore
        }
    }

    return bestTeam
}
