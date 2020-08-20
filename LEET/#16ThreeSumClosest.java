/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 

Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 9999;
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++){
            
            int j=i+1;
            int k=nums.length-1;
                        
            while(j<k){
                
                int current_sum = nums[i]+nums[j]+nums[k];
                if(current_sum>target){
                    k--;
                }
                else{
                    j++;
                }
                
                if(Math.abs(target-current_sum)<Math.abs(target-result)){
                    result = current_sum;
                }
                
                
          
            }
        }
                
        
       return result; 
        
    }
}
