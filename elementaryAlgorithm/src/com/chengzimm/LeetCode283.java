package com.chengzimm;

/**
 * 移动零
 *
 * @author CM
 * @aate 2020/9/1 11:07
 */
public class LeetCode283 {

    /**
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        for(int i = nums.length - 1; i >= j; i--){
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        LeetCode283 leetCode283 = new LeetCode283();
        leetCode283.moveZeroes(nums);
        for (int num : nums){
            System.out.print(num);
        }
    }
}
