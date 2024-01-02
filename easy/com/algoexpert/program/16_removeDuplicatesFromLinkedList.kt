package com.algoexpert.program

// This is an input class. Do not edit.
open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun removeDuplicatesFromLinkedList(linkedList: LinkedList): LinkedList {
    // Write your code here.
    var cur: LinkedList? = linkedList
    var tmp: LinkedList? = null
    while(cur?.next != null) {
        if (cur.value == cur.next?.value) {
            tmp = cur.next
            cur.next = tmp?.next
            tmp?.next = null
        } else {
            cur = cur.next
        }
    }
    
    return linkedList
}
