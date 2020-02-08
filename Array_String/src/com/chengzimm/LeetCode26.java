/*删除排序数组中的重复项*/
package com.chengzimm;

class Solution26 {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != nums[k]){
                //应放在操作之前，使不重复的元素放在第二个位置（第一个元素不会移动）
                k++;
                nums[k] = nums[i];
            }
        }
        return k + 1;
    }
}
public class LeetCode26 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Solution26 solution = new Solution26();
        int answer = solution.removeDuplicates(nums);
        for (int i = 0; i < answer; i++){
            System.out.print(nums[i]);
        }
    }
}
