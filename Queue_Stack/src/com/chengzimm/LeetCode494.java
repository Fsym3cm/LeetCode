package com.chengzimm;

class Solution494 {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 0, 0, S);
    }
    public int dfs(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S){
                count++;
            }
        } else {
            dfs(nums, i + 1, sum + nums[i], S);
            dfs(nums, i + 1, sum - nums[i], S);
        }
        return count;
    }
}

public class LeetCode494 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        Solution494 solution = new Solution494();
        int answer = solution.findTargetSumWays(nums, S);
        System.out.println(answer);
    }
}
