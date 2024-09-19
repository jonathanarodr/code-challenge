package br.com.jonathan.challenges.leetcode

import br.com.jonathan.util.AssertEquals.equalsTo

/**
 * we say "str1 divides str2" if and only if "str2 = str1 + str1 + str1 + ... + str1 + str1"
 * i.e., t is concatenated with itself one or more times
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 */
private fun gcdOfStrings(str1: String, str2: String): String {
    if ((str1 + str2) != (str2 + str1)) {
        return ""
    }

    return if (str1 == str2) {
        str1
    } else if (str1.length < str2.length) {
        gcdOfStrings(str1 = str2, str2 = str1)
    } else if (str1.startsWith(str2)) {
        gcdOfStrings(str1 = str1.substring(str2.length), str2 = str2)
    } else {
        ""
    }
}

fun main() {
    val str1 = "ABABABAB"
    val str2 = "ABAB"
    val expected = "ABAB"

    val result = gcdOfStrings(str1 = str1, str2 = str2)

    result equalsTo expected
}
