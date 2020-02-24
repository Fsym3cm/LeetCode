/*两个列表的最小索引总和*/
package com.chengzimm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++){
            for (int j = 0; j < list2.length; j++){
                 if (list1[i].equals(list2[j])){
                     if (!map.containsKey(i + j)){
                         map.put(i + j, new ArrayList<>());
                     }
                     map.get(i + j).add(list1[i]);
                 }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int key : map.keySet()){
            if (key < min){
                min = key;
            }
        }
        System.out.println(min);
        String[] res = new String[map.get(min).size()];
        return map.get(min).toArray(res);
    }

    /**   使用哈希表（线性）
     * 使用hashMap 存储list1<数值,索引>, 然后遍历list2 并判断相同的名称的索引值大小,取最小的集合装进res*/
    public String[] findRestaurant2(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        //目标集合
        List<String> res = new ArrayList <> ();
        int min = Integer.MAX_VALUE, sum;

        //j <= min : 减少运行次数
        for (int j = 0; j < list2.length && j <= min; j++) {
            if (map.containsKey(list2[j])) {
                //map.get(list2[j]) : 得到map中list1相同元素的位置
                sum = j + map.get(list2[j]);
                //集合交集只有最小值
                if (sum < min) {
                    //清除之前保存的最小值
                    res.clear();
                    res.add(list2[j]);
                    min = sum;
                } else if (sum == min)
                    //集合交集有多个值
                    res.add(list2[j]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}

public class LeetCode599 {
    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Burger King", "Tapioca Express", "Shogun"};
        Solution599 solution = new Solution599();
        String[] restaurant = solution.findRestaurant2(list1, list2);
        for (String str : restaurant){
            System.out.println(str);
        }
    }
}
