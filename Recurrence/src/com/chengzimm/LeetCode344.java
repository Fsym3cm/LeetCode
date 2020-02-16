/*反转字符串*/
package com.chengzimm;

class Solution344 {
    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }
    public void helper(char[] s, int start, int end){
        if (s.length == 0 || start >= s.length / 2) {
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        helper(s, start + 1 ,end - 1);
    }
}
public class LeetCode344 {
    public static void main(String[] args) {
        //{'h', 'e', 'l', 'l', 'o'}
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        Solution344 solution = new Solution344();
        solution.reverseString(s);
        System.out.println(s);
    }
}
