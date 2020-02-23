/*两个数组的交集*/
package com.chengzimm;

import java.util.*;

class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num1 : nums1){
            if (!set.contains(num1)){
                set.add(num1);
            }
        }
        for (int num2 : nums2){
            if (set.contains(num2)){
                list.add(num2);
                //当添加了一个不同的元素后，set里删除该元素，保证交集元素不重复。
                set.remove(num2);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j])) {
                set.add(nums2[j]);
            }
        }

        int[] res = new int[set.size()];
        Iterator iterator = set.iterator();
        int k = 0;
        while (iterator.hasNext()) {
            res[k] = (int) iterator.next();
            k++;
        }

        return res;
    }
}

public class LeetCode349 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        Solution349 solution = new Solution349();
        int[] intersection = solution.intersection(nums1, nums2);
        for (int i : intersection){
            System.out.println(i);
        }
    }
}
