/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Implementing sliding window logic
        int a_pointer = 0;  //Keeps the start index
        int b_pointer = 0;  //Slides or traverses the array
        int max = 0;        //Store the max length of hashset as our final result
        
        HashSet<Character> hash_set = new HashSet<>(); 
        
        while (b_pointer<s.length()) {                
            if(!hash_set.contains(s.charAt(b_pointer))) {     //if hashset does not contain current element
                hash_set.add(s.charAt(b_pointer));            //add it to hashset
                b_pointer++;                                  //increment the slider counter
                max = Math.max(hash_set.size(),max);          //update the max length
            }
            else {                                            //if hashset contains current el
                hash_set.remove(s.charAt(a_pointer));         //remove the last seen element from hashset
                a_pointer++;                                  //increment the starter index counter by 1
            }
        }
        return max;
    }
}
            
            
        }
        
        return max;
        
        
    }
}
