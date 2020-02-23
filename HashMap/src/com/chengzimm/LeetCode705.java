/*设计哈希集合*/
package com.chengzimm;

/*哈希集合是集合数据结构的实现之一，用于存储非重复值*/
class MyHashSet {

    private int[] myHash;
    /** Initialize your data structure here. */
    public MyHashSet() {
        myHash = new int[1000000];
    }

    public void add(int key) {
        if (key != 0){
            myHash[key] = key;
        }else {
            //如果往索引为0的位置添加，则使其值为0与默认值相区别
            myHash[key] = -1;
        }
    }

    public void remove(int key) {
        myHash[key] = 0;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        //int[] 默认数字为0，所以要区分key是否为0的两种情况
        if (key != 0){
            //return myHash[key] == key; 下面的写法节省时间，当有值时即返回true
            return myHash[key] != 0;
        }else {
            return myHash[key] == -1;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

public class LeetCode705 {

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // 返回 true
        System.out.println(hashSet.contains(3));    // 返回 false (未找到)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // 返回 true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // 返回  false (已经被删除)
    }
}
