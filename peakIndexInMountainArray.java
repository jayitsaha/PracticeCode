class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        for(int i=0;i<arr.length-1;i++) {
            if(arr[i+1]<arr[i]) {
                return i;
            }
        }
        return 0;
    }
}
