/**
 * 数组拆分
 * 即将数组组成n个对子，将对子中最小的数字相加*/
package com.chengzimm;

import java.util.Arrays;

class Solution561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}

public class LeetCode561 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution561 solution = new Solution561();
        int answer = solution.arrayPairSum(nums);
        System.out.println(answer);
    }
}
