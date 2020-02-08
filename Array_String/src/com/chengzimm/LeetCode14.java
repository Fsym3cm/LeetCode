package com.chengzimm;

class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++){
            while (strs[i].indexOf(prefix) !=0){
                prefix = prefix.substring(0, prefix.length() -1);
                if (prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }
}
public class LeetCode14 {
    public static void main(String[] args) {
        String[] strs = {};
        Solution14 solution = new Solution14();
        String answer = solution.longestCommonPrefix(strs);
        System.out.println(answer);
    }
}
