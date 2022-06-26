class Solution {
    public String addBinary(String a, String b) {
        StringBuilder bin=new StringBuilder();
        
        int i = a.length() - 1; //pointer 1
        int j = b.length() - 1; //pointer 2
        
        int carry = 0; //carry is set to 0
        
//         now what we need to do is, start a while loop from the end of the two strings to the start
//         and keep checking is any of the string still alive, if alive then we can add
        
        while(i>=0 || j>=0){
            
            int sum = carry; //initially set with carry, later we add the two more digits
                
            if(i>=0){ //basically if first string still alive
                
                sum+= a.charAt(i) - '0'; //so we need to do this - '0' because we converting to character
                i = i-1;
            }
            
            if(j>=0){ //basically if second string still alive
                
                sum+= b.charAt(j) - '0'; //so we need to do this - '0' because we converting to character
                j = j-1;
            }
            
//             now time to change carry based on the sum
            
            if(sum>1){
                carry = 1;
            }
            else{
                carry = 0;
            }
            
//          now we know for 0 and 2, the result actually is 0, and for 1 and 3, the result is 1
            
            bin.append(sum%2);
            
            
        }
        
        
        
        if(carry==1){
            bin.append('1');
        }
        return bin.reverse().toString();
    }
}