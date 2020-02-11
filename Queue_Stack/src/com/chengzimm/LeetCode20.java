/*有效的括号*/
package com.chengzimm;

import java.util.Stack;

class Solution20 {
    /**
     * stack } )  s ) }
     * empty与isEmpty差不多。*/
    public boolean isValid(String s) {
        if (s.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(')');
            }else if (s.charAt(i) == '['){
                stack.push(']');
            }else if (s.charAt(i) == '{'){
                stack.push('}');
            }else if (stack.isEmpty() || s.charAt(i) != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
    /**
     * stack { (  s ) }
     * empty与isEmpty差不多。*/
    public boolean isValid2(String s) {
        if (s.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if ((s.charAt(i) == '(') || (s.charAt(i) == '[') || (s.charAt(i) == '{')){
                stack.push(s.charAt(i));
            }else{
                if(s.charAt(i) == ')'){
                    if (stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                }else if(s.charAt(i) == ']'){
                    if (stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                }else if(s.charAt(i) == '}'){
                    if (stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
public class LeetCode20 {
    public static void main(String[] args) {
        String s = "{()}";
        Solution20 solution = new Solution20();
        boolean answer = solution.isValid2(s);
        System.out.println(answer);
    }
}
