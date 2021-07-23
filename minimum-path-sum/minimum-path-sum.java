class Solution {
    public int minPathSum(int[][] obstacleGrid) {
        
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;  
    
      if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
			return 0;
		}
		
 
    int[][] dp = new int[m][n];
    dp[0][0] = obstacleGrid[0][0];
    //left column
    for(int i=1; i<m; i++){
        dp[i][0] = obstacleGrid[i][0]+dp[i-1][0];
    }
 
    //top row
    for(int j=1; j<n; j++){
        dp[0][j] = obstacleGrid[0][j]+dp[0][j-1];
    }
 
    //fill up the dp table
    for(int i=1; i<m; i++){
        for(int j=1; j<n; j++){
            dp[i][j] = obstacleGrid[i][j]+ Math.min(dp[i-1][j],dp[i][j-1]);
        }
    }
 
    return dp[m-1][n-1];
}
}