/*扁平化多级双向链表*/
package com.chengzimm;

import java.util.ArrayDeque;
import java.util.Deque;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution430 {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        public Node(int i, Node o, Node head, Node o1) {
            this.val = i;
            this.prev = o;
            this.next = head;
            this.child = o1;
        }
    };

    public Node flatten(Node head) {
        if (head == null) return head;

        Node p = new Node(0, null, head, null);
        Node pre = p;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            pre.next = cur;
            cur.prev = pre;

            if (cur.next != null) stack.push(cur.next);
            if (cur.child != null) {
                stack.push(cur.child);
                // don't forget to remove all child pointers.
                cur.child = null;
            }
            pre = cur;
        }
        // 头节点的prev需要置空，否则会提示结果非双向链表
        p.next.prev = null;
        return p.next;
    }

    /*将 child 指针当作二叉树中指向左子树的 left 指针。
    同样，next 指针可以当作是二叉树中的 right 指针。然后我们深度优先搜索树将得到答案。*/
    /**
     * 全局变量prev 指当前指针的前一位
     * 递归过程中，递归到底部后，将head节点插入到之前的prev节点的前面*/
    Node prev = null;
    public Node flatten2(Node head) {
        prev = new Node(0,null,null,null);
        helper(head);
        return prev.next;
    }

    public void helper(Node head){
        if(head==null) return ;
        helper(head.next);
        helper(head.child);
        head.child = null;

        Node next = prev.next;
        prev.next = head;
        head.next = next;
        if(next != null)
            next.prev = head;
    }
}
public class LeetCode430 {
    public static void main(String[] args) {

    }
}
