class Solution {
    public int minimumMountainRemovals(int[] arr) {
        
        int n = arr.length;
//      Longest Increasing Subsequence
        int[] lis = new int[n];
        
        for(int i=0;i<n;i++){
            
            int max = 0;
            
            for(int j=0;j<i;j++){
                
                if(arr[j] < arr[i]){
                    
                    if(lis[j] > max){
                        
                        max = lis[j];
                    }
                }
            }
            
            lis[i] = max + 1;
        }
        
        
//      Longest Decreasing Subsequence
        
        int[] lds = new int[n];
        
        for(int i=n-1;i>=0;i--){
            
            int max = 0;
            
            for(int j=n-1;j>i;j--){
                
                if(arr[j] < arr[i]){
                    
                    if(lds[j] > max){
                        
                        max = lds[j];
                    }
                }
            }
            
            lds[i] = max + 1;
        }
        
        
        
//      Find Bitonic Length and subtract from the array length !! YAY!!
       int safe=0;

//     Find the best combo of the two arrays with the maximum number of safe elements i.e. numbers not to be removed
        for(int i =0;i<lis.length;i++){
            if(lis[i]>1 && lds[i]>1){
                safe= Math.max(safe,lis[i]+lds[i]-1);
            }
        }

        
        return n - safe;
        
        
        
    }
}