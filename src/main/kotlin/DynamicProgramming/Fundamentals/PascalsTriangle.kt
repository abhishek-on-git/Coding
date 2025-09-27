package org.example.DynamicProgramming.Fundamentals

class PascalsTriangle {

    // Pascal's Triangle 1 (LC 118)
    /**
     *    1
     *   1 1
     *  1 2 1
     * 1 3 3 1
     *
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

    // Pascal's Triangle 2 (LC 119)
    /**
     * Only difference from Pascal's Triangle 1 is that here we
     * are asked to return just the ith row, not all the rows
     */
    class Pascal2Solution {
        fun getRow(rowIndex: Int): List<Int> {
            var prev = mutableListOf(1)
            for(i in 1..rowIndex) {
                val row = mutableListOf<Int>()
                row.add(1)
                for(j in 0 until i-1) {
                    row.add(prev[j] + prev[j+1])
                }
                row.add(1)
                prev = row
            }
            return prev
        }
    }

    // Pascal's Triangle 2 Follow up (O(rowIndex) space)
    /**
     * Create a list initialized with all 1s and create
     * each row in every iteration. So for rowIndex 4, the
     * iterations would look like this:
     * [1,1,1,1,1]
     * [1,2,1,1,1]
     * [1,3,3,1,1]
     * [1,4,6,4,1]
     */
    class Solution {
        fun getRow(rowIndex: Int): List<Int> {
            val row = MutableList(rowIndex + 1) { 1 }
            if(rowIndex < 2) return row

            for(i in 1 until rowIndex) {
                var t = 1
                for(j in 1..i) {
                    val sum = row[j] + t
                    t = row[j]
                    row[j] = sum
                }
            }

            return row
        }
    }
}