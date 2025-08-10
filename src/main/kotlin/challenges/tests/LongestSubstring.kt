package challenge

private fun longestSubstringLow(input: String): Int {
    val longestChar = hashSetOf<Char>()
    var longestSize = 0

    for (i in input.indices) {
        for (j in i..input.lastIndex) {
            if (longestChar.contains(input[j])) {
                break
            } else {
                longestChar.add(input[j])
            }
        }

        if (longestChar.size > longestSize) {
            longestSize = longestChar.size
        }

        longestChar.clear()
    }

    return longestSize
}

private fun longestSubstring(input: String): Int {
    val data = mutableMapOf<Char, Int>()
    var longestSize = 0
    var startIndex = 0

    input.forEachIndexed { index, char ->
        val indexChar = data[char]

        if (indexChar != null && indexChar >= startIndex) {
            val possibleLongestSize = index - startIndex

            if (possibleLongestSize > longestSize) {
                longestSize = possibleLongestSize
            }

            startIndex = indexChar + 1
        }

        data[char] = index
    }

    val possibleLongestSize = input.length - startIndex
    if (possibleLongestSize > longestSize) {
        longestSize = possibleLongestSize
    }

    return longestSize
}

fun main() {

    //letters, digits, symbols and spaces
    val input = "abcabcbb"
    val longestSize = longestSubstring(input)

    println("Result is $longestSize")
}