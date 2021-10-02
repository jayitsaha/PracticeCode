class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        int i=0, j=0;
        long si=0, sj=0;
        long res = 0;
        
        while(i<n && j<m)
        {
            if(nums1[i] < nums2[j])
            {
                si += nums1[i];
                i++;
            }
            else if(nums1[i] > nums2[j])
            {
                sj += nums2[j];
                j++;
            }
            else
            {
                res += Math.max(si, sj) + nums1[i];
                i++; 
                j++;
                si=0;
                sj=0;
            }
        }
        
        while(i<n)
        {
            si += nums1[i];
            i++;
        }
        
        while(j<m)
        {
            sj += nums2[j];
            j++;
        }
        
        return (int)((Math.max(si, sj) + res) % 1000000007);
        
    }
}
