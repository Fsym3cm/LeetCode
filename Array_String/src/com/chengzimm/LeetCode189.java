/*旋转数组*/
package com.chengzimm;

class Solution189 {
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++){
            //把数组往右引动一位
            int previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++){
                int temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}

class Solu5 {
    public void rotate(int[] nums, int k) {
        //当k大于数组长度时，取它的余数，去除掉一圈的无用操作。
        k %= nums.length;
        reverse(nums, 0,nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k , nums.length - 1);
    }
    //翻转。
    public void reverse(int[] nums, int start, int end){
        /*不能处理（k,nums.length - 1）因为 i = 0;*/
//        for (int i = 0; i < (end - start) / 2; i++){
//            int temp = nums[i];
//            nums[i] = nums[end - start - i];
//            nums[end - start - i] = temp;
//        }
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

public class LeetCode189 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        Solu5 solution = new Solu5();
        solution.rotate(nums, k);
        for (int item : nums){
            System.out.print(item);
        }
    }
}
