//旋转数组
package com.chengzimm;

/**
 * @Author CM
 * @Date 2020/8/11 15:59
 */

import java.util.Arrays;

/**
 * [1,2,3,4,5,6,7] 和 k = 3
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * [5,6,7,1,2,3,4]*/
class Solution189 {
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
    }

    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reserve(nums, 0, nums.length - 1);
        reserve(nums, 0, k - 1);
        reserve(nums, k, nums.length - 1);
    }

    // 使用递归进行反转数组
    public void reserve(int nums[], int start, int end){
        if(end > start) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            /**
             *这里写递增条件只能写 num + 1或者 ++num 不能num++否者会报错误 */
            reserve(nums, start + 1, end - 1);
        }
    }
}

public class LeetCode189 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Solution189 solution189 = new Solution189();
        solution189.rotate1(nums, k);
        for(int i : nums){
            System.out.print(i + " ");
        }
    }
}
