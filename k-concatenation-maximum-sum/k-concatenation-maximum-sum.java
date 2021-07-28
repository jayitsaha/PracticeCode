class Solution {
    
    public int maxSubArray(int[] nums) {
        
        int csum = nums[0];
        int osum = nums[0];
        
        for(int i=1;i<nums.length;i++){
            
            if(csum >= 0)
                csum+=nums[i];
            else
                csum = nums[i];
        
            if(csum > osum)
                osum = csum;
        }
        
        
        if(osum<0)
			return 0;
		return osum%1000000007;
        
        
    }
    
    
    public int kadaneOfTwo(int[] arr) {
        
        int newArr[] = new int[arr.length * 2];

            
            for(int i=0;i<arr.length;i++){
                
                newArr[i] = arr[i];
                
            }
            
            for(int i=0;i<arr.length;i++){
                
                newArr[i + arr.length] = arr[i];
                
            }
        
        return maxSubArray(newArr);
        
    }
    
    
    public int kConcatenationMaxSum(int[] arr, int k) {
        int sum = 0;
        int ans = 0;
        int MOD=1000000007;
        for(int i=0;i<arr.length;i++)
            sum += arr[i];
        
        if(k == 1){
            ans = maxSubArray(arr);
        }
        else if(sum < 0){
            
           ans =  kadaneOfTwo(arr);
        }
        else{
            
            ans = (int) ((kadaneOfTwo(arr) + ((long) k - 2) * sum) % 1000000007);
        }
        
        
        
        
        return ans%MOD;
    }
}