/*无重复字符的最长子串*/
package com.chengzimm;

import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, temp = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                //要把重复的值的序号传出来
                temp = map.get(c) > temp ? map.get(c) : temp;
            }
            max = max > i - temp + 1 ? max : i - temp + 1;
            //赋值值为i + 1 ：从字符位置后一个才开始不重复，可以避免当为" "时为0；
            map.put(c, i + 1);
        }
        return max;
    }

    /*滑动窗口*/
    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // 窗口形状：[i, j]
        for (int j = 0, i = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(map.get(c), i);
            }
            // j - i + 1 : 即为加上开始未计算不重复的数
            max = Math.max(max, j - i + 1);
            map.put(c, j + 1);
        }
        return max;
    }
}
public class LeetCode3 {
    public static void main(String[] args) {
        //abcabcbb   bbbbb  pwwkew
        String s = "dvdf";
        Solution3 solution = new Solution3();
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
