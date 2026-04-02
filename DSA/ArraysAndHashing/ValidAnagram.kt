package ArraysAndHashing

import kotlin.text.iterator

/**
 * Valid Anagram
 * Easy
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise
 * return false.
 *
 * An anagram is a string that contains the exact same characters as another string,
 * but the order of the characters can be different.
 *
 * Example 1:
 *
 * Input: s = "racecar", t = "carrace"
 *
 * Output: true
 * Example 2:
 *
 * Input: s = "jar", t = "jam"
 *
 * Output: false
 * Constraints:
 *
 * s and t consist of lowercase English letters.
 */
fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val strMap = mutableMapOf<Char, Int>()
    for (char in s) {
        strMap[char] = strMap.getOrDefault(char, 0) + 1
    }
    for (char in t) {
        val count = strMap.getOrDefault(char, 0)
        if (count == 0) {
            return false
        }
        strMap[char] = count - 1
    }
    return true
}

fun isAnagramAlternate(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val freqArr = IntArray(26)
    for(i in s.indices){
        freqArr[s[i] - 'a']++
        freqArr[t[i] - 'a']--
    }
    return freqArr.all { it == 0 }
}

fun main() {
    val s1 = "racecar"
    val t1 = "carrace"

    val result1 = isAnagramAlternate(s1, t1)
    println("Example 1: Input: s = \"$s1\", t = \"$t1\", Output: $result1")

    val s2 = "jar"
    val t2 = "jam"

    val result2 = isAnagramAlternate(s2, t2)
    println("Example 2: Input: s = \"$s2\", t = \"$t2\", Output: $result2")
}