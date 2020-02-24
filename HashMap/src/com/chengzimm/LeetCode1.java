/*两数之和*/
package com.chengzimm;

import java.util.HashMap;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int num = 0, i;
        for (i = 0; i < nums.length; i++){
            num = target - nums[i];
            if (!map.containsKey(num)){
                map.put(nums[i], i);
            }else {
                break;
            }
        }
        return new int[]{map.get(num), i};
    }
}

public class LeetCode1 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        Solution1 solution = new Solution1();
        int[] nums1 = solution.twoSum(nums, target);
        for (int num : nums1){
            System.out.print(num);
        }
    }
}
