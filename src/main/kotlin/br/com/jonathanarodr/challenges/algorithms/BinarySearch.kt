package br.com.jonathanarodr.challenges.algorithms

import br.com.jonathanarodr.util.AssertEquals.equalsTo

/**
 *                 ↓
 * elements: 1, 3, 5, 7, 9, 11, 15, 18
 *
 */
private fun binarySearch(elements: Array<Int>, target: Int): Int {
    var left = 0
    var right = elements.lastIndex

    while (left <= right) {
        val mid = (left + right) / 2

        when {
            elements[mid] == target -> return target
            elements[mid] > target -> right = mid - 1
            else -> left = mid + 1
        }
    }

    return -1
}

fun main() {
    val elements = arrayOf(1, 3, 5, 7, 9, 11, 15, 18)
    val expected = 5
    val result = binarySearch(elements, expected)

    result equalsTo expected
}
