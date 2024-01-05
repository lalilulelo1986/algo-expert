package com.algoexpert.program

/*
    find wheather exists one subarray which gives 0 in sum
    array without gaps(of course)
*/
// O(n^2) time | O(n) space
fun zeroSumSubarray_bad(nums: List<Int>): Boolean {
    // Write your code here.
    val sums = MutableList(nums.size) { 0 }
    for (i in nums.indices) {
        for (ii in 0..i) {
            sums[ii] = sums[ii] + nums[i]
            if (sums[ii] == 0) return true
        }
    }

    return false
}

fun zeroSumSubarray(nums: List<Int>): Boolean {
    // Write your code here.
    val sums = mutableSetOf<Int>(0)
    var rollingSum = 0
    for (i in nums.indices) {
        rollingSum += nums[i]
        if (sums.contains(rollingSum)) return true
        sums.add(rollingSum)
    }

    return false
}

fun main(args: Array<String>) {
    println("result: " + zeroSumSubarray(listOf(1, 2, -2, 3)))
}
