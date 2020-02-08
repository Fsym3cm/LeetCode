/*加一*/
package com.chengzimm;

import static java.lang.Math.log10;

class Solution66 {
    public int[] plusOne(int[] digits) {
        //从最右边开始遍历（个位）
        for (int i = digits.length-1; i >= 0; i--) {
            //加1
            digits[i]++;
            //得到余数（当前位的数字）
            digits[i] %= 10;
            //如果不为0则直接输出数字，如果为0则继续遍历
            if (digits[i] != 0)
                return digits;
        }
        //如果遍历完成（说明为9,99，这类数字）则将digits数组增长一位，并令第一位为0
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
class Solu2 {
    public int[] plusOne(int[] digits) {
        double sum = 0, tem = 0;
        //翻转数组
        for (int i=0; i<digits.length/2; i++){
            int temp = digits[i];
            digits[i] = digits[digits.length-1-i];
            digits[digits.length-1-i] = temp;
        }
        for (int i=0; i<digits.length; i++){
            int num = (int) (digits[i]* Math.pow(10,i));
            sum += num;
        }
        sum = sum + 1;
        //求该数字的位数
        int[] dig = new int[(int)log10(sum)+1];
        int i = 0;
        while (sum != 0){
            tem = sum % 10;
            sum /= 10;
            dig[dig.length-1-i] = (int) tem;
            i ++;
        }
        return dig;
    }
}
public class LeetCode66 {
    public static void main(String[] args) {
        int[] digits={9};
        Solution66 solution = new Solution66();
        int[] ans = solution.plusOne(digits);
        for (int item : ans){
            System.out.print(item);
        }
    }
}
