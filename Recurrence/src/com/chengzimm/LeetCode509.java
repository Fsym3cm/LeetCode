/*斐波那契数*/
package com.chengzimm;

import java.util.HashMap;

class Solution1013 {
    public int fib(int N) {
        if (N == 0){
            return 0;
        }else if (N == 1){
            return 1;
        }else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    //递归记忆化（HashMap）但效率不高。
    public int fib2(int N) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        if (cache.containsKey(N)){
            return cache.get(N);
        }
        int result;
        if (N == 0){
            result = 0;
        }else if (N == 1){
            result = 1;
        }else {
            result = fib2(N - 1) + fib2(N - 2);
        }
        cache.put(N, result);
        return result;
    }

    //递归记忆化
    public int fib3(int N) {
        int memo[]=new int[100];
        for (int i : memo){
            System.out.print(i);
        }
        return helper(N, memo);
    }

    public int helper(int N, int[] memo){
        if(N==0){
            return memo[N] = 0;
        }
        if(N==1){
            return memo[N] = 1;
        }
        if(memo[N]> 0){
            return memo[N];
        }
        memo[N]= helper(N-1, memo)+helper(N-2, memo);
        return helper(N-1, memo)+helper(N-2, memo);
    }

    //动态规划
    public int fib4(int N) {
        if (N == 0){
            return 0;
        }
        if (N == 1){
            return 1;
        }
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }
}
public class LeetCode509 {
    public static void main(String[] args) {
        Solution1013 solution = new Solution1013();
        int fib = solution.fib3(45);
        System.out.println(fib);
    }
}
