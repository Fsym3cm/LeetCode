/*合并两个有序链表*/
package com.chengzimm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution21 {
    /**1 -> 2 -> 4 ,
     * 1 -> 3 -> 4
     * 1 -> 1 -> 2 -> 3 -> 4 -> 4
     *如果l1 > l2则返回的l2为最终结果，反之，后面的返回值为连接线
     *返回值：每一层调用都返回排序好的链表头*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            //当l1为空时，返回排好序的l2链表                   l2
            return l2;
        }else if (l2 == null){
            //当l2为空时，返回排好序的l1链表                   l2->5
            return l1;
        }else if (l1.val < l2.val){
            //当l1 < l2时，将l1后面连接l2,同时l1往后引动一位 :  l2->3->4
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            //当l1 >= l2时，将l2后面连接l1,同时l2往后引动一位 ： 1->1->2
            l2.next = mergeTwoLists(l2, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }
}

public class LeetCode21 {
    public static void main(String[] args) {

    }
}
