package org.example.Array

class MajorityElement {

    /**
     * Leetcode 169
     * Given an array nums of size n, return the majority element.
     * The majority element is the element that appears more than ⌊n / 2⌋ times.
     * You may assume that the majority element always exists in the array.
     */
    class Solution {
        // Hashmap solution is straight forward.
        // This is Bayer-Moore's voting algorithm.
        // Essence - If non candidates balance out the candidate, reset the counter.
        fun majorityElement(nums: IntArray): Int {
            var count = 1
            var candidate = nums[0]

            for(i in 1 until nums.size) {
                count = if(candidate == nums[i]) count + 1 else count - 1
                if(count == 0) {
                    candidate = nums[i]
                    count = 1
                }
            }

            return candidate
        }
    }
}