/*杨辉三角*/
package com.chengzimm;

import java.util.ArrayList;
import java.util.List;

class Solution118 {
    /**递归方法总而言之就是抓住三点：
     *   找整个递归的终止条件
     *   找返回值
     *   一次递归需要如何操作*/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> target = new ArrayList<>();
        if (numRows == 0){
          return target;
        }
        if (numRows == 1){
            target.add(new ArrayList<>());
            target.get(0).add(1);
            return target;
        }
        target = generate(numRows - 1);
        List<Integer> row = new ArrayList<>();
        //为最左边一行补1
        row.add(1);
        for(int j = 1; j < numRows - 1; j++){
            row.add(target.get(numRows - 2).get(j - 1) + target.get(numRows - 2).get(j));
        }
        //为最右边一行补1
        row.add(1);
        target.add(row);
        return target;
    }
}
public class LeetCode118 {
    public static void main(String[] args) {
        Solution118 solution = new Solution118();
        List<List<Integer>> answer = solution.generate(5);
        for (List<Integer> items : answer){
            for (int item : items){
                System.out.print(item +" ");
            }
            System.out.println();
        }
    }
}
