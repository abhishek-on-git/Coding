package org.example.Array.Easy

class ContainsDuplicate {
    /**
     * Leetcode 217 - https://leetcode.com/problems/contains-duplicate/description
     * Given an integer array nums, return true if any value appears at least twice in the array,
     * and return false if every element is distinct.
     */
    class Solution {
        fun containsDuplicate(nums: IntArray): Boolean {
            val set = mutableSetOf<Int>()
            for(num in nums) {
                if(set.contains(num)) return true
                set.add(num)
            }
            return false
        }
    }
}