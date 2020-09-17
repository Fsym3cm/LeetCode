package com.chengzimm;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 *
 * @author CM
 * @date 2020/9/16 14:37
 */
public class LeetCode6 {

    /**
     * "LEETCODEISHIRING"
     * <p>
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * <p>
     * "LCIRETOESIIGEDHN"
     * <p>
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     * <p>
     * "LDREOEIIECIHNTSG"
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows < 2){
            return s;
        }
        // 生成一个链表，存放numRows个字符串
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        // 通过 i 确定第几个字符串，通过flag确定其方向
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder row : rows) {
            System.out.println(row);
            stringBuilder.append(row);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 4;
        LeetCode6 leetCode6 = new LeetCode6();
        String convert = leetCode6.convert(s, numRows);
        System.out.println(convert);
    }
}
