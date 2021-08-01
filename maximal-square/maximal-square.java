class Solution {
    public int maximalSquare(char[][] matrix) {
        
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        int ans = Integer.MIN_VALUE;
        
        for(int i=dp.length-1;i>=0;i--){
            
            for(int j=dp[0].length -1;j>=0;j--){
                
                if(i == dp.length-1 || j == dp[0].length-1){
                    if(matrix[i][j] == '0')
                        dp[i][j] = 0;
                    else
                        dp[i][j] = 1;
                    
                    if(dp[i][j] > ans)
                        ans = dp[i][j];
                }
                
                else{
                    if(matrix[i][j] == '0')
                        dp[i][j] = 0;
                    else
                    {
                        int min = Math.min(dp[i][j+1],Math.min(dp[i+1][j+1],dp[i+1][j]));
                        dp[i][j] = min + 1;
                        if(dp[i][j] > ans)
                            ans = dp[i][j];
                    }
                }
            }
        }

       return ans*ans; 
    }
}