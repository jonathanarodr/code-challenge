package challenges.leetcode

import br.com.jonathan.util.AssertEquals.equalsTo

/**
 * Given an array of characters chars, compress it using the following algorithm:
 *
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
 *
 * Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 */
private fun compress(chars: CharArray): Int {
    val compressedChars = StringBuilder()
    var currentChar: Char? = null
    var counter = 0

    chars.forEachIndexed { index, char ->
        if (currentChar != char) {
            // update memory values
            currentChar = char
            counter = 1

            // update compressed chars
            compressedChars.append(currentChar)
        } else {
            counter++
        }

        // check next char and append only if chars is different and count is more than one
        val nextChar = chars.getOrNull(index + 1)

        if (currentChar != nextChar && counter > 1) {
            compressedChars.append(counter)
        }
    }

    // update chars argument in memory
    for (index in 0..compressedChars.lastIndex) {
        chars[index] = compressedChars[index]
    }

    return compressedChars.length
}

fun main() {
    val chars = charArrayOf('a', 'a', 'a', 'b', 'b', 'a', 'a')
    val expectedChars = charArrayOf('a', '3', 'b', '2', 'a', '2', 'a')
    val expected = 6

    val result = compress(chars = chars)

    result equalsTo expected
    chars.joinToString() equalsTo expectedChars.joinToString()
}
