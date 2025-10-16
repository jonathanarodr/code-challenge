package br.com.jonathanarodr.challenges.leetcode
// https://leetcode.com/problems/two-sum
private object Solution {

// two pointers BigO n -- 1
//    Input: nums = [2,7,11,15], target = 9
//    Output: [0,1]
//    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = mapOf<Int, Int>()

        for (i in 0..nums.lastIndex) {
            if (result.contains(nums[i])) {

            }
        }

        return intArrayOf()
    }
}

fun main() {
    val target = 9
    val nums = intArrayOf(2,7,11,15)

    val result = Solution.twoSum(nums, target)

//    assert(result, intArrayOf(2,7))

    println("Resultado é -> ${result.joinToString()}")
}