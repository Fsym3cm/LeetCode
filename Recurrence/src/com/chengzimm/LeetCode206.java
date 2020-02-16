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
    /**1->2->3->4->5->NULL
     * 5->4->3->2->1->NULL
     * */
    public ListNode reverseList(ListNode head) {
        return new ListNode(1);
    }
}
public class LeetCode206 {
    public static void main(String[] args) {
        ListNode head = null;
        Solution206 solution = new Solution206();
        solution.reverseList(head);
    }
}
