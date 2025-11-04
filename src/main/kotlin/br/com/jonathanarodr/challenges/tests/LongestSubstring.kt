package br.com.jonathanarodr.challenges.tests

private fun longestSubstring(input: String): Int {
    val lastIndex = mutableMapOf<Char, Int>()
    var left = 0
    var longestChar = 0

    for (right in input.indices) {
        val char = input[right]

        if (lastIndex.containsKey(char) && lastIndex[char]!! >= left) {
            left = lastIndex[char]!! + 1
        }

        lastIndex[char] = right
        longestChar = maxOf(longestChar, right - left + 1)
    }

    return longestChar
}

fun main() {
    //letters, digits, symbols and spaces
    val input = "abcabcbb"
    val longestSize = longestSubstring(input)

    println("Result is $longestSize")
}
