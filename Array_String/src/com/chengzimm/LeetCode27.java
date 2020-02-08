/*移除元素*/
package com.chengzimm;

class Solution27 {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length - 1; i++){
            //删除元素不好实现，则直接将不满足条件添加到该数组的前面。
            if (nums[i] != val){
                nums[k] = nums[i];
                //应放在操作之后，使不被移除的第一个元素放在第一个位置
                k++;
            }
        }
        return k;
    }
}

public class LeetCode27 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,0,4,2};
        int val = 2;
        Solution27 solution = new Solution27();
        // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
        int answer = solution.removeElement(nums, val);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < answer; i++) {
            System.out.print(nums[i]);
        }
    }
}
