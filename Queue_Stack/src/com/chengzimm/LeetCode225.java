/*用队列实现栈*/
package com.chengzimm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class MyStack225 {

    private Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack225() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //将队列反转为栈的形式
        int size = queue.size();
        for (int i = size; i > 1; i--){
            queue.add(queue.poll());
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        int temp = pop();
        // 放回队列
        queue.add(temp);
        return temp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
public class LeetCode225 {
    public static void main(String[] args) {
        MyStack225 myStack = new MyStack225();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.empty());
    }
}
