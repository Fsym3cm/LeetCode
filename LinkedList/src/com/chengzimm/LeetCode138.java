/*复制带随机指针的链表*/
package com.chengzimm;

import java.util.HashMap;
import java.util.Map;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node o, Node o1) {
            this.val = val;
            this.next = o;
            this.random = o1;
        }
    }

    HashMap<Node, Node> used = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //如果我们已经处理了当前节点，则只需返回它的克隆版本
        if (used.containsKey(head)) {
            return used.get(head);
        }
        //创建一个值与旧节点相同的新节点。 （即复制节点）
        Node node = new Node(head.val, null, null);
        //将此值保存在哈希图中。这是必需的，因为遍历期间由于随机指针的随机性可能会出现循环，这将有助于我们避免它们。
        used.put(head, node);
        //从下一个指针开始递归复制其余的链表，然后从随机指针开始,因此，我们有两个独立的递归调用。
        //最后，我们为创建的新节点更新下一个和随机指针
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }

    public Node copyRandomList2(Node head) {
        if(head==null) return null;
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);

    }

    public Node copyRandomList3(Node head) {
        if(head==null){
            return null;
        }
        Node cur = head;
        Node next = null;
        //复制新链表，只复制next指针，不复制random指针
        while(cur!=null){
            next = cur.next;
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = next;
        }
        cur = head;
        //复制random指针
        while(cur!=null){
            next = cur.next.next;
            cur.next.random = cur.random != null?cur.random.next:null;
            cur = next;
        }
        //把复制链表和源链表分开
        cur = head;
        Node newHead = cur.next;
        Node copyCur = null;
        while(cur!=null){
            //record the next node
            next = cur.next.next;
            copyCur = cur.next;
            cur.next = next;
            copyCur.next = next!=null?next.next:null;
            cur = next;
        }
        return newHead;
    }
}
public class LeetCode138 {
    public static void main(String[] args) {
        Solution138 solution = new Solution138();

    }
}
