package org.example.Array.Easy

class PartitionsWithEvenSumDiff {
    /**
     * Direct approach, just as the question asks.
     * But not the best approach.
     */
    class Solution1 {
        fun countPartitions(nums: IntArray): Int {
            var ans = 0
            var sum = 0
            for(num in nums) {
                sum += num
            }

            var leftSum = 0

            for(i in 0 until nums.size-1) {
                leftSum += nums[i]
                if((leftSum - (sum - leftSum)) % 2 == 0) {
                    ans++
                }
            }

            return ans
        }
    }

    /**
     * If left partition sum is x, and right partition sum is y,
     * then total array sum is x + y. If total sum is even, then for every
     * x + y that is even, x - y will also be even. This implies that if total
     * sum is even, then ans will be n-1, otherwise it will be 0.
     */
    class Solution2 {
        fun countPartitions(nums: IntArray): Int {
            var sum = 0
            for(num in nums) {
                sum += num
            }
            return if(sum % 2 == 0) nums.size-1 else 0
        }
    }
}