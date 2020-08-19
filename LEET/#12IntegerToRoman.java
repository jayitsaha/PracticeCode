/*
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: 3
Output: "III"
Example 2:

Input: 4
Output: "IV"
Example 3:

Input: 9
Output: "IX"
Example 4:

Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/
class Solution {
    public String intToRoman(int num) {
        
       String ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"}; 
       String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
       String hund[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
       String thousand[] ={"","M","MM","MMM"};
        
       return thousand[num/1000]+hund[num%1000/100]+tens[num%100/10]+ones[num%10];
    }
}
