/* Pow(x, n)*/
package com.chengzimm;

class Solution50 {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++)
            ans = ans * x;
        return ans;
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    /**当n为奇数时结果为：half * half * rest
     * 当n为偶数时结果为：half * half
     * */
    public double myPow3(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        System.out.println(half);
        double rest = myPow(x, n % 2);
        System.out.println(rest);
        return half * half * rest;
    }
}
public class LeetCode50 {
    public static void main(String[] args) {
        double x = 2.00;
        int n = 3;
        Solution50 solution = new Solution50();
        double v = solution.myPow3(x, n);
        System.out.println(v);
    }
}
