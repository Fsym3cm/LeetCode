/*两两交换链表中的节点*/
package com.chengzimm;

  //Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution24 {
      /**1 -> 2 -> 3 ->4
       * first.next <-> first.next.next
       * */
    public ListNode swapPairs(ListNode head) {
        //head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换
        if (head == null || head.next == null){
            return head;
        }
        ListNode temp = head.next;
        //设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
        head.next = swapPairs(temp.next);
        temp.next = head;
        return head;
    }
}
public class LeetCode24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Solution24 solution = new Solution24();
        solution.swapPairs(head);
    }
}
