class Solution {
    public boolean PredictTheWinner(int[] arr) {
        
        
        int [][] dp = new int[arr.length][arr.length];
        
        for(int g=0;g<dp.length;g++){
            
            for(int i=0,j=g;j<dp.length;i++,j++){
                
                if(g==0){
                    
                    dp[i][j] = arr[i];
                }
                else if(g==1){
                    
                    dp[i][j] = Math.max(arr[i],arr[j]);
                    
                }
                
                else{
                    // i at start, j at end (of the dp box)
                    // IF p1 takes i 
                    // then p2 gets i+1 and jth pos
                    // now if p2 takes i+1 --> p1 gets i+2,j
                    // now if p2 takes j --> p1 gets i+1,j-1
                    // Take min of both, as opponent will try to beat u the best, hence take worst
                     int p1 = arr[i] + Math.min(dp[i+2][j], dp[i+1][j-1]);
                    
                    // IF p1 takes j 
                    // then p2 gets i and j-1 th pos
                    // now if p2 takes i --> p1 gets i+1,j-1
                    // now if p2 takes j --> p1 gets i,j-2
                    // Take min of both, as opponent will try to beat u the best, hence take worst
                     int p2 = arr[j] + Math.min(dp[i+1][j-1], dp[i][j-2]);
                    // Control Back at p1's hand take max of both, as p1 will want to maximize its value
                     int val = Math.max(p1,p2);
                     
                     dp[i][j] = val;
                }      
            }    
        }
        
        int total = 0;
        for(int i=0;i<arr.length;i++)
            total += arr[i];
        
        return dp[0][arr.length-1]>= total - dp[0][arr.length-1]? true : false;
        
        
    }
}