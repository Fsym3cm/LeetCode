package com.chengzimm;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author CM
 * @Date 2020/9/1 12:23
 */
public class LeetCode36 {

    /**
     * [0, 0], [0, 1], [0, 2]    [0, 3], [0, 4], [0, 5]
     * [1, 0], [1, 1], [1, 2]    [1, 3], [1, 4], [1, 5]
     * [2, 0], [2, 1], [2, 2]    [1, 3], [1, 4], [1, 5]
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hashSetRow, hashSetCol;
        int row = board[0].length, col = board.length;
        for (int i = 0; i < col; i++){
            System.out.println();
            hashSetRow = new HashSet<>();
            hashSetCol = new HashSet<>();
            for (int j = 0; j < row; j++){
                System.out.print(board[i][j] + " ");
                // 从行检查是否符合规则
                if (board[i][j] != '.'){
                    if (!hashSetRow.contains(board[i][j])) {
                        hashSetRow.add(board[i][j]);
                    } else {
                        return false;
                    }
                }
                // 从列检查是否符合规则
                if (board[j][i] != '.'){
                    if (!hashSetCol.contains(board[j][i])){
                        hashSetCol.add(board[j][i]);
                    } else {
                        return false;
                    }
                }
            }
        }
        HashSet<Character>[] help = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            help[i] = new HashSet<>();
        }
        // 从方格进行检查是否符合规则
        for (HashSet<Character> set : help) {
            set.clear();
        }

        // 方块
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // 第几个子数独
                    int cur = i / 3 * 3 + j / 3;
                    if (help[cur].contains(board[i][j])) {
                        return false;
                    }
                    help[cur].add(board[i][j]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        LeetCode36 leetCode36 = new LeetCode36();
        boolean validSudoku = leetCode36.isValidSudoku(board);
        System.out.println(validSudoku);
    }
}
