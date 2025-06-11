package org.example.DynamicProgramming

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

}