/*字符串中的第一个唯一字符*/
package com.chengzimm;

import java.util.HashMap;

class Solution387 {
    public int firstUniqChar(String s) {
        if (s.isEmpty()) return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)){
                //要获取上次的值，然后加一不能i++
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c, 1);
            }
        }
        for (int j = 0; j < s.length(); j++) {
            if (map.get(s.charAt(j)) == 1)
                return j;
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        //fast
        int n = s.length();

        for (int i = 'a'; i <= 'z'; i++) {
            int start = s.indexOf(i);
            int end = s.lastIndexOf(i);

            if (start == end && start != -1) {
                n = Math.min(start, n);
            }
        }

        if (n == s.length()) {
            return -1;
        } else {
            return n;
        }
    }
}
public class LeetCode387 {
    public static void main(String[] args) {
        String s = "dddccdbba";
        Solution387 solution = new Solution387();
        int i = solution.firstUniqChar(s);
        System.out.println(i);
    }
}
