package com.algoexpert.program

/*
{
  "array": [5, 2, [7, -1], 3, [6, [-13, 8], 4]]
} 
  result = 12
  складываем все, если вложенный, то умножаем на клубину вложености
*/

// O(n) time | O(d) space
fun productSum(array: List<*>, level: Int = 1): Int {
    var sum = 0
    for (i in array.indices) {
        if (array[i] is Int) {
            sum += array[i] as Int
        } else {
            sum += productSum(array[i] as List<*>, level + 1)
        }
    }

    return level * sum
}