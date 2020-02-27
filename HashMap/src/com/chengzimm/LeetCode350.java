/*两个数组的交集 II*/
package com.chengzimm;

import java.util.*;

class Solution350 {
    /*使用哈希表记录数组1中的数和其对应频次。遍历数组2，如果当前索引的数在哈希表中存在，则把它丢进结果list中，
    并把它在哈希表中的频次-1，如果频次为0就移除它。完成遍历后，list中就是我们希望得到的结果。*/
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : nums1) {
            if(!map.containsKey(num)){
                map.put(num, 1);
            }
            else {
                map.put(num, map.get(num) + 1);
            }
        }
        for(int num : nums2) {
            if(map.containsKey(num)) {
                list.add(num);
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /*排序*/
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        //将指定数组的指定范围复制到新数组中。
        return Arrays.copyOfRange(nums1, 0, k);
    }
}

public class LeetCode350 {
    public static void main(String[] args) {
        // 1, 2, 2, 1     2, 2    4, 9, 5    9, 4, 9, 8, 4
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        Solution350 solution = new Solution350();
        int[] intersect = solution.intersect2(nums1, nums2);
        for (int i : intersect){
            System.out.println(i);
        }
    }
}
