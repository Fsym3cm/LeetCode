package com.chengzimm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution206 {

    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        //写递归一定要先写终止条件，不然会发生异常
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        //p = head.next 即head为最后一个节点的上一个节点
        System.out.println(head.val);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
public class LeetCode206 {
    public static void main(String[] args) {

    }
}
