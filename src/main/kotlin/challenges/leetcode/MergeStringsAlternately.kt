package br.com.jonathan.challenges.leetcode

import br.com.jonathan.util.AssertEquals.equalsTo

/**
 * string is longer than other, append additional letters onto end merged string
 * 1. 'abc' - 'pqr' = 'apbqcr'
 * 2. 'ab' - 'pqrs' = 'apbqrs'
 *
 * constraints:
 * word1 <= 1 / word2 <= 100
 */
private fun mergeAlternately(word1: String, word2: String): String {
    return buildString {
        repeat(maxOf(word1.length, word2.length)) { index ->
            if (index < word1.length) {
                append(word1[index])
            }

            if (index < word2.length) {
                append(word2[index])
            }
        }
    }
}

fun main() {
    val word1 = "abcd"
    val word2 = "pq"
    val expected = "apbqcd"

    val result = mergeAlternately(word1 = word1, word2 = word2)

    result equalsTo expected
}
