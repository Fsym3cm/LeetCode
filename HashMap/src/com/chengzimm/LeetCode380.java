/*常数时间插入、删除和获取随机元素*/
package com.chengzimm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class RandomizedSet {
    /**insert(val)：当元素 val 不存在时，向集合中插入该项。
     * remove(val)：元素 val 存在时，从集合中移除该项。
     * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。*/
    /** Initialize your data structure here. */
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap();
        list = new ArrayList();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        map.put(val, list.size());
        //将指定的元素插入此列表中的指定位置（可选操作）。 将当前位于该位置的元素（如果有）和任何后续元素（向其索引添加一个）移动。
        list.add(list.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        // 将最后一个元素移到要删除的元素的位置idx
        int lastElement = list.get(list.size() - 1);
        int idx = map.get(val);
        list.set(idx, lastElement);
        map.put(lastElement, idx);
        // 删除最后一个元素
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

class RandomizedSet1 {
    HashMap<Integer,Integer> map;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet1() {
        map = new HashMap<Integer,Integer>();
        list = new ArrayList<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val,list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.remove(val);
            //使用min填充删除的位置
            list.set(index,Integer.MIN_VALUE);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rm = new Random();
        int i = rm.nextInt(list.size());
        //当获取的random为min时，则重新获取一个随机值
        while(list.get(i) == Integer.MIN_VALUE){
            i = rm.nextInt(list.size());
        }
        return list.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
public class LeetCode380 {
    public static void main(String[] args) {
        // 初始化一个空的集合。
        RandomizedSet randomSet = new RandomizedSet();
        // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        System.out.println(randomSet.insert(1));
        // 返回 false ，表示集合中不存在 2 。
        System.out.println(randomSet.remove(2));
        // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        System.out.println(randomSet.insert(2));
        // getRandom 应随机返回 1 或 2 。
        System.out.println(randomSet.getRandom());
        // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        System.out.println(randomSet.remove(1));
        // 2 已在集合中，所以返回 false 。
        System.out.println(randomSet.insert(2));
        // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
        System.out.println(randomSet.getRandom());
    }
}
