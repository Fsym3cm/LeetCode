package com.chengzimm;

public class ReverseStr {
    /*以相反的顺序打印字符串。*/
    private static void printReverse(char [] str) {
        helper(0, str);
    }

    private static void helper(int index, char [] str) {
        //终止条件
        if (str == null || index >= str.length) {
            return;
        }
        //进行递归
        helper(index + 1, str);
        System.out.print(str[index]);
    }

    public static void main(String[] args) {
        printReverse(new char[]{'h', 'e', 'l', 'l', 'o'});
    }
}
