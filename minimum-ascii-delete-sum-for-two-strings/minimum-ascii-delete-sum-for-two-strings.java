class Solution {
    public int minimumDeleteSum(String text1, String text2) {
        
        int [][] dp = new int[text1.length()+1][text2.length()+1];
        
        for(int i = dp.length-1;i>=0;i--){
            
            for(int j = dp[0].length-1;j>=0;j--){
                if(i == dp.length-1 && j== dp[0].length-1){
                    dp[i][j] = 0;
                }
                else if(i == dp.length -1){
                    dp[i][j] = (int)text2.charAt(j) + dp[i][j+1];
                }
                else if(j == dp[0].length -1){
                    dp[i][j] = (int)text1.charAt(i) + dp[i+1][j];
                }
                else{
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);
                
                if(c1 == c2)
                    dp[i][j] = dp[i+1][j+1];
                else
                    dp[i][j] = Math.min(text1.charAt(i)+dp[i+1][j],text2.charAt(j)+dp[i][j+1]);
                    
                }
                
            }
        }
        
        return dp[0][0];
        
    }
}