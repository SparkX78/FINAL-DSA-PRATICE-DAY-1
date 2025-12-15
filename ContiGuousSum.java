import java.util.*;
public class ContiGuousSum {
    public static int contiguousBinary(int[] nums){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }

        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            
            if(map.containsKey(sum)){
                int last = map.get(sum);
                maxLength = Math.max(maxLength, i - last);
            }
            else{
                map.put(sum, i);
            }
        }
        return maxLength;
    }
    public static void main(String[] args){
        int[] nums = {0, 0, 1, 1, 0, 0, 0, 1};
        System.out.println(contiguousBinary(nums));
    }
}
