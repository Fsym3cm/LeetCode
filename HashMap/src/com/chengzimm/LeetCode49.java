/*字母异位词分组*/
package com.chengzimm;

import java.util.*;

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map=new HashMap<>();
        for (String str : strs){
            char [] s = str.toCharArray();
            Arrays.sort(s);
            String key = new String(s);
            if (map.containsKey(key)){
                //如果有这类的则从map中获取这个值
                List<String> arr = map.get(key);
                //把当前遍历的属于同一类的值放在list后
                arr.add(str);
                map.put(key, arr);
            } else {
                List<String> arr = new ArrayList<>();
                arr.add(str);
                map.put(key, arr);
            }
        }
        return new ArrayList<>(map.values());
    }

    //上面的优化版本
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for(String str : strs){
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String key = String.valueOf(s);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}

public class LeetCode49 {
    public static void main(String[] args) {
        String[] strs = {"eat",  "tea",  "tan",  "ate",  "nat",  "bat"};
        Solution49 solution = new Solution49();
        List<List<String>> lists = solution.groupAnagrams(strs);
        for (List<String> list : lists){
            for (String str: list){
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
