package leetcode;
import java.util.*;

/***
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap();
        int[] result = new int[2];
        for(int i = 0 ; i < nums.length; i++){
            int complement = target - nums[i];
            if(!hm.containsKey(complement)){
                hm.put(nums[i],i);
            }
            else{
                result[0]=hm.get(complement);result[1] = i;
                break;
            }
        }
        return result;
    }
}


public class TwoSum {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,4,5};
        int[] result = s.twoSum(nums, 9);
        System.out.println(result.length);
        System.out.println("Required Index -");
        System.out.println(Arrays.toString(result));
    }
}


