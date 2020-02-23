/*存在重复元素*/
package com.chengzimm;

import java.util.HashSet;

class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])){
                set.add(nums[i]);
            }else {
                return true;
            }
        }
        return false;
    }
}

public class LeetCode217 {
    public static void main(String[] args) {
        int[] nums = {};
        Solution217 solution = new Solution217();
        boolean b = solution.containsDuplicate(nums);
        System.out.println(b);
    }
}
