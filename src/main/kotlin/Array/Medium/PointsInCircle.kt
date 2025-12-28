package org.example.Array.Medium

/**
 * Leetcode 1828 - Queries on number of points in a circle.
 * You are given an array points where points[i] = [xi, yi]
 * is the coordinates of the ith point on a 2D plane.
 * Multiple points can have the same coordinates.
 * You are also given an array queries where queries[j] = [xj, yj, rj]
 * describes a circle centered at (xj, yj) with a radius of rj.
 * For each query queries[j], compute the number of points inside the jth circle.
 * Points on the border of the circle are considered inside.
 * Return an array answer, where answer[j] is the answer to the jth query.
 */
class PointsInCircle {
    // This is Brute Force. Revisit for follow up (KD Spatial trees?)
    class Solution {
        fun countPoints(points: Array<IntArray>, queries: Array<IntArray>): IntArray {
            val ans = IntArray(queries.size)
            for(i in queries.indices) {
                for(point in points) {
                    val dx = point[0] - queries[i][0]
                    val dy = point[1] - queries[i][1]
                    val r = queries[i][2]
                    if(dx*dx + dy*dy <= r * r) {
                        ans[i]++
                    }
                }
            }
            return ans
        }
    }
}