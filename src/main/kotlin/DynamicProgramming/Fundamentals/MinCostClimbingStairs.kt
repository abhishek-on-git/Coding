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

    // Iterative Solution 1 O(N) time, O(N) space
    /**
     * Think of a dp array element as the minimum cost to reach that step.
     * We will need to create an array of size n+1, as dp[n] would be the
     * minimum cost to reach that step (even though dp[n] is not exactly a step).
     * Think of it as a virtual step
     */
    class IterativeSolution1 {
        fun minCostClimbingStairs(cost: IntArray): Int {
            val n = cost.size
            val dp = IntArray(n+1)
            dp[0] = 0
            dp[1] = 0

            for(i in 2 until n+1) {
                dp[i] = minOf(
                    dp[i-1] + cost[i-1],
                    dp[i-2] + cost[i-2]
                )
            }

            return dp[n]
        }
    }

    // Iterative Solution 2 O(N) time, O(1) space
    /**
     * We really need the last two step min costs, not the entire array.
     */
    class IterativeSolution2 {
        fun minCostClimbingStairs(cost: IntArray): Int {
            val n = cost.size
            var first = 0
            var second = 0

            for(i in 2 until n+1) {
                val min = minOf(first + cost[i-2],second + cost[i-1])
                first = second
                second = min
            }

            return second
        }
    }
}