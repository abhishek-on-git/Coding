package org.example.DynamicProgramming

class PascalsTriangle {

    // Pascal's Triangle 1 (LC 118)
    /**
     * Why is this a DP problem?  Because we construct current row based on previous row,
     * which is an already solved problem.
     */
    class Pascal1Solution {
        fun generate(numRows: Int): List<List<Int>> {
            val ans = mutableListOf<List<Int>>()
            var prev = listOf(1)
            ans.add(prev)
            for(i in 1 until numRows) {
                val row = mutableListOf<Int>()
                row.add(1)
                for(j in 0 until i - 1) {
                    row.add(prev[j] + prev[j+1])
                }
                row.add(1)
                ans.add(row)
                prev = row
            }
            return ans
        }
    }
}