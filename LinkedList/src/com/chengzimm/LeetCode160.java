/*相交链表*/
package com.chengzimm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution160 {

    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
   /**
    * 让两个链表从同距离末尾同等距离的位置开始遍历。这个位置只能是较短链表的头结点位置。
    * 为此，我们必须消除两个链表的长度差
    *
    * 指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
    * 如果 pA 到了末尾，则 pA = headB 继续遍历
    * 如果 pB 到了末尾，则 pB = headA 继续遍历
    * 比较长的链表指针指向较短链表head时，长度差就消除了
    * 如此，只需要将最短链表遍历两次即可找到位置
    **/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}

public class LeetCode160 {
    public static void main(String[] args) {
        Solution160 solution = new Solution160();
    }
}
