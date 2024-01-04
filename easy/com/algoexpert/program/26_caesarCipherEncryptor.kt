package com.algoexpert.program

/*
    прокрутить каждую букву вперед по алфавиту key раз
    a- 97
    z -122
*/

// O(n) time | O(n) space
fun caesarCipherEncryptor(string: String, key: Int): String {
    val chars = string.toCharArray()
    val rolling = key % 26
    for (i in chars.indices) {
        chars[i] = chars[i] + rolling
        if (chars[i] > 'z') {
            chars[i] = chars[i] - 26
        }
    }

    return String(chars)
}
