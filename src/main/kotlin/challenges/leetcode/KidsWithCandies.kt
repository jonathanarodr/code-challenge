package br.com.jonathan.challenges.leetcode

import br.com.jonathan.util.AssertEquals.equalsTo

/**
 * Return a boolean array result of length n, where result[i] is 'true' if after giving the i"th kid all the extraCandies
 * they will have the greatest number of candies among all the kids, or false otherwise.
 */
private fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
    val greatestCandy = candies.maxOrNull() ?: 0

    return candies.map { (it + extraCandies) >= greatestCandy }
}

fun main() {
    val candies = intArrayOf(2, 3, 5, 1, 3)
    val extraCandies = 3
    val expected = listOf(true, true, true, false, true)

    val result = kidsWithCandies(candies = candies, extraCandies = extraCandies)

    result equalsTo expected
}
