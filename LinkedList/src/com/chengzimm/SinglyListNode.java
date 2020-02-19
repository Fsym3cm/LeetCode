package com.chengzimm;


/**
 * 单链表添加节点：
 *  在给定的结点 prev 之后添加新值：  pre -> next -> ?    添加cur节点到pre后
 *                                 cur = node;
 *                                 cur.next = pre.next;
 *                                 pre.next = cur;
 *  在开头添加结点：  head -> ?    添加cur节点到head前
 *                  cur = node;
 *                  cur.next = head;
 *                  head = cur;
 *  在结尾添加结点：  pre -> end   添加cur节点到end后
 *                  cur = node;
 *                  end.next = cur;
 *
 * 单链表删除节点：
 *   在给定的结点 prev 之后删除当前节点：  pre -> cur -> next -> ?   删除cur节点
 *                                      pre.next = pre.next.next
 *   删除第一个结点：    head -> next -> ?    删除head节点
 *                     head.next = null;
 *                     head = next;
 *   删除最后一个节点：  pre -> end         删除end节点
 *                     pre.next = null
 *                   */
// Definition for singly-linked list.
public class SinglyListNode {
    int val;
    SinglyListNode next;

    SinglyListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        // write your code here
    }
}

