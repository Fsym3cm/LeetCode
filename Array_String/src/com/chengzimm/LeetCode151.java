/*翻转字符串里的单词*/
package com.chengzimm;

import java.util.Stack;

class Solution151 {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        s += " ";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (temp.length() != 0) {
                    stack.push(temp.toString());
                    temp = new StringBuilder();
                }
            } else {
                temp.append(s.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        res.append(stack.pop());
        while (!stack.isEmpty()) {
            res.append(" ");
            res.append(stack.pop());
        }
        return res.toString();
    }

    public String reverseWords1(String s) {
        if (s == " ") {
            return " ";
        }
        //去掉s的首尾空格 然后将字符串拆分
        String[] sps = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = sps.length - 1; i >= 0; i--) {
            //如果正则后的数组不为空  !"".equals(sps[i].trim())
            if (sps[i].length() > 0) {
                sb.append(sps[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }
}

public class LeetCode151 {
    public static void main(String[] args) {
        String s = "Hello world!";
        Solution151 solution = new Solution151();
        String answer = solution.reverseWords1(s);
        System.out.println(answer);
    }
}
