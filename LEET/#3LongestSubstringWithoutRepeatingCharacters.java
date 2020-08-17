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
        
        int i=0;
        int j=0;
        int max=0;
        HashSet<Character> hset = new HashSet();
        
        while(j<s.length()){
            
            if(!hset.contains(s.charAt(j))){
                
                hset.add(s.charAt(j));
                j++;
                max = Math.max(hset.size(),max);
                
            }
            else{
                hset.remove(s.charAt(i));
                i++;
                
            }
            
            
            
        }
        
        return max;
        
        
    }
}
