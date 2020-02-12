/**每日温度
 * 每个数都去向后数，直到找到比它大的数*/
package com.chengzimm;

import java.util.Stack;

class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int[] target = new int[T.length];
        for (int i = 0; i < T.length; i++){
            for (int j = i + 1; j < T.length; j++){
                if (T[j] > T[i]){
                    target[i] = j - i;
                    break;
                }else {
                    target[i] = 0;
                }
            }
        }
        return target;
    }

    /**我的思路：不好算那个最后几个数字
     * stack: 73 74   target: 1
     *        74 75           1
     *        75 71
     *        75 71 69
     *        75 71 69 72
     *        75 71 69 72 76  4
     *        69 72 76 73     2
     *        72 76 73        1
     *        76 73           1
     *        73              0
     *        0               0*/

    /**       栈尾         栈顶
     * stack: 0(73)             T[i]: 1(74)      target: 1(1-0)
     *        1(74)                   2(75)       1，1(2-1)
     *        2(75)                   3(71)
     *        2(75) 3(71)             4(69)
     *        2(75) 3(71) 4(69)       5(72)       1, 1, 0, 0, 1(5-4)
     *        2(75) 3(71)             5(72)       1, 1, 0, 2(5-3), 1
     *        2(75) 5(72)             6(76)       1, 1, 0, 2, 1, 1(6-5)
     *        2(75)                   6(76)       1, 1, 4(6-2), 2, 1, 1
     *        6(76)                   7(73)       1, 1, 4, 2, 1, 1
     *        7(73)                   7(73)       1, 1, 4, 2, 1, 1
     *        后面的0为初始化时设置的*/
    public int[] dailyTemperatures2(int[] T) {
        int[] target = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++){
            //peek : 获得stack顶部的元素(  firstElement：获得堆栈中序号为0的元素(栈尾部)
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                int temp = stack.pop();
                target[temp] = i - temp;
            }
            stack.push(i);
        }
        return target;
    }
}

public class LeetCode739 {
    public static void main(String[] args) {
//        {55, 38, 53, 81, 61, 93, 97, 32, 43, 78}
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution739 solution = new Solution739();
        int[] answer = solution.dailyTemperatures2(T);
        for (int item : answer){
            System.out.print(item);
        }
    }
}
