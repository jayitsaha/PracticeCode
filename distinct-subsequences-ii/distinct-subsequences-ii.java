class Solution {
    public int distinctSubseqII(String s) {
        
        
        int[] dp = new int[s.length() + 1];
        
        dp[0] = 1;
        long mod = (long)1e9+7;
        HashMap<Character,Integer> lastOccurence = new HashMap<>();
        
        for(int i=1;i<dp.length;i++){
            
            
            dp[i]=(int)(((long)dp[i-1]*2)%mod);
            char ch = s.charAt(i-1);
            
            if(lastOccurence.containsKey(ch)){
                int j = lastOccurence.get(ch);
                dp[i] = (int)((dp[i] - ((long)dp[j-1]%mod) + mod) % mod) ;
                
            }
            
            
            lastOccurence.put(ch,i);
            
            
            
        }
        return ((dp[s.length()]-1));
    }
}