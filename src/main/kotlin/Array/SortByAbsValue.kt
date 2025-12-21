package org.example.Array

import kotlin.math.abs

/**
 * Leetcode 3667 -
 * You are given an integer array nums.
 * Rearrange elements of nums in non-decreasing order of their absolute value.
 * Return any rearranged array that satisfies this condition.
 *
 * Important - sortWith vs sortedWith in Kotlin
 */
class SortByAbsValue {
    class Solution {
        fun sortByAbsoluteValue(nums: IntArray): IntArray {
            return nums.toTypedArray()
                .sortedWith(compareBy { abs(it) })
                .toIntArray()
        }
    }
}