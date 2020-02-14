/*字符串解码*/
package com.chengzimm;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class Solution394 {
    /** stackNum: 3    stackChar: []      condition: '3'    res: ""
     *            3              [""]                 [          ""
     *            3              [""]                 a          "a"
     *            3              [""]                 2          "a"
     *            3, 2           [""] ["a"]           [          ""
     *            3, 2           [""] ["a"]          'c'         "c"
     *            3              [""]                 ]          "acc"
     *            0              []                   ]          "accaccacc"*/

    public String decodeString(String s) {
        Stack<String> charStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int iterNum = 0;
        for (char c: s.toCharArray()) {
            if (c == '[') {
                numStack.push(iterNum);
                charStack.push(res.toString());
                System.out.println("res:" + res.toString());
                iterNum = 0;
                res = new StringBuilder();
            } else if (c == ']'){
                StringBuilder temp = new StringBuilder();
                int num = numStack.pop();
                System.out.println("res:" + res.toString());
                for (int i = 0; i < num; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(charStack.pop() + temp);
            } else if (c >= '0' && c <= '9') {
                iterNum = iterNum * 10 + (c - '0');
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}

public class LeetCode394 {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        Solution394 solution = new Solution394();
        String answer = solution.decodeString(s);
        System.out.println(answer);
    }
}
