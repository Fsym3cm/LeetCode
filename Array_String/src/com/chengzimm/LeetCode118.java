/*杨辉三角*/
package com.chengzimm;

import java.util.ArrayList;
import java.util.List;

/* n = 5
*  1
*  1 1
*  1 2 1        (2,1) = (1,0) + (1,1)
*  1 3 3 1      (3,1) = (2,0) + (2,1)
*  1 4 6 4 1*/
class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> target = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++ ){
                if (j == 0 || j == i) {
                    list.add(1);
                }else {
                    //i-1 与 j-1 即为上一行的左边的数字
                    list.add(target.get(i-1).get(j-1) + target.get(i-1).get(j));
//                    System.out.println("x:" + target.get(1).get(1));
                }
            }
            target.add(list);
        }
        return target;
    }
}
public class LeetCode118 {
    public static void main(String[] args) {
        int numRows = 6;
        Solution118 solution = new Solution118();
        List<List<Integer>> answer = solution.generate(numRows);
        System.out.println(answer);
    }
}
