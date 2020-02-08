package com.chengzimm;

import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;

class Solution283 {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[k] = nums[i];
                //应放在操作之后，从第一位置开始放数据。
                k++;
            }
        }
        for (int i = k; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}

public class LeetCode283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Solution283 solution = new Solution283();
        solution.moveZeroes(nums);
        for (int item : nums){
            System.out.print(item);
        }
    }
}
