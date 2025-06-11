package org.example.DynamicProgramming.Fundamentals

class FibonacciNumber {
    // BruteForce:
    class SolutionBruteForce {
        fun fib(n: Int): Int {
            if(n == 0 || n == 1) return n
            return fib(n-1) + fib(n-2)
        }
    }

    // Memoization:
    class SolutionMemoization {
        fun fib(n: Int): Int {
            return fibonacci(n, IntArray(n + 1) {-1})
        }

        private fun fibonacci(n: Int, memo: IntArray) : Int {
            if(n == 0 || n == 1) return n
            if(memo[n] != -1) { return memo[n] }
            memo[n] = fibonacci(n-1, memo) + fibonacci(n-2, memo)
            return memo[n]
        }
    }

    // Iterative Solution 1:
    class IterativeSolution1 {
        fun fib(n: Int): Int {
            if(n == 0 || n == 1) return n
            val dp = IntArray(n + 1)
            dp[0] = 0
            dp[1] = 1
            for(i in 2..n) {
                dp[i] = dp[i-1] + dp[i-2]
            }
            return dp[n]
        }
    }

    // Iterative Solution 2 (No need for an entire array, only last two elements are needed):
    class IterativeSolution2 {
        fun fib(n: Int): Int {
            if(n == 0 || n == 1) return n
            var a = 0
            var b = 1
            var temp = 0
            for(i in 2..n) {
                temp = a + b
                a = b
                b = temp
            }
            return b
        }
    }

}