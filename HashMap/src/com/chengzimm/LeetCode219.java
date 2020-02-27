/*存在重复元素 II*/
package com.chengzimm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer temp = map.get(nums[i]);
            if(temp == null){
                map.put(nums[i], i);
            } else {
                if (i - temp <= k){
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            //形成一个滑动窗口
            if (set.size() > k) {
                //减去滑动窗口前面的最前的一个元素
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}

public class LeetCode219 {
    public static void main(String[] args) {
        //1, 2, 3, 1, 2, 3    1, 2, 3, 1   1, 0, 1, 1
        int[] nums = {1,2,3,1};
        int k = 3;
        Solution219 solution = new Solution219();
        boolean b = solution.containsNearbyDuplicate(nums, k);
        System.out.println(b);
    }
}
