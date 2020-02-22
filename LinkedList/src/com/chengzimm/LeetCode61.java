/*旋转链表*/
package com.chengzimm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution61 {

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
    /*1 -> 2 -> 3 -> 4 -> 5*/
    public ListNode rotateRight(ListNode head, int k) {
        ListNode cur = head;
        int size = 1;
        while (cur.next != null){
            cur = cur.next;
            size++;
        }
        //最后一位数连接头 5 -> 1
        cur.next = head;
        k = size - k % size;
        for (int i = 0; i < k; i++){
            //在头后遍历添加size - k % size个数,到达新头前停 ，3
            cur = cur.next;
        }
        //把停的位置的数最为新的头   4作为头
        head = cur.next;
        //断开环的连接   3 -> 4
        cur.next = null;
        return head;
    }
}

public class LeetCode61 {
    public static void main(String[] args) {

    }
}
