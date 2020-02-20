/*奇偶链表*/
package com.chengzimm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution328 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode oddEvenList(ListNode head) {
        //evenHead:记录even链表的头结点的位置（even会变化）
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null){
            //下一个奇数位置的值
            odd.next = even.next;
            odd = odd.next;
            //下一个偶数位置的值
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

public class LeetCode328 {
    public static void main(String[] args) {

    }
}
