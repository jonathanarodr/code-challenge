package br.com.jonathanarodr.challenges.leetcode

import br.com.jonathanarodr.util.AssertEquals.equalsTo

/**
 * Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both
 * arrays. If there is no common integer amongst nums1 and nums2, return -1.
 *
 * Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that
 * integer.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3], nums2 = [2,4]
 * Output: 2
 * Explanation: The smallest element common to both arrays is 2, so we return 2.
 * Example 2:
 *
 * Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
 * Output: 2
 * Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 105
 * 1 <= nums1[i], nums2[j] <= 109
 * Both nums1 and nums2 are sorted in non-decreasing order.
 */
fun getCommonBruteForce(nums1: IntArray, nums2: IntArray): Int {
    for (i in 0..nums1.lastIndex) {
        for (j in 0..nums2.lastIndex) {
            if (nums1[i] == nums2[j]) {
                return nums1[i]
            }
        }
    }

    return -1
}

fun getCommon(nums1: IntArray, nums2: IntArray): Int {
    var i = 0
    var j = 0
    val firstSize = nums1.size
    val secondSize = nums2.size

    while (i < firstSize && j < secondSize) {
        when {
            nums1[i] == nums2[j] -> return nums1[i]
            nums1[i] > nums2[j] -> j++
            else -> i++
        }
    }

    return -1
}

fun main() {
    val nums1 = intArrayOf(1, 2, 3)
    val nums2 = intArrayOf(2, 4)
    val exptected = 2

    val result = getCommon(nums2, nums1)

    result equalsTo exptected
}
