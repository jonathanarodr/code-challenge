package br.com.jonathanarodr.challenges.leetcode

import br.com.jonathanarodr.util.AssertEquals.equalsTo

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements
 * of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
private fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val answer = IntArray(n)

    var prefix = 1
    for (i in 0 until n) {
        answer[i] = prefix
        prefix *= nums[i]
    }

    var suffix = 1
    for (i in n - 1 downTo 0) {
        answer[i] *= suffix
        suffix *= nums[i]
    }

    return answer
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 4)
    val expected = intArrayOf(24, 12, 8, 6)

    val result = productExceptSelf(nums = nums)

    result.joinToString() equalsTo expected.joinToString()
}
