package org.example.Array.Easy

class ContainsDuplicate_II {

    /**
     * Leetcoce 219 - https://leetcode.com/problems/contains-duplicate-ii/description
     * Given an integer array nums and an integer k, return true if there are
     * two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
     */
    class Solution {
        fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
            val map = mutableMapOf<Int, Int>()
            for(i in nums.indices) {
                if(map.containsKey(nums[i]) && Math.abs(map.getValue(nums[i]) - i) <= k) {
                    return true
                }
                map[nums[i]] = i
            }
            return false
        }
    }
}