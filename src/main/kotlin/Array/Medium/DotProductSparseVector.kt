package org.example.Array.Medium

/**
 * Leetcode 1570 - Dot Product of two sparse vectors.
 * Given two sparse vectors, compute their dot product.
 * Implement class SparseVector:
 * SparseVector(nums) Initializes the object with the vector nums
 * dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
 * A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently
 * and compute the dot product between two SparseVector.
 *
 * Follow up: What if only one of the vectors is sparse?
 */
class DotProductSparseVector {
    class SparseVector(nums: IntArray) {
        private val vectorMap = mutableMapOf<Int, Int>()

        init {
            for(i in nums.indices) {
                if(nums[i] != 0) {
                    vectorMap[i] = nums[i]
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        fun dotProduct(vec: SparseVector): Int {
            // This is important concept. Focus here when revisit.
            val (small, big) = if(vectorMap.size < vec.vectorMap.size)
                vectorMap to vec.vectorMap else vec.vectorMap to vectorMap
            var product = 0
            for((k, v) in small) {
                product += (v * (big[k] ?: 0))
            }
            return product
        }
    }

    /**
     * Your SparseVector object will be instantiated and called as such:
     * var v1 = SparseVector(nums1)
     * var v2 = SparseVector(nums2)
     * val ans = v1.dotProduct(v2)
     */
}