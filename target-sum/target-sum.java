class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        if(target > sum){
            return 0;
        }
        else{
            return (target+sum)%2 ==0? subsetCount(nums,(target+sum)/2):0;
        }
    }
        
        private int subsetCount(int[] nums, int target){
            int n = nums.length;
            int dp[][] = new int[1002][1002];
            dp[0][0] = 1;
        
            for(int i=1;i<=n;i++){
                for(int j=0; j<=target; j++){
                    if(i == 0 && j != 0){
                        dp[i][j] = 0;
                    }
                    if(nums[i-1] <= j){
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[n][target];
        }           
}