/*至少是其他数字两倍的最大数*/
package com.chengzimm;

import java.util.Arrays;
import java.util.HashMap;

class Solu {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i],i);
        }
        for(Integer item : map.keySet()){
            System.out.println("key:"+item+"values:"+map.get(item));
        }
        Arrays.sort(nums);
        if(nums[nums.length-1] < 2 * nums[nums.length-2]){
            return -1;
        }
        return map.get(nums[nums.length-1]);
    }
}
class Solution747{
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        //找出当前数组最大的数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
                return -1;
        }
        return maxIndex;
    }
}
public class LeetCode747 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,2};
        Solution747 solution = new Solution747();
        int answer = solution.dominantIndex(nums);
        System.out.println(answer);
    }
}
