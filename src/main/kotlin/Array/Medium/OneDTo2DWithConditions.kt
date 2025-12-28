package org.example.Array.Medium

/**
 * IMPORTANT, REVISIT.
 *
 * Leetcode 2610 - Convert an Array into a 2D Array with conditions.
 *
 * You are given an integer array nums.
 * You need to create a 2D array from nums satisfying the following conditions:
 * The 2D array should contain only the elements of the array nums.
 * Each row in the 2D array contains distinct integers.
 * The number of rows in the 2D array should be minimal.
 * Return the resulting array. If there are multiple answers, return any of them.
 * Note that the 2D array can have a different number of elements on each row.
 */
class OneDTo2DWithConditions {
    /**
     * O(N²) Brute force is straight forward.
     * Below is the O(N) solution.
     */
    class Solution {
        fun findMatrix(nums: IntArray): List<List<Int>> {
            val ans = mutableListOf<MutableList<Int>>()
            val freq = mutableMapOf<Int, Int>()
            for(num in nums) {
                val count = freq.getOrDefault(num, 0)
                if(count == ans.size) {
                    ans.add(mutableListOf())
                }
                ans[count].add(num)
                freq[num] = count + 1
            }
            return ans
        }
    }
}