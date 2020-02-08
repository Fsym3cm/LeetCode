package com.chengzimm;

public class DoublePointer {
    public static void reverse(int[] v, int N) {
        int i = 0;
        int j = N - 1;
        while (i < j) {
            //swap(v, i, j);  // this is a self-defined function
            i++;
            j--;
        }
    }

    //移除指定下标的元素
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int val = 1;
        DoublePointer doublePointer = new DoublePointer();
        int answer = doublePointer.removeElement(nums, val);
        System.out.println(answer);
    }


}
