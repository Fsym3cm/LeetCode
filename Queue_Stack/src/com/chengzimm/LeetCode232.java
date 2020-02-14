/*  用栈实现队列*/
package com.chengzimm;

import java.util.Stack;

class MyQueue232 {
    private Stack<Integer> stack;
    /** Initialize your data structure here. */
    public MyQueue232() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int temp = stack.firstElement();
        stack.remove(stack.firstElement());
        return temp;
    }

    /** Get the front element. */
    public int peek() {
        return stack.firstElement();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class LeetCode232 {
    public static void main(String[] args) {
        MyQueue232 queue = new MyQueue232();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());  // 返回 1
        System.out.println(queue.pop());   // 返回 1
        System.out.println(queue.peek());  // 返回 2
        System.out.println(queue.pop());   // 返回 2
        System.out.println(queue.peek());  // 返回 3
        System.out.println(queue.empty()); // 返回 false
    }
}
