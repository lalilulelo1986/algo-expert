package com.algoexpert.program

/*
    дан массив(не сортированныый) с пропещенными цифрами(что не дает ему быть от 1 до n без пропусков)
    найди пропущенные цифры
    длина целевого массива должны быть + 2 от начальногою

    if array = [1, 4, 3, 5]
    result = [2, 6]
*/

// O(n) time | O(1) space
fun missingNumbers(nums: MutableList<Int>): List<Int> {
    // Write your code here.
    var totalSum = 0
    for (i in 1..nums.size + 2) totalSum += i
    var factSum = 0
    for (i in nums.indices) factSum += nums[i]

    val missingSum = totalSum - factSum
    val missingAvg = missingSum / 2

    var leftTotal = 0
    for (i in 1..missingAvg) leftTotal += i
    var rightTotal = 0
    for (i in missingAvg + 1..nums.size + 2) rightTotal += i

    var leftSum = 0
    for (i in nums.indices) {
        if (nums[i] <= missingAvg) leftSum += nums[i]
    }

    var rightSum = 0
    for (i in nums.indices) {
        if (nums[i] > missingAvg) rightSum += nums[i]
    }

    return listOf(leftTotal - leftSum, rightTotal - rightSum)
}
