/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.


*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
      /*
      First step is to set the prefix as first string.
      Now run a loop from the second string onwards
      
      In it check for the index of the prefix with the strings
      
      If index has no match decrease the length of prefix until there is a match and then finally return prefix
      
      */
        for(int i=1;i<strs.length;i++)
        {
        
            while(strs[i].indexOf(prefix)!=0){
                
                prefix = prefix.substring(0,prefix.length()-1);
            }
            
        }
        
        return prefix;
        
    }
}
