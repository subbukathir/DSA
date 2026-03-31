/**
 * Contains Duplicate
 *
 * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [1, 2, 3, 3]
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1, 2, 3, 4]
 *
 * Output: false
 * */
fun containsDuplicate(nums: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    for (num in nums) {
        if (!set.add(num)) {
            return true
        }
    }
    return false
}

fun containsDuplicateAlternate(nums: IntArray): Boolean {
    val numsSorted = nums.sorted()
    for (i in 1 until numsSorted.size) {
        if (numsSorted[i] == numsSorted[i - 1]) {
            return true
        }
    }
    return false
}

fun main(args: Array<String>) {
    val nums1 = intArrayOf(1, 2, 3, 3)
    val result1 = containsDuplicateAlternate(nums1)
    println("Example 1: Input: [1, 2, 3, 3], Output: $result1")
    if (result1 == true) {
        println("Example 1 Passed")
    } else {
        println("Example 1 Failed")
    }

    val nums2 = intArrayOf(1, 2, 3, 4)
    val result2 = containsDuplicateAlternate(nums2)
    println("Example 2: Input: [1, 2, 3, 4], Output: $result2")
    if (result2 == false) {
        println("Example 2 Passed")
    } else {
        println("Example 2 Failed")
    }

    println("Finished tests.")
}
