package challenges.leetcode

import br.com.jonathan.util.AssertEquals.equalsTo

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k)
 * such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 */
private fun increasingTriplet(nums: IntArray): Boolean {
    if (nums.size < 3) {
        return false
    }

    var first = Int.MAX_VALUE
    var second = Int.MAX_VALUE

    nums.forEach {
        if (it <= first) {
            first = it
        } else if (it <= second) {
            second = it
        } else {
            return true
        }
    }

    return false
}

fun main() {
    val nums = intArrayOf(20, 100, 10, 12, 5, 13)
    val expected = true

    val result = increasingTriplet(nums = nums)

    result equalsTo expected
}
