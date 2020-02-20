package com.chengzimm;

/**
 * 在调用 next 字段之前，始终检查节点是否为空。
 * 获取空节点的下一个节点将导致空指针错误。例如，在我们运行 fast = fast.next.next 之前，需要检查 fast 和 fast.next 不为空。
 *
 * 仔细定义循环的结束条件。*/
public class DoublePointers {
    public static void main(String[] args) {
        /*// Initialize slow & fast pointers
        ListNode slow = head;
        ListNode fast = head;
*//**
 * Change this condition to fit specific problem.
 * Attention: remember to avoid null-pointer error
 **//*
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;           // move slow pointer one step each time
            fast = fast.next.next;      // move fast pointer two steps each time
            if (slow == fast) {         // change this condition to fit specific problem
                return true;
            }
        }
        return false;   // change return value to fit specific problem*/
    }
}
