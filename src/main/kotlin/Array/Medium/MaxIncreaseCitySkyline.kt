package org.example.Array.Medium

/**
 * Leetcode 807 - Max increase to keep city skyline
 *
 * There is a city composed of n x n blocks, where each block contains a single building shaped
 * like a vertical square prism. You are given a 0-indexed n x n integer matrix grid where
 * grid[r][c] represents the height of the building located in the block at row r and column c.
 *
 * A city's skyline is the outer contour formed by all the building when viewing the side of the city from a distance.
 * The skyline from each cardinal direction north, east, south, and west may be different.
 *
 * We are allowed to increase the height of any number of buildings by any amount
 * (the amount can be different per building). The height of a 0-height building can also be increased.
 * However, increasing the height of a building should not affect the city's skyline from any cardinal direction.
 *
 * Return the maximum total sum that the height of the buildings can be increased by without changing the city's skyline from any cardinal direction.
 */
class MaxIncreaseCitySkyline {
    // 4 directions is just to confuse, just horizontal and vertical will work.
    class Solution {
        fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
            val n = grid.size
            var sum = 0

            val vertical = IntArray(n)
            val horizontal = IntArray(n)

            for(row in grid.indices) {
                for(col in grid[row].indices) {
                    horizontal[col] = maxOf(horizontal[col], grid[row][col])
                    vertical[row] = maxOf(vertical[row], grid[row][col])
                }
            }

            for(row in grid.indices) {
                for(col in grid[row].indices) {
                    sum += (minOf(horizontal[col], vertical[row]) - grid[row][col])
                }
            }

            return sum
        }
    }
}