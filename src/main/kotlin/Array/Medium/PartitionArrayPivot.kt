package org.example.Array.Medium

/**
 * Leetcode 2161 - Partition Array According to Given Pivot
 * You are given a 0-indexed integer array nums and an integer pivot.
 * Rearrange nums such that the following conditions are satisfied:
 *
 * Every element less than pivot appears before every element greater than pivot.
 * Every element equal to pivot appears in between the elements less than and greater than pivot.
 * The relative order of the elements less than pivot and the elements greater than pivot is maintained.
 *
 * Return nums after the rearrangement.
 */
class PartitionArrayPivot {
    class Solution {
        fun pivotArray(nums: IntArray, pivot: Int): IntArray {
            val ans = IntArray(nums.size)
            var pivots = 0
            var c = 0

            for(i in nums.indices) {
                if(nums[i] < pivot) {
                    ans[c++] = nums[i]
                }
                if(nums[i] == pivot) pivots++
            }

            repeat(pivots) {
                ans[c++] = pivot
            }

            for(i in nums.indices) {
                if(nums[i] > pivot) ans[c++] = nums[i]
            }

            return ans
        }
    }
}