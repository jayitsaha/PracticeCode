class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> dictionary = new HashSet<>(wordDict);
        if(s.length() == 1 && dictionary.contains(s)) return true;
        int[] dp = new int[s.length()];
        
        for(int i=0;i<dp.length;i++){
            
            for(int j=0;j<=i;j++){
                String word = s.substring(j,i+1);
                
                if(dictionary.contains(word)){
                    
                    if(j>0)
                        dp[i] += dp[j-1];
                    else
                        dp[i] += 1;
                }
            }
        }
        
        return dp[s.length()-1] > 0;
        
    }
}