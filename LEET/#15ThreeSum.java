/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        
        List<List<Integer>> res = new ArrayList<>(); // Create a result list to return and append
        //Binary Search type methodology works only on sorted arrays
        //It will ensure the maximum possible value is encountered
        Arrays.sort(nums); 
        for(int i=0;i<nums.length-2;i++){
//      As we need to find triplets, thus dont make the i go more than last -2, else out of bounds
        if(i>0 && nums[i] == nums[i-1])
            continue; //Condition where we skip same result
        
//         Now use 2 pointer sum method on the remaining array elements ..(from the ith element)
        int j=i+1,k=nums.length-1; 
        int target = -nums[i];
        while (j < k) {
//         If there is a match save result, increment lower bound decrement upper bound

            if (nums[j] + nums[k] == target) {
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;
                k--;
//              
                while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
            } 
//          If sum of the two greater than target, decrease upper bound as the array sorted in increasing order
            else if (nums[j] + nums[k] > target) {
                k--;
            } 
//          Else increase upper Bound
            else {
                j++;
            }
        }
        
        
    }
               return res; 

}
}
