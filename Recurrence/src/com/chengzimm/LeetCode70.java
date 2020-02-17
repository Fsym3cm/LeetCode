/*爬楼梯*/
package com.chengzimm;

import java.util.HashMap;

class Solution70 {
    /**1:                                               1
     * 2: (1,1),(2)                                     2
     * 3: (1,1,1),(1,2),(2,1)                           3
     * 4: (1,1,1,1),(2,1,1),(1,2,1),(1,1,2),(2,2)       5
     * 5: (1,1,1,1,1),(2,1,1,1),(1,2,1,1),(1,1,2,1),
     *    (1,1,1,2),(2,2,1),(2,1,2),(1,2,2)             8*/
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }else if (n == 2){
            return 2;
        }else{
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    //递归记忆化
    public int climbStairs2(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }

    //动态规划
    public int climbStairs3(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
public class LeetCode70 {
    public static void main(String[] args) {
        Solution70 solution = new Solution70();
        int answer = solution.climbStairs2(44);
        System.out.println(answer);
    }
}
