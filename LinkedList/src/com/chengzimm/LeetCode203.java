/*移除链表元素*/
package com.chengzimm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution203 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        while (head != null && head.val == val){
            head = head.next;
        }
        ListNode pre = head;
        while (pre.next != null){
            if (pre.next.val == val){
                pre.next = pre.next.next;
            }else {
                pre = pre.next;
            }
        }
        return head;
    }

    //使用一个哨兵节点
    public ListNode removeElements2(ListNode head, int val) {
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode pre = p;
        while (pre.next != null){
            if (pre.next.val == val){
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return p.next;
    }
}

public class LeetCode203 {
    public static void main(String[] args) {

    }
}
