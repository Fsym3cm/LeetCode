/*对角线遍历*/
package com.chengzimm;

/** target(rowIndex,colIndex)
    位置        方向     操作           判断条件                 0      1      2
 (0,2)-> (1,2) 往下  rowIndex++  colIndex == col - 1      0    1      2      3
 (0,0)-> (0,1) 往右  colIndex++  rowIndex == 0               (0,0)  (0,1)  (0,2)
                                                         1    4      5      6
 (2,1)-> (2,2) 往右  colIndex++  rowIndex == row - 1         (1,0)  (1,1)  (1,2)
 (1,0)-> (2,0) 往下  rowIndex++  colIndex == 0           2    7      8      9
                                                            (2,0)  (2,1)  (2,2)
 关于边界问题的条件应该放在前面。
 * */
class Solution498 {
    public int[] findDiagonalOrder(int[][] matrix){
        if(matrix.length == 0){
            return new int[]{};
        }
        //row 行数 ；col 列数
        int row = matrix.length, col = matrix[0].length;
        //rowIndex 当前遍历的行的索引 ；colIndex 当前遍历的列的索引
        int rowIndex = 0, colIndex = 0;
        int[] target = new int[row * col];
        for (int i = 0; i < target.length; i++){
            target[i] = matrix[rowIndex][colIndex];
            //如果为偶数则往上读取，如果为奇数则往下读取。
            if ((rowIndex + colIndex) % 2 == 0){
                //这个条件要放在前面，不然则会出现边界问题
                if (colIndex == col - 1){
                    //往下移
                    rowIndex++;
                }
                else if (rowIndex == 0){
                    //往右移
                    colIndex++;
                }else {
                    //往斜上方移动
                    rowIndex--;
                    colIndex++;
                }
            }else {
                if (rowIndex == row - 1){
                    //往右移
                    colIndex++;
                }else if (colIndex == 0){
                    //往下移
                    rowIndex++;
                }else {
                    //往斜下方移动
                    rowIndex++;
                    colIndex--;
                }
            }
        }
        return target;
    }
}
public class LeetCode498 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}} ;
        Solution498 solution = new Solution498();
        int[] answer = solution.findDiagonalOrder(matrix);
        System.out.println(answer);
        for (int item : answer){
            System.out.print(item);
        }
    }
}
