/*钥匙和房间*/
package com.chengzimm;

import java.util.*;

class Solution841 {
    /**   [[1],[2],[3],[]]
     *     1 -> 2 -> 3
     *    [[1,3],[3,0,1],[2],[0]]
     *               3
     *          1 -> 0
     *    0 ->       1
     *          3 -> 2
     *        */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> used = new HashSet<>();
        queue.offer(0);
        used.add(0);
        while (!queue.isEmpty()){
            int size = queue.size();
            //这个for循环可以不写（因为不求最短路径step）。
            for (int i = 0; i < size; i++){
                int cur = queue.poll();
                List<Integer> keys = rooms.get(cur);
                System.out.println(keys);
                for (int key : keys){
                    System.out.println(key);
                    if (!used.contains(key)){
                        queue.offer(key);
                        used.add(key);
                    }
                }
            }
        }
        return used.size() == rooms.size();
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        Set<Integer> used = new HashSet<>();
        used.add(0);
        dfs(rooms, 0, used);
        return used.size() == rooms.size();
    }
    public void dfs(List<List<Integer>> rooms, int cur, Set<Integer> used){
        List<Integer> keys = rooms.get(cur);
        for (int key : keys) {
            if (!used.contains(key)) {
                used.add(key);
                dfs(rooms, key, used);
            }
        }
    }
}
public class LeetCode841 {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>();
        room1.add(1);
        List<Integer> room2 = new ArrayList<>();
        room2.add(2);
        List<Integer> room3 = new ArrayList<>();
        room3.add(3);
        List<Integer> room4 = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        Solution841 solution = new Solution841();
        boolean answer = solution.canVisitAllRooms2(rooms);
        System.out.println(answer);
    }
}
