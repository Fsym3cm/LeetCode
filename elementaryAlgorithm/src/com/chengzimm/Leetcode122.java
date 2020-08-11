//买卖股票的最佳时机 II
package com.chengzimm;

/**
 * @Author CM
 * @Date 2020/8/11 15:30
 */
/**
 * [7,1,5,3,6,4] (5 - 1) + (6 - 3) = 7
 *
 * [1,2,3,4,5] 5 - 1 = 4
 * 解题思路：当连续的单调递增时，其最大的差值等于连续几个小段的差值之和。
 * */
class Solution122{
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0, j = 1; i < prices.length - 1; i++, j++){
            if (prices[j] > prices[i]){
                sum += prices[j] - prices[i];
            }
        }
        return sum;
    }

}
public class Leetcode122 {
    public static void main(String[] args) {
        //{7, 1, 5, 3, 6, 4}   {1, 2, 3, 4, 5}
        int[] prices = new int[]{1, 2, 3, 4, 5};
        Solution122 solution122 = new Solution122();
        System.out.println(solution122.maxProfit(prices));
    }
}
