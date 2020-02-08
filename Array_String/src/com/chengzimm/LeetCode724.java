/*寻找数组的中心索引*/
package com.chengzimm;
class Solu1 {
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum1 = 0, sum2 = 0;
            for (int x = 0; x < i; x++) {
                sum1 += nums[x];
            }
            for (int y = nums.length - 1; y > i; y--) {
                sum2 += nums[y];
            }
            if (sum1 == sum2) {
                return i;
            }
        }
        return -1;
    }
}
//
class Solution724 {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        //计算nums数组的总和
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; i++) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
public class LeetCode724 {
    public static void main(String[] args) {
//        1, 7, 3, 6, 5, 6
        int[] nums = {-1, -1, -1, 0, 1, 1};
        Solution724 solution = new Solution724();
        int answer = solution.pivotIndex(nums);
        System.out.println(answer);
    }
}
