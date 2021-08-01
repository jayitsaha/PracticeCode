class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        
        
        int[] dpLeft = new int[A.length];
        int cur = 0;
        for(int i=0;i<A.length;i++){
            cur += A[i];
            if(i>=L){
                cur-=A[i-L];
            }
            if(i<L-1){
                dpLeft[i] = 0;
            }else{
                dpLeft[i] = Math.max((i-1>=0)?dpLeft[i-1]:0, cur);
            }
        }
        
        int[] dpRight = new int[A.length];
        cur = 0;
        for(int i=A.length-1;i>=0;i--){
            cur += A[i];
            if(i<A.length-L){
                cur-=A[i+L];
            }
            if(i>A.length-L){
                dpRight[i] = 0;
            }else{
                dpRight[i] = Math.max((i+1<A.length)?dpRight[i+1]:0, cur);
            }
        }
        
        cur = 0;
        int max = 0;

        for(int i=0;i<A.length;i++){
            cur += A[i];
            if(i>=M){
                cur-=A[i-M];
            }
            
            if(i>=M){
                max = Math.max(max, cur+dpLeft[i-M]);
            }
            if(i+1<A.length){
                max = Math.max(max, cur+dpRight[i+1]);
            }
        }
        
        return max;
        
    }
}