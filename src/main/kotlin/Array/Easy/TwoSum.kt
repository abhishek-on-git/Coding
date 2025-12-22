package org.example.Array.Easy

/**
 * Leetcode 1 - https://leetcode.com/problems/two-sum/description
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
class TwoSum {
    class Solution {
        fun twoSum(nums: IntArray, target: Int): IntArray {
            val ans = IntArray(2)
            val map = mutableMapOf<Int, Int>()

            for(i in nums.indices) {
                val num = nums[i]
                if(map.containsKey(num)) {
                    ans[0] = i
                    ans[1] = map.getValue(num)
                    break
                }
                map[target - num] = i
            }

            return ans
        }
    }
}