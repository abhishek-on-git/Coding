package org.example.DynamicProgramming.Fundamentals

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