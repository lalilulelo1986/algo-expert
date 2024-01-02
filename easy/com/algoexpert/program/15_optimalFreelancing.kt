package com.algoexpert.program

import java.util.PriorityQueue

/*
    max profit for 7 days.
    input: {
        "jobs": [
            {
            "deadline": 1,
            "payment": 1
            },
            {
            "deadline": 2,
            "payment": 1
            }
        ]

    any job takes 1 day to complit. and any should be started from monday
}
*/

fun optimalFreelancing(jobs: MutableList<Map<String, Int>>): Int {
    // Write your code here.
    val heap =
            PriorityQueue<Pair<Int, Int>> { p1, p2 ->
                if (p2.first != p1.first) p1.first - p2.first else p2.second - p1.second
                if (p2.second != p1.second) p2.second - p1.second else p1.first - p2.first
            }

    jobs.forEach { heap.add(it["deadline"]!! to it["payment"]!!) }

    var day = 0
    var profit = 0
    while (day < 7 || heap.isNotEmpty()) {
        val job = heap.poll()
        if (job.first > day) {
            day++
            profit += job.second
        }
    }

    return profit
}
