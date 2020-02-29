/*四数相加 II*/
package com.chengzimm;

import java.util.HashMap;
import java.util.Map;

class Solution454 {
    /**
     * 一.采用分为两组，HashMap存一组，另一组和HashMap进行比对。
     * 二.这样的话情况就可以分为三种：
     * 1.HashMap存一个数组，如A。然后计算三个数组之和，如BCD。时间复杂度为：O(n)+O(n^3),得到O(n^3).
     * 2.HashMap存三个数组之和，如ABC。然后计算一个数组，如D。时间复杂度为：O(n^3)+O(n),得到O(n^3).
     * 3.HashMap存两个数组之和，如AB。然后计算两个数组之和，如CD。时间复杂度为：O(n^2)+O(n^2),得到O(n^2).
     * 三.根据第二点我们可以得出要存两个数组算两个数组。
     * 四.我们以存AB两数组之和为例。首先求出A和B任意两数之和sumAB，以sumAB为key，sumAB出现的次数为value，存入hashmap中。
     * 然后计算C和D中任意两数之和的相反数sumCD，在hashmap中查找是否存在key为sumCD。
     * 算法时间复杂度为O(n2)。*/
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            for(int j= 0; j < B.length; j++){
                int sumAB = A[i] + B[j];
                if(map.containsKey(sumAB)){
                    map.put(sumAB, map.get(sumAB) + 1);
                }
                else {
                    map.put(sumAB, 1);
                }
            }
        }

        for(int i = 0; i < C.length; i++){
            for(int j = 0;j < D.length; j++){
                int sumCD = - (C[i] + D[j]);
                if(map.containsKey(sumCD)) sum += map.get(sumCD);
            }
        }
        return sum;
    }

    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A){
            for (int b : B){
                int sumAB = a + b;
                map.put(sumAB, map.getOrDefault(sumAB, 0) + 1);
            }
        }
        int sum = 0;
        for (int c : C){
            for (int d : D){
                int sumCD = -(c + d);
                sum += map.getOrDefault(sumCD, 0);
            }
        }
        return sum;
    }
}

public class LeetCode454 {
    public static void main(String[] args) {
        int[] A = {1, 2}, B = {-2, -1}, C = {-1, 2}, D = {0, 2};
        Solution454 solution = new Solution454();
        int i = solution.fourSumCount2(A, B, C, D);
        System.out.println(i);
    }
}
