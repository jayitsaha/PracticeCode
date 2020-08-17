/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
*/
class Solution {
    public boolean isPalindrome(int x) {
        
        StringBuilder str = new StringBuilder(); 
        str.append(Integer.toString(x));
        

        String revString = str.reverse().toString();
        String initString  = Integer.toString(x);

      

        if(initString.equals(revString) == true)
            return true;
        else
            return false;
        
   
        
    }
}
