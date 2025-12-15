import java.util.*;
public class LongSubArrayK {
    public static int longestSubarray(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int prefixSum = 0;
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            if(map.containsKey(prefixSum-k)){
                result = Math.max(result, i - map.get(prefixSum-k));
                
            }
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, i);
            }
            
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {2,2, 5, 1, 1, 1, 1, 4};
        int k  = 4;
        System.out.println(longestSubarray(nums, k));
    }
}
