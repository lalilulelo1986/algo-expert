package com.algoexpert.program

// This is an input class. Do not edit.
// open class LinkedList(value: Int) {
//     var value = value
//     var next: LinkedList? = null
// }

fun middleNode(linkedList: LinkedList): LinkedList {
    // Write your code here.
    var slow: LinkedList? = linkedList
    var fast: LinkedList? = linkedList
    var counter = 0
    while(fast?.next != null) {
        if (counter % 2 == 0) {
            fast = fast.next
            slow = slow?.next
        } else {
            fast = fast.next
        }
        counter++
    }
    
    return slow!!
}