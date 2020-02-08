/*螺旋矩阵*/
package com.chengzimm;

import java.util.ArrayList;
import java.util.List;

class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
//        for (int i = 0; i < 5; i++){
//            for (int j = 0; j < 5; j++){
//                System.out.print(j);
//            }
//            System.out.println();
//        }
        //计算层数
//        if (row == col){
//            LayerNum = row /2 + row % 2;
//        }else {
//            int min = row < col ? row : col;
//            LayerNum = min /2 + min % 2;
//        }
        //设左上角的坐标为x1(r,c) 右下角的坐标为x2(Row,Col)
        List<Integer> target = new ArrayList<>();
        if (matrix.length == 0){
            return target;
        }
        int r = 0, c = 0;
        int row = matrix.length-1, col = matrix[0].length-1;
        while (r <= row && c <= col){
            //Top
            for (int i = c; i <= col; i++){
                target.add(matrix[r][i]);
            }
            //Right
            for (int j = r + 1; j <= row; j++){
                target.add(matrix[j][col]);
            }
            if (r < row && c < col){
                //Bottom
                for (int i = col - 1; i > c; i--){
                    target.add(matrix[row][i]);
                }
                //Left
                for (int j = row ; j > r; j--){
                    target.add(matrix[j][c]);
                }
            }
            r++;
            c++;
            col--;
            row--;
        }
        return target;
    }
}
public class LeetCode54 {
    public static void main(String[] args) {
        //[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}} ;
//        int[][] matrix = new int[4][3];
//        System.out.println(matrix[1][0]);
//        System.out.println(matrix[0][1]);
        Solution54 solution = new Solution54();
        List<Integer> answer = solution.spiralOrder(matrix);
        System.out.println(answer);
    }
}
