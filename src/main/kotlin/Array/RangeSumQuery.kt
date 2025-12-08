package org.example.Array

//Leetcode 303 - https://leetcode.com/problems/range-sum-query-immutable/description/
class RangeSumQuery {

    // Calculating sum everytime causes TLE. So better approach is to calculate prefix sum.
    // That way only once we need to do preprocessing which takes O(N). But all subsequent calls
    // to sumRange take O(1) time.
    class NumArray(private val nums: IntArray) {

        // [0, -2, -2, 1, -4, -2, -3]
        private val numbers = IntArray(nums.size + 1)

        init {
            for(i in nums.indices) {
                numbers[i+1] = numbers[i] + nums[i]
            }
        }

        fun sumRange(left: Int, right: Int): Int {
            return numbers[right + 1] - numbers[left]
        }

    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * var obj = NumArray(nums)
     * var param_1 = obj.sumRange(left,right)
     */
}