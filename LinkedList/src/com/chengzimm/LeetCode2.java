/*两数相加*/
package com.chengzimm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution2 {

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode cur = p;
        int carry = 0;
        while (l1 != null || l2 != null){
            if (l1 == null){
                int sum = carry + l2.val;
                carry = sum / 10;
                sum = sum % 10;
                cur.next = new ListNode(sum);
                l2 = l2.next;
                cur = cur.next;
                if (carry == 1){
                    cur.next = new ListNode(1);
                }
            }else if (l2 == null){
                int sum = carry + l1.val;
                carry = sum / 10;
                sum = sum % 10;
                cur.next = new ListNode(sum);
                l1 = l1.next;
                cur = cur.next;
                if (carry == 1){
                    cur.next = new ListNode(1);
                }
            }else {
                // System.out.println(l1.val);
                // System.out.println(l2.val);
                //加法运算套路，进位等于sum/10，余数为sum%10。
                int sum = carry + l1.val + l2.val;
                carry = sum / 10;
                sum = sum % 10;
                cur.next = new ListNode(sum);
                l1 = l1.next;
                l2 = l2.next;
                cur = cur.next;
                if (carry == 1){
                    cur.next = new ListNode(1);
                }
            }
        }
        return p.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode cur = p;
        int carry = 0;
        while (l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = carry + x + y;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
            cur = cur.next;
            if (carry == 1){
                cur.next = new ListNode(1);
            }
        }
        return p.next;
    }
}
public class LeetCode2 {
    public static void main(String[] args) {

    }
}
