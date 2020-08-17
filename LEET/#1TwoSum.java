import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] result = new int[2];
    for(int i = 0; i < nums.length; i++){
        if(map.containsKey(nums[i]))
        {
            result[0] = map.get(nums[i]);
            result[1] = i;
            return result;
        }
        else
            map.put(target - nums[i], i);    
    }
    return result; 
    
        
        
    }
}
