/*最小栈*/
package com.chengzimm;

import java.util.*;

/**push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。*/
class MinStack {

    private List<Integer> data; // store elements
    private int min = Integer.MAX_VALUE;
    //构造函数应该名字与类名相同
    public MinStack() {
        data = new ArrayList<>();
    }

    public void push(int x) {
        if (x < min){
            min = x;
        }
        data.add(x);
    }

    public void pop() {
        if(min == top()){
            min = Integer.MAX_VALUE;
            for(int i = 0; i < data.size() - 1; i++){
                if(data.get(i) < min){
                    min = data.get(i);
                }
            }
        }
        if(data.size()!=0){
            data.remove(data.size() - 1);
        }
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() {
        /*if (data.size() != 0){
            System.out.println(data);
            int[] temp = new int[data.size()];
            for (int i = 0; i < data.size(); i++){
                temp[i] = data.get(i);
            }
            Arrays.sort(temp);
            return temp[0];
        }
        return -1;*/
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class LeetCode155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        minStack.top();
        int min1 = minStack.getMin();
        System.out.println(min1);
    }
}
