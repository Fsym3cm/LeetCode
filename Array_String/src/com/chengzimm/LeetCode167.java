/*两数之和 II - 输入有序数组*/
package com.chengzimm;

import java.util.HashMap;

class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++){
            int temp = target - numbers[i];
            if (map.containsKey(temp)){
                return new int[]{map.get(temp) + 1, i + 1};
            }
            /**以（数值，序号）键值对的形式存放HashMap是为了使用get取出values
             * 否则则无法以读值取key的方式得到数值*/
            map.put(numbers[i], i);
        }
        return new int[]{};
    }
}

public class LeetCode167 {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 15};
        int target = 6;
        Solution167 solution = new Solution167();
        int[] answer = solution.twoSum(numbers, target);
        for (int item : answer) {
            System.out.print(item);
        }
    }
}
