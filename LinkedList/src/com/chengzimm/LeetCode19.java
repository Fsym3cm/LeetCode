/*删除链表的倒数第N个节点*/
package com.chengzimm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution19 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode cur = head;
        while (cur.next != null){
            size++;
            cur = cur.next;
        }
        ListNode p = head;
        if (size + 1 == n){
            return head.next;
        }
        for (int i = 0; i < size - n; i++){
            p = p.next;
        }

        p.next = p.next.next;
        return head;
    }

    /**
     * 第一个指针从列表的开头向前移动 n+1 步，而第二个指针将从列表的开头出发。现在，这两个指针被 n 个结点分开。
     * 我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。
     * 此时第二个指针将指向从最后一个结点数起的第 n 个结点。
     * 我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
     **/
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // 前进第一个指针，以使第一个和第二个之间的间隔相隔n个节点
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // 首先移动到最后，保持差距
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        //如果返回head则要进行是否为空的判断。
        return dummy.next;
    }
}
public class LeetCode19 {
    public static void main(String[] args) {

    }
}
