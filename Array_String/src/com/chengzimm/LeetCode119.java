/*杨辉三角 II*/
package com.chengzimm;

import java.util.ArrayList;
import java.util.List;

class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++){
            cur = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i) {
                    cur.add(1);
                }else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return cur;
    }
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> target = new ArrayList<>();
        long pre = 1;
        target.add(1);
        for (int k = 1; k < rowIndex + 1; k++) {
            //组合数计算公式
            long cur = pre * (rowIndex - k + 1) / k;
            target.add((int) cur);
            pre = cur;
        }
        return target;
    }
}
public class LeetCode119 {
    public static void main(String[] args) {
        int rowIndex = 3;
        Solution119 solution = new Solution119();
        List<Integer> answer = solution.getRow1(rowIndex);
        System.out.println(answer);
    }
}
