package org.example.Array

/**
 * Leetcode 3450
 * You are given a 2D integer array of student data students, where students[i] = [student_id, bench_id]
 * represents that student student_id is sitting on the bench bench_id.
 * Return the maximum number of unique students sitting on any single bench.
 * If no students are present, return 0.
 * Note: A student can appear multiple times on the same bench in the input,
 * but they should be counted only once per bench.
 */
class MaximumStudentsOnBench {

    /**
     * O(N) but with two traversals.
     */
    class Solution1 {
        fun maxStudentsOnBench(students: Array<IntArray>): Int {
            val map = mutableMapOf<Int, MutableSet<Int>>()
            for(pair in students) {
                if(map[pair[1]] == null) {
                    map[pair[1]] = mutableSetOf<Int>()
                }
                map[pair[1]]?.add(pair[0])
            }

            var max = 0

            for(set in map.values) {
                max = maxOf(max, set.size)
            }

            return max
        }
    }

    /**
     * O(N) but with one traversal
     */
    class Solution2 {
        fun maxStudentsOnBench(students: Array<IntArray>): Int {
            var max = 0
            val map = mutableMapOf<Int, MutableSet<Int>>()
            for(pair in students) {
                var set = map.getOrPut(pair[1]) { mutableSetOf() }
                set.add(pair[0])
                max = maxOf(max, set.size)
            }
            return max
        }
    }
}