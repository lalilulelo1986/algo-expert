class BNode(value: Char, left: BNode? = null, right: BNode? = null) {
    var value = value
    var left = left
    var right = right
}

// we do recursion traverse
// recursion method returns Set<Char> of all bellow and current chars
//

fun main(args: Array<String>) {

    val root = BNode('A')

    root.left = BNode('B')
    root.left?.left = BNode('C')

    root.right = BNode('B')
    root.right?.right = BNode('C')

    val store = mutableMapOf<String, MutableList<BNode>>()
    helper(root, store)

    println(store)
}

fun helper(node: BNode, store: MutableMap<String, MutableList<BNode>>): List<Boolean> {
    val left = node.left?.let { helper(it, store) } ?: listOf()
    val right = node.right?.let { helper(it, store) } ?: listOf()

    val result = MutableList<Boolean>(26) { false }
    if (left.isEmpty() && right.isEmpty()) {
        result[charIndex(node.value)] = true
        return result
    }
    
    result[charIndex(node.value)] = true

    val str = StringBuilder()
    for (i in 0..25) {
        if (left.isNotEmpty() && left[i] == true) result[i] = true
        if (right.isNotEmpty() && right[i] == true) result[i] = true

        if (result[i]) str.append(charByIndex(i))
    }

    println("str: $str")
    if (store.containsKey(str.toString())) {
        store[str.toString()]?.add(node)
    } else {
        store[str.toString()] = mutableListOf(node)
    }

    return result
}

fun charIndex(char: Char): Int {
    return when (char) {
        'A' -> 0
        'B' -> 1
        'C' -> 2
        'D' -> 3
        'E' -> 4
        'F' -> 5
        'G' -> 6
        'H' -> 7
        'I' -> 8
        'J' -> 9
        'K' -> 10
        'L' -> 11
        'M' -> 12
        'N' -> 13
        'O' -> 14
        'P' -> 15
        'Q' -> 16
        'R' -> 17
        'S' -> 18
        'T' -> 19
        'U' -> 20
        'V' -> 21
        'W' -> 22
        'X' -> 23
        'Y' -> 24
        'Z' -> 25
        else -> -1
    }
}

fun charByIndex(index: Int): Char {
    return when (index) {
        0 -> 'A'
        1 -> 'B'
        2 -> 'C'
        3 -> 'D'
        4 -> 'E'
        5 -> 'F'
        6 -> 'G'
        7 -> 'H'
        8 -> 'I'
        9 -> 'J'
        10 -> 'K'
        11 -> 'L'
        12 -> 'M'
        13 -> 'N'
        14 -> 'O'
        15 -> 'P'
        16 -> 'Q'
        17 -> 'R'
        18 -> 'S'
        19 -> 'T'
        20 -> 'U'
        21 -> 'V'
        22 -> 'W'
        23 -> 'X'
        24 -> 'Y'
        25 -> 'Z'
        else -> ' '
    }
}
