class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        int[] dp = new int[n];
        dp[0] = 1;
        
        
        int[] pointer = new int[primes.length];
        
        for(int i=1;i<n;i++){
            int min = Integer.MAX_VALUE;
            
            for(int j=0;j<primes.length;j++){
                int value = primes[j] * dp[pointer[j]];
                if(value< min)
                    min = value;
            }
            
            dp[i] = min;
            
            for(int j=0;j<primes.length;j++){
                if(min == primes[j] * dp[pointer[j]])
                    pointer[j]++;
            }
        }
    
        return dp[n-1];
        
        
    }
}