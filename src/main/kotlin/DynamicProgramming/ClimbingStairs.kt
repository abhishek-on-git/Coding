package org.example.DynamicProgramming

class ClimbingStairs {
    // Brute Force Solution
    class BruteForceSolution {
        fun climbStairs(n: Int): Int {
            // F(N) = F(N-1) + F(N-2)
            if(n < 3) return n
            return climbStairs(n-1) + climbStairs(n-2)
        }
    }

    // Memoization Solution:
    class MemoizationSolution {
        fun climbStairs(n: Int): Int {
            // F(N) = F(N-1) + F(N-2)
            val memo = IntArray(n + 1) {-1}
            return climb(n, memo)
        }

        private fun climb(n: Int, memo: IntArray) : Int {
            if(n < 3) return n
            if(memo[n] != -1) return memo[n]
            memo[n] = climb(n-2, memo) + climb(n-1, memo)
            return memo[n]
        }
    }

    // Iterative Solution 1:
    class IterativeSolution {
        fun climbStairs(n: Int): Int {
            // F(N) = F(N-1) + F(N-2)
            if(n < 3) return n
            val dp = IntArray(n + 1)
            dp[1] = 1
            dp[2] = 2
            for(i in 3..n) {
                dp[i] = dp[i-1] + dp[i-2]
            }
            return dp[n]
        }
    }

    // Iterative Solution 2 (No need for an entire array, only last two elements are needed):
    class IterativeSolution2 {
        fun climbStairs(n: Int): Int {
            // F(N) = F(N-1) + F(N-2)
            if(n < 3) return n
            var a = 1
            var b = 2
            var temp = 0
            for(i in 3..n) {
                temp = a + b
                a = b
                b = temp
            }
            return b
        }
    }
}