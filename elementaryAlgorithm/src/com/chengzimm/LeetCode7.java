package com.chengzimm;

/**
 * @author CM
 * @date 2020/9/16 15:43
 */
public class LeetCode7 {

    public boolean isPalindrome(int x) {
        int rev = 0;
        int x1 = x;
        if(x1 < 0){
            return false;
        }
        while(x1 != 0){
            // 反转后的数字
            rev = rev * 10 + x1 % 10;
            System.out.println(rev);
            // 121 -》 12
            x1 /= 10;
            System.out.println(x1);
        }
        return rev == x;
    }

    public static void main(String[] args) {
        LeetCode7 leetCode7 = new LeetCode7();
        System.out.println(leetCode7.isPalindrome(121));
    }
}
