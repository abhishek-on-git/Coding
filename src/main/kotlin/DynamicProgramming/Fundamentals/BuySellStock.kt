package org.example.DynamicProgramming.Fundamentals

/**
 * Leetcode 121 - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * You are given an array prices where prices`[i`] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 */
class BuySellStock {

    //Brute Force Solution, O(N²)
    class BruteForceSolution {
        fun maxProfit(prices: IntArray): Int {
            var max = Int.MIN_VALUE
            for(i in 0 until prices.size - 1) {
                for(j in i+1 until prices.size) {
                    max = maxOf(max, prices[j] - prices[i])
                }
            }
            return if(max > 0) max else 0
        }
    }

    // Single Pass Solution, O(N)
    class SinglePassSolution {
        fun maxProfit(prices: IntArray): Int {
            var max = 0
            var profit: Int
            var buy = prices[0]
            for(i in 1 until prices.size) {
                profit = prices[i] - buy
                if(profit < 0) {
                    buy = prices[i]
                } else {
                    max = maxOf(max, profit)
                }
            }
            return max
        }
    }

}