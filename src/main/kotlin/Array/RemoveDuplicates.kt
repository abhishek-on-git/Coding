package org.example.Array

class RemoveDuplicates {

    /**
     * Leetcode 26 - https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
     * Given an integer array nums sorted in non-decreasing order,
     * remove the duplicates in-place such that each unique element appears only once.
     * The relative order of the elements should be kept the same.
     * After removing duplicates, return the number of unique elements k.
     * The first k elements of nums should contain the unique numbers in sorted order.
     * The remaining elements beyond index k - 1 can be ignored.
     */
    class Solution {
        fun removeDuplicates(nums: IntArray): Int {
            var insert = 1
            for(i in 1 until nums.size) {
                if(nums[i] > nums[i-1]) {
                    nums[insert++] = nums[i]
                }
            }
            return insert
        }
    }
}