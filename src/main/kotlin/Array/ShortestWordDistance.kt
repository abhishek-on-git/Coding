package org.example.Array

/**
 * Leetcode 243 - Shortest Word Distance
 * Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2,
 * return the shortest distance between these two words in the list.
 */
class ShortestWordDistance {
    //Approach 1 O(N)
    class Solution1 {
        fun shortestDistance(wordsDict: Array<String>, word1: String, word2: String): Int {
            var fi = -1
            var first = ""
            var second = ""
            var min = wordsDict.size

            for(i in wordsDict.indices) {
                if(wordsDict[i] == word1 || wordsDict[i] == word2) {
                    if(first == "" || wordsDict[i] == first) {
                        fi = i
                        first = if(wordsDict[i] == word1) word1 else word2
                        second = if(wordsDict[i] == word1) word2 else word1
                    }
                    if(wordsDict[i] == second) {
                        min = minOf(min, i - fi)
                        second = first
                        first = wordsDict[i]
                        fi = i
                    }
                }
            }
            return min
        }
    }

    // Approach 2 O(N) but better
    class Solution2 {
        fun shortestDistance(wordsDict: Array<String>, word1: String, word2: String): Int {
            var i1 = -1
            var i2 = -1
            var min = wordsDict.size

            for(i in wordsDict.indices) {
                if(wordsDict[i] == word1) {
                    i1 = i
                }
                if(wordsDict[i] == word2) {
                    i2 = i
                }
                if(i1 != -1 && i2 != -1) {
                    min = minOf(min, Math.abs(i1 - i2))
                }
            }

            return min
        }
    }

}