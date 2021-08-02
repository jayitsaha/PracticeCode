class Solution {
    public int nthUglyNumber(int n) {
    
        int limit = Integer.MAX_VALUE;
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        
        
        for(int i=1;i<n;i++){
            
            int f1 = 2 * dp[p2];
            int f2 = 3 * dp[p3];
            int f3 = 5 * dp[p5];
            
            
            int min = Math.min(f1,Math.min(f2,f3));
            
            dp[i] = min;
            
            if(min == f1)
                p2++;
            if(min == f2)
                p3++;
            if(min == f3)
                p5++;
            
            
            
            
            
        }
    
        return dp[n-1];
        
    }
}