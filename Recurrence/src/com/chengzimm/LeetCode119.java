/*杨辉三角 II*/
package com.chengzimm;

import java.util.ArrayList;
import java.util.List;

class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        //rowIndex为非负数，第一行索引为0
        if (rowIndex == 0){
            row.add(1);
            return row;
        }
        List<Integer> lastRow = getRow(rowIndex - 1);
        row.add(1);
        for (int i = 1; i < lastRow.size(); i++){
            row.add(lastRow.get(i - 1) + lastRow.get(i));
        }
        row.add(1);
        return row;
    }
}
public class LeetCode119 {
    public static void main(String[] args) {
        int rowIndex = 2;
        Solution119 solution = new Solution119();
        List<Integer> row = solution.getRow(rowIndex);
        for (int item : row){
            System.out.print(item);
        }
    }
}
