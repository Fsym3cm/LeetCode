package com.chengzimm;

/**
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * 添加元素 index可以为size(在链表最后添加一段)，删除元素不可以为size(最多删除size - 1位置的元素)*/
/** Initialize your data structure here. */
class MyLinkedList {
    /**       0 -> 1 -> 2 -> ?
     * index:      0    1
     * */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    int size;
    ListNode head;  // 前哨节点为伪头
    public MyLinkedList() {
        //虚拟头结点
        size = 0;
        head = new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size){
            return -1;
        }else{
            ListNode cur = head;
            for (int i = 0; i < index + 1; i++){
                cur = cur.next;
            }
            return cur.val;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public boolean addAtIndex(int index, int val) {
        //当索引大于长度时，不能添加元素 (范围在0--index之间都可以添加元素)
        if (index > size) return false;

        if (index < 0) index = 0;
        // 查找要添加的节点的前身
        ListNode pre = head;
        for(int i = 0; i < index; i++){
            pre = pre.next;
        }
        ListNode cur = new ListNode(val);
        cur.next = pre.next;
        pre.next = cur;
        size++;
        return true;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public boolean deleteAtIndex(int index) {
        if (index < 0 || index >= size ) return false;

        ListNode pre = head;
        for(int i = 0; i < index; i++){
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
        return true;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
public class LeetCode707 {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        System.out.println(linkedList.addAtIndex(2, 2));//链表变为1-> 3-> 2
        System.out.println(linkedList.get(1));            //返回3
        System.out.println(linkedList.deleteAtIndex(3));  //现在链表是1-> 3
        System.out.println(linkedList.get(1));            //返回3
        System.out.println(linkedList.head.val);
    }
}
