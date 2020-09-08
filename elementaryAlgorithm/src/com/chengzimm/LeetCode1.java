package com.chengzimm;

import java.util.HashMap;

/**
 * 两数之和
 *
 * @Author CM
 * @Date 2020/9/1 11:20
 */
public class LeetCode1 {

    /**
     * nums = [2, 7, 11, 15], target = 9
     * nums[0] + nums[1] = 2 + 7 = 9
     * [0, 1]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int difference;
        for (int i = 0; i < nums.length; i++){
            difference = target - nums[i];
            // hashMap.containsKey(difference) 等同于 hashMap.get(difference) != null
            // 直接在hashmap中看有没有目标数据，如果有则返回结果，没有这将本数据放入hashmap中保存起来
            if (hashMap.containsKey(difference)){
                return new int[]{hashMap.get(difference), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        LeetCode1 leetCode1 = new LeetCode1();
        int[] ints = leetCode1.twoSum(nums, target);
        for (int num : ints){
            System.out.print(num);
        }
    }
}
