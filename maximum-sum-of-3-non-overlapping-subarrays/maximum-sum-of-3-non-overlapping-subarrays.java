class Solution {
    public int[] maxSumOfThreeSubarrays(int[] arr, int k) {
        
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] prefixSum = new int[n];
        int sum = 0;
        
        
        for(int i=0;i<n;i++){
            
            if(i==0)
                prefixSum[i] = arr[i];
            else{
                
                prefixSum[i] = prefixSum[i-1] + arr[i];
            }
        }
        
        for(int i=0;i<n;i++){
            
            if(i<k){
                sum+= arr[i];
                left[i] = sum;
            }
            else{
                
                sum += arr[i] - arr[i-k];
                left[i] = Math.max(sum, left[i-1]);  
            }
        }
        
        sum = 0;

        for(int i=n-1;i>=0;i--){
            
            if(i+k>=n){
                sum+= arr[i];
                right[i] = sum;
            }
            else{
                
                sum += arr[i] - arr[i+k];
                right[i] = Math.max(sum, right[i+1]);  
            }
        }
     
        int maxSum = 0;
        int startPointMiddle = -1;
        int lsum = 0;
        int rsum = 0;
        
        for(int i=k;i<=n-2*k;i++){
            
            int leftPart = left[i-1];
            int rightPart = right[i+k];
            int middlePart = prefixSum[i+k-1] - prefixSum[i-1];
            if(maxSum < (leftPart+rightPart+middlePart))
            {
                maxSum = (leftPart+rightPart+middlePart);
                lsum = left[i-1];
                rsum = right[i+k];
                startPointMiddle = i;
                
                
            }
        }
        int leftIndex = 0;
        for(int i=k-1;i<startPointMiddle;i++){
            
            if(prefixSum[i] - (i-k<0?0: prefixSum[i-k]) == lsum){
                leftIndex = i-k+1;
                break;
            }
            
        }
        
        
        int rightIndex = 0;
        for(int i=startPointMiddle + 2*k-1;i<n;i++){
            
            if(prefixSum[i] - prefixSum[i-k] == rsum){
                rightIndex = i-k+1;
                break;
            }
            
        }
        
        
        
        int[] ans = new int[3];
        ans[0] = leftIndex;
        ans[1] = startPointMiddle;
        ans[2] = rightIndex;
        return ans;
        
        
    }
}