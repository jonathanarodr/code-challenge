package br.com.jonathanarodr.challenges.leetcode

import br.com.jonathanarodr.util.AssertEquals.equalsTo

/**
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n
 * return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 */

private fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    val isEmptyPlot = 0
    var counter = 0

    for (index in flowerbed.indices) {
        if (flowerbed[index] == isEmptyPlot) {
            val isEmptyLeftPlot = flowerbed.getOrElse(index = index - 1, defaultValue = { isEmptyPlot }) == isEmptyPlot
            val isEmptyRightPlot = flowerbed.getOrElse(index = index + 1, defaultValue = { isEmptyPlot }) == isEmptyPlot

            if (isEmptyLeftPlot && isEmptyRightPlot) {
                flowerbed[index] = 1
                counter++
            }
        }
    }

    return counter >= n
}

fun main() {
    val flowerbed = intArrayOf(1, 0, 0, 0, 0, 1)
    val plantIndex = 2
    val expected = false

    val result = canPlaceFlowers(flowerbed = flowerbed, n = plantIndex)

    result equalsTo expected
}
