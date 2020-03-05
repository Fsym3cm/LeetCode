/* 填充每个节点的下一个右侧节点指针*/
package com.chengzimm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Node cur = queue.poll();
                //当队列中的数大于或等于2时，连接最后进入的数即为右边的数
                if (i < size - 1){
                    cur.next = queue.peek();
                }
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return root;
    }

    public Node connect2(Node root) {
        if(root == null) return root;
        Node leftmost = root;
        while(leftmost.left != null){
            Node head = leftmost;
            while (head != null){
                //第一种连接(第一种情况两个子节点属于同一个父节点，因此直接通过父节点建立两个子节点的 next 指针即可。)
                head.left.next = head.right;
                //第二种链接(第二种情况是连接不同父节点之间子节点的情况。更具体地说，连接的是第一个父节点的右孩子和第二父节点的左孩子。
                // 由于已经在父节点这一层建立了 next 指针，因此可以直接通过第一个父节点的 next 指针找到第二个父节点，
                // 然后在它们的孩子之间建立连接。)
                if (head.next != null) head.right.next = head.next.left;
                head = head.next;
            }
            leftmost = leftmost.left; //挪到下一层
        }
        return root;
    }
}
public class LeetCode116 {
    public static void main(String[] args) {

    }
}
