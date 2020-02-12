package com.chengzimm;

import java.util.Stack;

class Solution150 {
    /** stack: 2          计算式
     *         2  1
     *         2  1  +
     *         2  1        1 + 2
     *         3(要把计算式的结果放到栈中来运算，不然会发生减号运算顺序错误)
     *         3 * 3       3 * 3*/
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        if (tokens.length ==1){
            return Integer.parseInt(tokens[0]);
        }
        for (int i = 0; i < tokens.length; i++){
            if (tokens[i].equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if (tokens[i].equals("-")){
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 - temp1);
            }else if (tokens[i].equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if (tokens[i].equals("/")){
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            }else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
public class LeetCode150 {
    public static void main(String[] args) { //"3","11","5","+","-" pop1 = 16 pop2 = 3   pop2 - pop1 = -13
        String[] tokens = {"3","11","+","5","-"};                 //pop2 = 14 pop1 = 5 pop2 - pop1 = 9
        Solution150 solution = new Solution150();
        int answer = solution.evalRPN(tokens);
        System.out.println(answer);
    }
}
