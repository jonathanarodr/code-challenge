package challenge

/**
 * Find first duplicated number and return both indexes
 *               *         *
 * Example: 9,21,3,4,5,6,7,3,2,3,1,4 - 6
 *
 * Input never is empty
 * Input contains only positive numbers
 * If not found, returns -1
 */
object SumDuplicatedNumber {

    // O(n²)
    fun bruteForce(input: IntArray): Int {
        for (i in 0..input.lastIndex) {
            for (j in i+1..input.lastIndex) {
                if (input[i] == input[j]) {
                    return input[i] + input[j]
                }
            }
        }

        return -1
    }

    // O(log n)
    fun findDuplicatedNumberAndSum(input: IntArray): Int {
        val numbers = mutableSetOf<Int>()

        input.forEach { number -> //1..n
            if (numbers.contains(number)) { //1
                return number * 2 //1
            } else {
                numbers.add(number) //1
            }
        }

        return -1
    }
}

private fun assert(expected: Int, result: Int) {
    if (expected != result) {
        error("Expected value $expected, but found $result")
    } else {
        println("Result is $expected")
    }
}

fun main() {
    val expected = 8
    val input = intArrayOf(1,21,3,4,5,6,4,7,3,2,3,1,4)

    val result = SumDuplicatedNumber.findDuplicatedNumberAndSum(input)

    assert(expected, result)
}