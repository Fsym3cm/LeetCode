/*反转字符串*/
package com.chengzimm;

class Solution344 {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
        System.out.println(s);
    }
}

public class LeetCode344 {
    public static void main(String[] args) {
        //字符串使用"",字符数组使用'';
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        Solution344 solution = new Solution344();
        solution.reverseString(s);
    }
}
