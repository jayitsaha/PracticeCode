class Solution {
    public int twoEggDrop(int n) {
        
        int [][] dp = new int[3][n+1];
        
        for(int i=1;i<=2;i++){
            
            for(int j=1;j<=n;j++){
                
                
                if(i==1){
                    dp[i][j] = j;
                }
                else if(j==1){
                    dp[i][j] = 1;
                }
                else{
                    int min = Integer.MAX_VALUE;                    
                    for(int currj = j-1,prevj = 0;currj >=0;currj--,prevj++){
                        
                        int v1 = dp[i][currj]; //egg survives
                        int v2 = dp[i-1][prevj]; //egg breaks
                        
                        int max = Math.max(v1,v2);
                        
                        min = Math.min(max,min);
                    }
                    
                    dp[i][j] = min + 1;
                        
                }
                
            }
        }
        
        return dp[2][n];
        
    }
}