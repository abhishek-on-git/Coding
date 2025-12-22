package org.example.Array.Easy

/**
 * Leetcode 3427 - Sum of Variable length sub-arrays
 * You are given an integer array nums of size n.
 * For each index i where 0 <= i < n, define a subarray nums[start ... i] where start = max(0, i - nums[i]).
 * Return the total sum of all elements from the subarray defined for each index in the array.
 */
class SumVariableLenSunArray {

    // Elegant one pass solution.
    // Keep building a sums array with size 1 larger than nums.
    // This helps partial array sum calculation simpler.
    class Solution {
        fun subarraySum(nums: IntArray): Int {
            var sum = 0
            val sums = IntArray(nums.size + 1)
            for(i in 1 until sums.size) {
                sums[i] = nums[i-1] + sums[i-1]
                val start = maxOf(0, (i-1) - nums[i-1])
                sum += (sums[i] - sums[start])
            }
            return sum
        }
    }
}