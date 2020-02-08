package com.chengzimm;

class Solution28 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
public class LeetCode28 {
    public static void main(String[] args) {
        String haystack = "hello" , needle = "ll";
        Solution28 solution = new Solution28();
        int answer = solution.strStr(haystack, needle);
        System.out.println(answer);
    }
}
