package org.example.DynamicProgramming.Fundamentals

/**
 * Leetcode 746 - https://leetcode.com/problems/min-cost-climbing-stairs/description/
 *
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 */
class MinCostClimbingStairs {

    // Brute Force Solution O(2ⁿ)
    class BruteForceSolution {
        fun minCostClimbingStairs(cost: IntArray): Int {
            return minOf(minCost(cost, 0), minCost(cost, 1))
        }

        private fun minCost(cost: IntArray, i: Int) : Int {
            if (i >= cost.size) return 0
            return cost[i] + minOf(minCost(cost, i + 1), minCost(cost, i + 2))
        }
    }

    // Memoization Solution O(N)
    class MemoizationSolution {
        fun minCostClimbingStairs(cost: IntArray): Int {
            val memo = IntArray(cost.size) {-1}
            return minOf(minCost(cost, 0, memo), minCost(cost, 1, memo))
        }

        private fun minCost(
            cost: IntArray,
            i: Int,
            memo: IntArray
        ) : Int {
            if(i == cost.size - 2 || i == cost.size - 1) return cost[i]
            if(memo[i] == -1) {
                memo[i] = cost[i] + minOf(
                    minCost(cost, i + 1, memo),
                    minCost(cost, i + 2, memo)
                )
            }

            return memo[i]
        }
    }
}