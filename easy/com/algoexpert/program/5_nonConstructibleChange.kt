package com.algoexpert.program

// какую минимальную сдачу нельзя дать
/*{
  "coins": [1, 2, 5], result: 4
}*/

fun nonConstructibleChange(coins: MutableList<Int>): Int {
    // Write your code here.
    coins.sort()

    var maxChange = 0
    for (i in coins.indices) {
        if (coins[i] > maxChange + 1) {
            return maxChange + 1
        } else {
            maxChange += coins[i]
        }
    }
    return maxChange + 1
}
