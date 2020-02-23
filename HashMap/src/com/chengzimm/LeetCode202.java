/*快乐数*/
package com.chengzimm;

import java.util.HashSet;
import java.util.Set;

class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1){
            n = change(n);
            if (set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }

    public int change(int n){
        int sum = 0;
        while(n != 0){
            int num = n % 10;
            n /= 10;
            sum += num * num;
            System.out.println(sum);
        }
        return sum;
    }

    public boolean isHappy2(int n) {
        //一位数中只有，1和7是快乐数
        if(n == 1 || n == 7) {
            return true;
        }
        if(n < 10) {
            return false;
        }
        int sum = 0;
        while (n != 0){
            int x = n % 10;
            n = (n - x) / 10;
            sum += x * x;
            System.out.println(sum);
        }
        return isHappy2(sum);
    }
}

public class LeetCode202 {
    public static void main(String[] args) {
        int n = 18;
        Solution202 solution = new Solution202();
        boolean answer = solution.isHappy2(n);
        System.out.println(answer);
    }
}
