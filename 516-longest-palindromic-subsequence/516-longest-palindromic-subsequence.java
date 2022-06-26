class Solution {
    public int longestPalindromeSubseq(String s) {
        
        //We will use the hashMap to store the length of each subsequence
        //HashMap<currentSubsequence, lengthOfTheCurrentSubsequence>
        HashMap<String, Integer> subsequences = new HashMap<>();
        
        return recursion(s, 0, s.length()-1, subsequences);
    }
    public int recursion(String s, int start, int end, HashMap<String, Integer> subsequences){
        //base case, exit recursion
        if(start>end){
            return 0;
        }
        //base case, a string consisting of one char is a palindrom. return its length of 1
        if(start==end){
            return 1;
        }
        
        char startChar = s.charAt(start);
        char endChar = s.charAt(end);
        
        //Construct a key. It can be anything, but must be unique
        //e.g. for a string "aaba" the key will be "0-3"
        //We cannot use startChar and endChar, we must use their indexes, because chars are not unique
        String key = start + "-" + end;
        
        //calculate the length of the current subsequence if it is not saved in the HashMap yet
        if(!subsequences.containsKey(key)){
            //There might be two options: "startChar" is equal to "endChar", "startChar" is different from "endChar"
            if(startChar==endChar){
                //When "startChar" is equal to "endChar", calculate the subproblem by reducing the current subsequence 
                //To do so, decrease both start and end of the current subsequence. 
                //Add 2 to the solution (2 is the length of chars which we subtracted from the start and the end)  
				Integer currSubseqLength = recursion(s, start+1, end-1, subsequences)+2;
                subsequences.put(key, currSubseqLength);
            }else{
                //When "startChar" is different from "endChar", we need to evaluate two options and chose the longest one: 
                //either increase start (start+1) or decrease end (end -1) 
                //e.g. substring "abbb": we need to evaluate "bbb" and "abb" to find the longest    
				Integer currSubseqLength = Math.max(recursion(s, start+1, end, subsequences), 
                            recursion(s, start, end-1, subsequences));
                subsequences.put(key, currSubseqLength);  
            }
        }
        return subsequences.get(key); 
    }
}