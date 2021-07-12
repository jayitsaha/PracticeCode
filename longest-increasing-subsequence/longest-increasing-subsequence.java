class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int dp[] = new int[nums.length];
//      first value will always have length 1
        dp[0] = 1;
        int omax = 1;
        
//      Double loop, one traverse nums and the other everthing till before curr index
//      Now just see which is the max length( in dp) and has nums[j] less than curr index val
//      add to that dp index
        
        for(int i=1;i<dp.length;i++){
            
            int max = 0;
            
            for(int j=0;j<i;j++){
                
                if(nums[j]<nums[i]){
                    if(dp[j]>max)
                        max = dp[j];
                }
            }
            
            dp[i] = max + 1;
            if(dp[i] > omax)
                omax = dp[i];
        }
        
       return omax;
        
    }
}