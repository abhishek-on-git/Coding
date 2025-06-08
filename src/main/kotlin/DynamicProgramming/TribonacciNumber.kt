package org.example.DynamicProgramming

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
}