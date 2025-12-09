package org.example.Array

/**
 * Leetcode 2544 - https://leetcode.com/problems/alternating-digit-sum/
 * You are given a positive integer n. Each digit of n has a sign according to the following rules:
 * - The most significant digit is assigned a positive sign.
 * - Each other digit has an opposite sign to its adjacent digits.
 * Return the sum of all digits with their corresponding sign.
 */
class AlternatingDigitSum {
    class Solution {
        fun alternateDigitSum(n: Int): Int {
            val list = ArrayDeque<Int>()
            var num = n
            var alternator = 1
            var sum = 0

            while(num > 0) {
                list.addFirst(num % 10)
                num /= 10
            }

            for(num in list) {
                sum += (num * alternator)
                alternator *= -1
            }

            return sum
        }
    }
}