package org.example.Array.Easy

/**
 * Leetcode 3696 - Maximum distance between unequal words I
 * You are given a string array words.
 * Find the maximum distance between two distinct indices i and j such that:
 * words[i] != words[j], and
 * the distance is defined as j - i + 1.
 * Return the maximum distance among all such pairs. If no valid pair exists, return 0.
 */
class MaxDistanceUnequalWords {

    // Single pass solution.
    // Traverse through the array and compare each word to the first and last words.
    // If unequal, update max if this word's distance from first and last is higher than current max.
    class Solution {
        fun maxDistance(words: Array<String>): Int {
            var max = 0

            for(i in words.indices) {
                if(words[0] != words[i]) {
                    max = maxOf(max, i + 1)
                }

                if(words[i] != words[words.size-1]) {
                    max = maxOf(max, words.size - i)
                }
            }

            return max
        }
    }
}