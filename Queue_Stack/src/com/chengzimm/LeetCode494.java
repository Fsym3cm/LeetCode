/*目标和*/
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
            //递归加的情况
            dfs(nums, i + 1, sum + nums[i], S);
            //递归减的情况
            dfs(nums, i + 1, sum - nums[i], S);
        }
        return count;
    }

    //01背包
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for(int num: nums)
            sum += num;
        if(sum < S || -sum > S)   // 不符合标准的数
            return 0;
        if((S + sum) % 2 != 0)  return 0;  // 背包的容量必须为2的倍数
        int v = (S + sum) / 2;  // 背包的容量

        // dp[i]表示背包容量为i时，有多少种方法
        // dp[i] = dp[i] + dp[i-num] 什么都不放，或者放入num这个元素
        int[] dp = new int[v+1];
        dp[0] = 1;  // 和为0的时候，表示是什么都不选，有一种方法
        for(int num: nums){
            for(int i=v; i>=num; i--)
                dp[i] = dp[i] + dp[i-num];
        }
        return dp[v];
    }

    public static int findTargetSumWays3(int[] nums, int S) {
        int sum = 0;
        for (int val : nums){
            sum += val;
        }
        if (S > sum) return 0;

        int len = nums.length;
        int[][] dp = new int[len][1000*2+1];

        //如果当nums[0]=0,那么在同一个格子里累计两次1，也就变成了2。
        // 所以，第二句就是针对这种情况，在原来的基础上再加1，而不是直接赋值1。
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;

        for (int i = 1; i < dp.length; i++){
            for (int j = -1000;j <= 1000; j++){
                if (dp[i-1][j+1000] > 0) {
                    dp[i][j + nums[i] + 1000] += dp[i - 1][j + 1000];
                    dp[i][j - nums[i] + 1000] += dp[i - 1][j + 1000];
                }
            }
        }

        return dp[nums.length-1][S + 1000];
    }
}

public class LeetCode494 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        Solution494 solution = new Solution494();
        int answer = solution.findTargetSumWays2(nums, S);
        System.out.println(answer);
    }
}
