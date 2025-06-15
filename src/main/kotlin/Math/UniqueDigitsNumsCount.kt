package org.example.Math

/**
 * Leetcode 357 - https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 * Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.
 */
class UniqueDigitsNumsCount {

    /**
     * Think of this from the point of view of Permutations.
     * Base cases - For n = 0 ans is 1, and for n = 1 ans is 10.
     * Now when n = 2: You can have 9 possibilities in the tens place, and 9 in ones as well.
     * This is because "0" cannot be in the tens place, but it can be in the ones place.
     * So ans for n = 2 will be 10 + 9*9 = 91
     * Now for n = 3, You can have 9 possibilities in hundreds place, 9 in tens place and 8 in ones place.
     * So ans for n = 4 will be 10 + 9*9 + 9*9*8
     */
    class Solution {
        fun countNumbersWithUniqueDigits(n: Int): Int {
            if(n == 0) return 1
            var dig = 9
            var curr = 9
            var ans = 10
            var i = 2
            while(i++ <= n && dig > 0) {
                curr *= dig--
                ans += curr
            }
            return ans
        }
    }
}