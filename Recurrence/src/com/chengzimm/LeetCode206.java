/*反转链表*/
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
     * 递归解法*/
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //cur节点即为尾结点，head节点即为cur的上一个: 5 -> null
        ListNode cur = reverseList(head.next);
        //尾结点的next指向head: 5 -> 4
        head.next.next = head;
        //将head的下一个链接断开: 4 -> null
        head.next = null;
        //返回尾结点
        return cur;
    }
    //迭代解法
    private ListNode reverseList2(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null){
            //当前节点的后一个节点：1.next
            temp = cur.next;
            //cur节点的next指向pre：1 -> null
            cur.next = pre;
            //将其整体往后移一位
            //将cur赋给上一个节点：null -> 1
            pre = cur;
            //将当前节点的后一个节点赋给当前节: 1 -> 1.next
            cur = temp;
            System.out.println(head.next.next);
        }
        return pre;
    }
}
public class LeetCode206 {
    public static void main(String[] args) {
        ListNode head = null;
        Solution206 solution = new Solution206();
        solution.reverseList(head);
    }
}
