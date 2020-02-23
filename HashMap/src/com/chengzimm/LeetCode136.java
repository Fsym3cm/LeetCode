/*只出现一次的数字*/
package com.chengzimm;

import java.util.HashSet;

class Solution136 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums){
            if (!set.contains(num)){
                set.add(num);
            }else {
                set.remove(num);
            }
        }
        for (Integer i : set) {
            return i;
        }
        return 0;
        /*Object[] arr = set.toArray();
        return (int) arr[0];*/
    }

    /*^ : 异或运算符，两个相同的数异或后变成0*/
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for(int num: nums) {
            ans ^= num;
        }
        return ans;
    }
}

public class LeetCode136 {
    public static void main(String[] args) {
        int[] nums = {};
        Solution136 solution = new Solution136();
        int i = solution.singleNumber2(nums);
        System.out.println(i);
    }
}
