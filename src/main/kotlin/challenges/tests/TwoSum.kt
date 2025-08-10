package challenge

object Solution {

//    Input: nums = [2,7,11,15], target = 9
//    Output: [0,1]
//    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2)

        return result
    }
}

private fun assert(expected: IntArray, result: IntArray): IntArray? {
    return try {
        if (expected.contentEquals(result)) {
            result
        } else {
            error("Result ${result.joinToString()} is not equals of ${expected.joinToString()}")
        }
    } catch (ex: Exception) {
        println(ex)
        null
    }
}

fun main() {
    val target = 9
    val nums = intArrayOf(2,7,11,15)

    val result = Solution.twoSum(nums, target)

    assert(result, intArrayOf(2,7))

    println("Resultado é -> ${result.joinToString()}")
}