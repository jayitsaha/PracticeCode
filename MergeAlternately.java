class Solution {
    public String mergeAlternately(String word1, String word2) {
    String  ans ="";
        int ab =0;
        int ac =0;
        
        for(int i=0;i<word1.length()+word2.length();i++){       
            if(i<word1.length()){
                ans+=word1.charAt(ab);
                ab++;
            }
            if(i<word2.length()){
                ans +=word2.charAt(ac);
                ac++;
            }
        }   
    return ans;
    }
}
