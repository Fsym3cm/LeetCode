package com.chengzimm;
/*前 K 个高频元素*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution347 {
    /*数组长度 ：.length  链表长度 ：.size()*/
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] list = new ArrayList[nums.length + 1];

        for (Integer key : map.keySet()){
            // 出现的次数
            int i = map.get(key);
            if(list[i] == null) list[i] = new ArrayList();
            // 当前次数中 包含那些数
            list[i].add(key);
        }

        for(int i = list.length - 1; i >= 0 && res.size() < k; i--){
            if(list[i] != null) res.addAll(list[i]);
        }
        return res;
    }
}

public class LeetCode347 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Solution347 solution = new Solution347();
        List<Integer> list = solution.topKFrequent(nums, k);
        System.out.println(list);
    }
}
