/*设计循环队列*/
package com.chengzimm;

/**
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。*/
class MyCircularQueue {

    private int[] data;
    private int p_start;
    private int p_end;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        //预留一个空间区分队空队满
        data = new int[k + 1];
        System.out.println(data.length);
        p_start = 0;
        p_end = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()){
//            System.out.println(value);
            return false;
        }else {
//            System.out.println(value);
            data[p_end] = value;
            p_end = (p_end + 1) % data.length;
            System.out.print(p_start % data.length);
            System.out.println(p_end % data.length);
            System.out.print(data[0]);
            System.out.print(data[1]);
            System.out.print(data[2]);
            System.out.print(data[3]);
            return true;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty() ){
            return false;
        }else {
//            System.out.println(p_start);
//            System.out.println(p_end);
//            data[p_start] = 0;
            p_start = (p_start + 1) % data.length;
            return true;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()){
            return -1;
        }else {
            return data[p_start];
        }
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()){
            return -1;
        }else {
            return data[(p_end - 1 + data.length) % data.length];
        }
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if (p_start == p_end){
            return true;
        }else {
            return false;
        }
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if ((p_end + 1) % data.length == p_start){
            return true;
        }else {
            return false;
        }
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

public class LeetCode622 {
    public static void main(String[] args) {
        int k = 3, value = 1;
        MyCircularQueue mQue = new MyCircularQueue(k);

        boolean enQueue = mQue.enQueue(value);
        System.out.println(enQueue);
        boolean enQueue2 = mQue.enQueue(2);
        System.out.println(enQueue2);
        boolean enQueue3 = mQue.enQueue(3);
        System.out.println(enQueue3);
        boolean enQueue4 = mQue.enQueue(4);
        System.out.println(enQueue4);

        int rear = mQue.Rear();
        System.out.println("rear:" + rear);

        boolean full = mQue.isFull();
        System.out.println("isFull:" +full);

        boolean deQueue = mQue.deQueue();
        System.out.println("deQueue:" + deQueue);

        boolean enQueue5 = mQue.enQueue(4);
        System.out.println(enQueue5);

        int rear2 = mQue.Rear();
        System.out.println("rear2:" + rear2);

        int front = mQue.Front();
        System.out.println("front:" + front);

        boolean empty = mQue.isEmpty();
        System.out.println("isEmpty:" + empty);

/*        int k = 6, value = 6;
        MyCircularQueue mQue = new MyCircularQueue(k);

        boolean enQueue = mQue.enQueue(value);
        System.out.println(enQueue);

        int rear = mQue.Rear();
        System.out.println("rear:" + rear);

        int rear2 = mQue.Rear();
        System.out.println("rear2:" + rear2);

        boolean deQueue = mQue.deQueue();
        System.out.println("deQueue:" + deQueue);

        boolean enQueue2 = mQue.enQueue(5);
        System.out.println(enQueue2);

        int rear3 = mQue.Rear();
        System.out.println("rear3:" + rear3);

        boolean deQueue2 = mQue.deQueue();
        System.out.println("deQueue2:" + deQueue2);

        int front = mQue.Front();
        System.out.println("front:" + front);

        boolean deQueue3 = mQue.deQueue();
        System.out.println("deQueue3:" + deQueue3);

        boolean deQueue4 = mQue.deQueue();
        System.out.println("deQueue4:" + deQueue4);

        boolean deQueue5 = mQue.deQueue();
        System.out.println("deQueue5:" + deQueue5);*/

 /*       int k = 2, value = 4;
        MyCircularQueue mQue = new MyCircularQueue(k);

        boolean enQueue = mQue.enQueue(value);
        System.out.println("enQueue" +enQueue);

        int rear = mQue.Rear();
        System.out.println("rear:" + rear);

        boolean enQueue2 = mQue.enQueue(9);
        System.out.println("enQueue2" + enQueue2);

        boolean deQueue = mQue.deQueue();
        System.out.println("deQueue:" + deQueue);

        int front = mQue.Front();
        System.out.println("front:" + front);

        boolean deQueue2 = mQue.deQueue();
        System.out.println("deQueue2:" + deQueue2);

        boolean deQueue3 = mQue.deQueue();
        System.out.println("deQueue4:" + deQueue3);*/

   /*     int k = 4, value = 3;
        MyCircularQueue mQue = new MyCircularQueue(k);

        boolean enQueue = mQue.enQueue(value);
        System.out.println("enQueue" +enQueue);

        int front = mQue.Front();
        System.out.println("front:" + front);

        boolean full = mQue.isFull();
        System.out.println("isFull:" +full);

        boolean enQueue2 = mQue.enQueue(7);
        System.out.println(enQueue2);
        boolean enQueue3 = mQue.enQueue(2);
        System.out.println(enQueue3);
        boolean enQueue4 = mQue.enQueue(5);
        System.out.println(enQueue4);

        boolean deQueue = mQue.deQueue();
        System.out.println("deQueue:" + deQueue);

        boolean enQueue5 = mQue.enQueue(4);
        System.out.println(enQueue5);
        boolean enQueue6 = mQue.enQueue(2);
        System.out.println(enQueue6);

        boolean empty = mQue.isEmpty();
        System.out.println("isEmpty:" + empty);

        int rear = mQue.Rear();
        System.out.println("rear:" + rear);*/

    }
}
