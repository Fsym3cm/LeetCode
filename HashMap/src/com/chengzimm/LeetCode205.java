/*同构字符串*/
package com.chengzimm;

import java.util.HashMap;
import java.util.HashSet;

class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        //要比较左右两边
        return helper(s, t) && helper(t ,s);
    }
    public boolean helper(String s, String t){
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)){
                //从map中取出对应的值，看与c2是否相等
                if (map.get(c1) != c2) {
                    return false;
                }
            }else {
                map.put(c1, c2);
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) return false;
        int []i1 = new int[128];
        int []i2 = new int[128];
        for (int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (i1[c1] != i2[c2]) return false;
            i1[c1] = i + 1;
            i2[c2] = i + 1;
        }
        return true;
    }
}
public class LeetCode205 {
    public static void main(String[] args) {
        String s = "eb", t = "aa";
        Solution205 solution = new Solution205();
        boolean isomorphic = solution.isIsomorphic2(s, t);
        System.out.println(isomorphic);
    }
}
