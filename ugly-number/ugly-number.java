class Solution {
    public boolean isUgly(int n) {
        if(n<=0) return false;
        if(n==1) return true;
        int limit = Integer.MAX_VALUE;
        int[] dp = new int[1000000];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        boolean flag = false;
        
        
        for(int i=2;i<=100000;i++){
            
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
            
            
            if(min == n){
                flag = true;
                break;
            }
            
            
        }
    
        return flag;
    }
}