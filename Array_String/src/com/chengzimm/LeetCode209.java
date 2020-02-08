/*长度最小的字数组*/
package com.chengzimm;

class Solu4 {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < n) {
            sum += nums[right];
            right++;
            while (sum >= s) {
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int start = i;
            int sum = 0;
            while (start < nums.length) {
                sum += nums[start];
                start++;
                //当前和大于等于 s 的时候结束
                if (sum >= s) {
                    min = Math.min(min, start - i);
                    break;
                }
            }
        }
        //min 是否更新，如果没有更新说明数组所有的数字和小于 s, 没有满足条件的解, 返回 0
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
public class LeetCode209 {
    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        Solu4 solution = new Solu4();
        int answer = solution.minSubArrayLen(s, nums);
        System.out.println(answer);
    }
}
