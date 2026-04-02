package ArraysAndHashing

import kotlin.collections.mutableListOf

/**
 * Group Anagrams
 * Medium
 *
 * Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
 *
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 *
 * Example 1:
 *
 * Input: strs = ["act","pots","tops","cat","stop","hat"]
 *
 * Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
 * Example 2:
 *
 * Input: strs = ["x"]
 *
 * Output: [["x"]]
 * Example 3:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 * Constraints:
 *
 * 1 <= strs.length <= 1000.
 * 0 <= strs[i].length <= 100
 * strs[i] is made up of lowercase English letters.
 */

fun groupAnagram(strs: Array<String>): List<List<String>> {
    val result = mutableListOf<List<String>>()
    val visited = BooleanArray(strs.size)

    for (i in strs.indices) {
        if (visited[i]) continue
        val group = mutableListOf<String>()

        for (j in strs.indices) {
            if (!visited[j] && isValidAnagram(strs[i], strs[j])) {
                group.add(strs[j])
                visited[j] = true
            }
        }
        result.add(group)
    }
    return result
}

fun isValidAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val freqArr = IntArray(26)
    for (i in s.indices) {
        freqArr[s[i] - 'a']++
        freqArr[t[i] - 'a']--
    }
    return freqArr.all { it == 0 }
}

fun optimisedGroupAnagram(strs: Array<String>): List<List<String>> {
    val result = mutableMapOf<String, MutableList<String>>()
    for(word in strs){
        //val key = word.toCharArray().sorted().joinToString()
        val key = getKey(word)
        result.getOrPut(key) { mutableListOf() }.add(word)
    }
    return result.values.toList()
}

fun getKey(word: String) : String {
    val freqArr = IntArray(26)
    for(c in word){
        freqArr[c - 'a']++
    }
    return freqArr.joinToString("#")
}

fun main() {
    val strs = listOf("act", "pots", "tops", "cat", "stop", "hat")
    val result = optimisedGroupAnagram(strs.toTypedArray())
    println("Example 1: Input: strs = $strs, Output: $result")

    val strs2 = listOf("x")
    val result2 = optimisedGroupAnagram(strs2.toTypedArray())
    println("Example 2: Input: strs = $strs2, Output: $result2")
}
