package ArraysAndHashing

/**
 * Encode and Decode Strings
 * Medium
 * Topics
 * Company Tags
 * Hints
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 *
 * Machine 1 (sender) has the function:
 *
 * string encode(vector<string> strs) {
 *     // ... your code
 *     return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 *
 * vector<string> decode(string s) {
 *     //... your code
 *     return strs;
 * }
 * So Machine 1 does:
 *
 * string encoded_string = encode(strs);
 * and Machine 2 does:
 *
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 *
 * Implement the encode and decode methods.
 *
 * Example 1:
 *
 * Input: dummy_input = ["Hello","World"]
 *
 * Output: ["Hello","World"]
 *
 * Explanation:
 * Machine 1:
 * Codec encoder = new Codec();
 * String msg = encoder.encode(strs);
 * Machine 1 ---msg---> Machine 2
 *
 * Machine 2:
 * Codec decoder = new Codec();
 * String[] strs = decoder.decode(msg);
 * Example 2:
 *
 * Input: dummy_input = [""]
 *
 * Output: [""]
 *
 * Constraints:
 *
 * 0 <= strs.length < 100
 * 0 <= strs[i].length < 200
 * strs[i] contains any possible characters out of 256 valid ASCII characters.
 */

fun encode(strs: List<String>): String {
    var result = ""
    for(str in strs){
        result += str.length.toString() + "#" + str
    }
    return result
}

fun decode(str: String) : List<String> {
    if(str.isEmpty()) return listOf()
    val result = mutableListOf<String>()
    var i = 0
    while(i < str.length){
        var j = i
        while(str[j] != '#'){
            j++
        }
        val length = str.substring(i, j).toInt()
        result.add(str.substring(j + 1, j + 1 + length))
        i = j + 1 + length
    }
    return result
}

fun main(){
    val example1 = listOf<String>("Hello", "World")
    val encode1 = encode(example1)
    val result1 = decode(encode1)
    println("Example 1 is $example1 result of $result1")
}