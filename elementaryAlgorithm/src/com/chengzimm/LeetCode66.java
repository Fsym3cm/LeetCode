package com.chengzimm;

/**
 * 加一
 *
 * @Author CM
 * @Date 2020/9/1 10:28
 */
public class LeetCode66 {

    /**
     * [1,2,3]
     */
    public int[] plusOne(int[] digits) {
        int carry  = 1;
        for (int i = digits.length - 1; i >= 0; i--){
            digits[i] = digits[i] + carry;
            if (digits[i] == 10){
                digits[i] = 0;
            }else {
                carry = 0;
            }
        }
        if (carry == 1){
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] num = {9,9};
        LeetCode66 leetCode66 = new LeetCode66();
        int[] ints = leetCode66.plusOne(num);
        for (int item : ints){
            System.out.print(item);
        }
    }
}
