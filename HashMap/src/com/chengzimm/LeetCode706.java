/*设计哈希映射*/
package com.chengzimm;

/*哈希映射是映射 数据结构的实现之一，用于存储(key, value)键值对*/
class MyHashMap {

    private int[] myHash;
    /** Initialize your data structure here. */
    public MyHashMap() {
        myHash = new int[1000000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        if (value == 0){
            myHash[key] = -1;
        }else {
            myHash[key] = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (myHash[key] == 0) return -1;
        if (myHash[key] == -1) return 0;
        return myHash[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        myHash[key] = 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

public class LeetCode706 {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));            // 返回 1
        System.out.println(hashMap.get(3));            // 返回 -1 (未找到)
        hashMap.put(2, 0);         // 更新已有的值
        System.out.println(hashMap.get(2));            // 返回 1
       hashMap.remove(2);         // 删除键为2的数据
        System.out.println(hashMap.get(2));            // 返回 -1 (未找到)
    }
}
