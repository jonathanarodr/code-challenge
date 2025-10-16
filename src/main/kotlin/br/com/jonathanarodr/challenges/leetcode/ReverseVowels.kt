package br.com.jonathanarodr.challenges.leetcode

import br.com.jonathanarodr.util.AssertEquals.equalsTo

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u'
 * and they can appear in both lower and upper cases, more than once.
 */
private fun reverseVowels(s: String): String {
    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    val stackVowels = mutableListOf<Char>()
    val reverseVowels = s.toCharArray()

    for (index in reverseVowels.indices) {
        val char = reverseVowels[index]

        if (vowels.contains(char)) {
            stackVowels.add(char)
        }
    }

    for (index in reverseVowels.indices) {
        val char = reverseVowels[index]

        if (vowels.contains(char)) {
            reverseVowels[index] = stackVowels.removeLast()
        }
    }

    return String(reverseVowels)
}

fun main() {
    val s = "leetcode"
    val expected = "leotcede"

    val result = reverseVowels(s = s)

    result equalsTo expected
}
