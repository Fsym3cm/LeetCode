package com.chengzimm;

import sun.applet.Main;

/**
 * 寻找两个正序数组的中位数
 *
 * @author CM
 * @date 2020/9/9 10:08
 */
public class LeetCode4 {

    /**
     *
     * 合并数组，找出中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];

        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            // 当i == m时，说明nums1放入完毕，将剩余的num2放入总数组中
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }
        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }



    public static void main(String[] args) {
        int[] nums1 = {1, 2, 7};
        int[] nums2 = {4, 5, 6};
        LeetCode4 leetCode4 = new LeetCode4();
        double medianSortedArrays = leetCode4.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}
