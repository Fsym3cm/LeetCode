/*有效的数独*/
package com.chengzimm;

class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][9];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][9];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    //i / 3 * 3 : 即为该块在9*9中的行号，j / 3 ： 为列号，相加即为其序号
                    int blockIndex = i / 3 * 3 + j / 3;
                    // 如果存在这些元素则返回false
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        //如果不存在则给这个些格子赋值为true
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }
}

public class LeetCode36 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.' , '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1' , '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.' , '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.' , '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8' , '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.' , '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.' , '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4' , '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.' , '8', '.', '.', '7', '9'},
        };
        Solution36 solution = new Solution36();
        boolean validSudoku = solution.isValidSudoku(board);
        System.out.println(validSudoku);
    }
}
