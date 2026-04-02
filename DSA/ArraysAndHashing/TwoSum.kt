package ArraysAndHashing

/**
 * Two Sum
 * Easy
 * Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
 *
 * You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
 *
 * Return the answer with the smaller index first.
 *
 * Example 1:
 *
 * Input:
 * nums = [3,4,5,6], target = 7
 *
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] == 7, so we return [0, 1].
 *
 * Example 2:
 *
 * Input: nums = [4,5,6], target = 10
 *
 * Output: [0,2]
 * Example 3:
 *
 * Input: nums = [5,5], target = 10
 *
 * Output: [0,1]
 * Constraints:
 *
 * 2 <= nums.length <= 1000
 * -10,000,000 <= nums[i] <= 10,000,000
 * -10,000,000 <= target <= 10,000,000
 * Only one valid answer exists.
 */

fun twoSum(nums: IntArray, target: Int): IntArray {
    val numMap = mutableMapOf<Int, Int>()

    for(i in nums.indices){
        val complement = target - nums[i]
        if(numMap.containsKey(complement)){
            return intArrayOf(numMap[complement]!!, i)
        }else{
            numMap[nums[i]] = i
        }
    }
    return intArrayOf()
}

fun main(){
    val nums1 = intArrayOf(3,4,5,6)
    val target1 = 7
    val result1 = twoSum(nums1, target1)
    println("Example 1: Input: ${nums1.contentToString()}, target: $target1, Output: ${result1.contentToString()}")

    val nums2 = intArrayOf(4,5,6)
    val target2 = 10
    val result2 = twoSum(nums2, target2)
    println("Example 2: Input: ${nums2.contentToString()}, target: $target2, Output: ${result2.contentToString()}")

    val nums3 = intArrayOf(5,5)
    val target3 = 10
    val result3 = twoSum(nums3, target3)
    println("Example 1: Input: ${nums3.contentToString()}, target: $target3, Output: ${result3.contentToString()}")
}