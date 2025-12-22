package org.example.Array.Easy

/**
 * Leetcode 2728:
 * You are given an object street of class Street that represents a circular street
 * and a positive integer k which represents a maximum bound for the number of houses in
 * that street (in other words, the number of houses is less than or equal to k).
 * Houses' doors could be open or closed initially.
 *
 * Initially, you are standing in front of a door to a house on this street.
 * Your task is to count the number of houses in the street.
 *
 * The class Street contains the following functions which may help you:
 *
 * void openDoor(): Open the door of the house you are in front of.
 * void closeDoor(): Close the door of the house you are in front of.
 * boolean isDoorOpen(): Returns true if the door of the current house is open and false otherwise.
 * void moveRight(): Move to the right house.
 * void moveLeft(): Move to the left house.
 * Return ans which represents the number of houses on this street.
 */
class HouseCountCircularStreet {
    /**
     * Definition for a street.
     * class Street(doors: IntArray) {
     *     fun openDoor()
     *     fun closeDoor()
     *     fun isDoorOpen(): Boolean
     *     fun moveRight()
     *     fun moveLeft()
     * }
     */
    class Solution {
        fun houseCount(street: Street, k: Int): Int {
            var i = 0
            var ans = 1

            for(i in 1..k) {
                street.closeDoor()
                street.moveRight()
            }

            street.openDoor()
            street.moveRight()

            while(!street.isDoorOpen()) {
                ans++
                street.moveRight()
            }

            return ans
        }
    }

    // Dummy class to fix build fail
    class Street(doors: IntArray) {
        fun openDoor(){}
        fun closeDoor(){}
        fun isDoorOpen(): Boolean{return false}
        fun moveRight(){}
        fun moveLeft(){}
    }
}