/*01 矩阵*/
package com.chengzimm;

import java.util.LinkedList;
import java.util.Queue;

class Solution542 {
    /**0 0 0
     * 0 1 0
     * 1 1 1*/
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        //灵活应对四个方向的变化
        int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // 将所有 0 元素作为 BFS 第一层
                    queue.offer(new int[]{i, j});
                } else {
                    //设一个最大值
                    matrix[i][j] = row + col;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            /*判断条件应该为当前遍历的点与相邻点的情况*/
            // 搜索上下左右四个方向
            for (int[] v : vector) {
                //r：行数 c：列数
                int r = s[0] + v[0];
                int c = s[1] + v[1];
                if (r >= 0 && r < row && c >= 0 && c < col && matrix[r][c] >= matrix[s[0]][s[1]] + 1){
                    matrix[r][c] = matrix[s[0]][s[1]] + 1;
                    queue.offer(new int[]{r, c});
                }
            }
        }
        return matrix;
    }

}

public class LeetCode542 {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        Solution542 solution = new Solution542();
        int[][] answer = solution.updateMatrix(matrix);
        for (int[] items : answer){
            for (int item : items){
                System.out.print(item);
            }
            System.out.println();
        }
    }
}
