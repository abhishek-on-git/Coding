package org.example.DynamicProgramming.Fundamentals

class TribonacciNumber {
    //Brute Force Solution:
    class BruteForceSolution {
        fun tribonacci(n: Int): Int {
            if(n < 2) return n
            if(n == 2) return 1
            return tribonacci(n-3) + tribonacci(n-2) + tribonacci(n-1)
        }
    }

    // Memoization:
    class MemoizationSolution {
        fun tribonacci(n: Int): Int {
            val memo = IntArray(n + 1) {-1}
            return tribonacciHelper(n, memo)
        }

        fun tribonacciHelper(n: Int, memo: IntArray) : Int {
            if(n < 2) return n
            if(n == 2) return 1

            if(memo[n] != -1) return memo[n]

            memo[n] = tribonacciHelper(n-1, memo) +
                    tribonacciHelper(n-2, memo) +
                    tribonacciHelper(n-3, memo)

            return memo[n]
        }
    }

    // Iterative Solution 1:
    class IterativeSolution {
        fun tribonacci(n: Int): Int {
            if(n < 2) return n
            if(n == 2) return 1

            val dp = IntArray(n + 1)
            dp[0] = 0
            dp[1] = 1
            dp[2] = 1

            for(i in 3..n) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
            }

            return dp[n]
        }
    }

    // Iterative Solution 2: (No need for an entire array, only last three elements are needed):
    class IterativeSolution2 {
        fun tribonacci(n: Int): Int {
            if(n < 2) return n
            if(n == 2) return 1

            var a = 0
            var b = 1
            var c = 1
            var temp = 0

            for(i in 3..n) {
                temp = a + b + c
                a = b
                b = c
                c = temp
            }

            return c
        }
    }
}