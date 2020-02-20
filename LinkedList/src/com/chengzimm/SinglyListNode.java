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
 *                  cur = head;
 *  在结尾添加结点：  pre -> end   添加cur节点到end后
 *                  cur = node;
 *                  end.next = cur;
 *
 * 单链表删除节点：
 *   在给定的结点 prev 之后删除当前节点：  pre -> cur -> next -> ?   删除cur节点
 *                                      pre.next = pre.next.next
 *   删除第一个结点：    head -> ?    删除head节点
 *                     head = head.next;
 *   删除最后一个节点：  pre -> end         删除end节点
 *                     pre.next = null
 *
 * 链表小结
 * 1. 通过一些测试用例可以节省您的时间。
 * 使用链表时不易调试。因此，在编写代码之前，自己尝试几个不同的示例来验证您的算法总是很有用的。

 * 2. 你可以同时使用多个指针。
 * 有时，当你为链表问题设计算法时，可能需要同时跟踪多个结点。您应该记住需要跟踪哪些结点，并且可以自由地使用几个不同的结点指针来同时跟踪这些结点。
 * 如果你使用多个指针，最好为它们指定适当的名称，以防将来必须调试或检查代码。
 *
 * 3. 在许多情况下，你需要跟踪当前结点的前一个结点。
 * 你无法追溯单链表中的前一个结点。因此，您不仅要存储当前结点，还要存储前一个结点。*/
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

