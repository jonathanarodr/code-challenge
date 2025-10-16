package br.com.jonathanarodr.challenges.leetcode

import br.com.jonathanarodr.util.AssertEquals.equalsTo

/**
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 */
private fun reverseWords(s: String): String {
    val words = s.trim()
        .split(" ")

    return buildString {
        for (index in words.lastIndex downTo 0) {
            val word = words[index]

            if (word.isEmpty()) {
                continue
            }

            if (index < words.lastIndex) {
                append(" ")
            }

            append(word)
        }
    }
}

fun main() {
    val s = "   the sky     is blue "
    val expected = "blue is sky the"

    val result = reverseWords(s = s)

    result equalsTo expected
}
