/*最大的连续1的个数*/
package com.chengzimm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum++;
            } else {
                sum = 0;
            }
            //应该再取一个变量用来存放最大值
            max = max > sum ? max : sum;
        }
        return max;
    }
}
class Solu3{
    public int findMaxConsecutiveOnes(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum ++;
            }else {
                arr.add(sum);
                sum = 0;
            }
        }
        arr.add(sum);
        Collections.sort(arr);
        System.out.println(arr);
        return arr.get(arr.size()-1);
    }
}

public class LeetCode485 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1, 0, 1, 1};
        Solu3 solution = new Solu3();
        int answer = solution.findMaxConsecutiveOnes(nums);
        System.out.println(answer);
    }
}
