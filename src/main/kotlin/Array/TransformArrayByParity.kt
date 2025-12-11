package org.example.Array

/**
 * Leetcode 3467
 * You are given an integer array nums. Transform nums by performing the following operations in the exact order specified:
 * Replace each even number with 0.
 * Replace each odd numbers with 1.
 * Sort the modified array in non-decreasing order.
 * Return the resulting array after performing these operations.
 */
class TransformArrayByParity {
    class Solution {
        fun transformArray(nums: IntArray): IntArray {
            var zeros = 0

            for(num in nums) {
                if(num % 2 == 0) {
                    zeros++
                }
            }

            for(i in nums.indices) {
                nums[i] = if(zeros-- > 0) 0 else 1
            }

            return nums
        }
    }
}