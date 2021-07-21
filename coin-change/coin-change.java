class Solution {
    public int coinChange(int[] coins, int amount) {
        
        
        int [][] dp = new int[coins.length + 1][amount + 1];
        
        for(int i=0;i<=coins.length;i++){
            for(int j=0;j<=amount;j++){
                
                if(j==0)
                    dp[i][j] = 0;
                else if(i == 0)
                    dp[i][j] = 100000;
                else if(coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], (1+ dp[i][j-coins[i-1]]));
                    
            }
        }
        
        return dp[coins.length][amount] > 10000 ? -1 : dp[coins.length][amount];
        
        
        
        
    }
}