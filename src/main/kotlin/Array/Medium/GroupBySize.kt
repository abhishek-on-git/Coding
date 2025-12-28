package org.example.Array.Medium

/**
 * Leetcode 1282 - Group the people given the group size they belong to.
 *
 * There are n people that are split into some unknown number of groups.
 * Each person is labeled with a unique ID from 0 to n - 1.
 * You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in.
 * For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.
 * Return a list of groups such that each person i is in a group of size groupSizes[i].
 * Each person should appear in exactly one group, and every person must be in a group.
 * If there are multiple answers, return any of them.
 * It is guaranteed that there will be at least one valid solution for the given input.
 */
class GroupBySize {

    /**
     * Use a map with keys as group sizes and values as the list with people ids.
     * As soon as a group crosses the groupSize, add this list to ans and remove this groupSize from the map.
     * Removing is important as there can be multiple groups of same size,
     * like in this example test case:
     * Input: groupSizes = [3,3,3,3,3,1,3]
     * Output: [[5],[0,1,2],[3,4,6]]
     */
    class Solution {
        fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
            val map = mutableMapOf<Int, MutableList<Int>>()
            val ans = mutableListOf<List<Int>>()

            for(i in groupSizes.indices) {
                val group = map.getOrPut(groupSizes[i]){ mutableListOf() }
                group.add(i)
                if(group.size >= groupSizes[i]) {
                    ans.add(group)
                    map.remove(groupSizes[i])
                }
            }

            return ans
        }
    }
}