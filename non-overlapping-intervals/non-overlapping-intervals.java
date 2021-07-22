class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        
        int[] prev = intervals[0];
        
        int count = 0;
        
        for(int i=1;i<intervals.length;i++){
            
            if(intervals[i][0] >= prev[1]){
                prev = intervals[i];
            }
            else
                count++;
        }
        return count;
    }
}