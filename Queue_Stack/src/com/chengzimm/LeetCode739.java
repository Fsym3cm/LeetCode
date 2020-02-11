/**每日温度
 * 每个数都去向后数，直到找到比它大的数*/
package com.chengzimm;

class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        return new int[]{1,2};
    }
}
public class LeetCode739 {
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution739 solution = new Solution739();
        int[] answer = solution.dailyTemperatures(T);
        for (int item : answer){
            System.out.print(item);
        }
    }
}
