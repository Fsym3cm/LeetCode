/*打开转盘锁*/
package com.chengzimm;

import java.util.*;

/**
 * offer，add区别：
 * 一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。
 * 这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。 
 *
 * poll，remove区别：
 * remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似，
 * 但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。
 *
 * peek，element区别：
 * element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null
 * */
class Solution752 {
    public int openLock(String[] deadends, String target) {
        if(target == null || target.length() == 0){
            return -1;
        }

        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        String start="0000";

        if(deads.contains(target) || deads.contains(start)){
            return -1;
        }

        Queue<String> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        que.offer(start);
        visited.add(start);
        int step = 0;
        while(!que.isEmpty()){
            //因为que.size的长度不为定值所以复制给size
            int size = que.size();
            for(int i = 0; i < size; i++){
                //peek返回队列第一个元素但是不删除
                String cur = que.poll();
                //equals: 需要队列删除的只剩target元素
                //contains: 当队列里有target元素时则返回step，而且不影响step正确性。
                if(cur.contains(target)){// 找到了目标返回步骤数
                    return step;
                }
                //得到其后面所有可能的值
                List<String> nexts = getNexts(cur);
                for(String str : nexts){
                    //如果不为deads且不在visited中的值则添加到que队列和visited集合中
                    if(!deads.contains(str) && !visited.contains(str)){
                        que.offer(str);
                        visited.add(str);
                    }
                }
            }
            //每遍历完一层，step加一
            step++;
        }
        return -1;
    }

    // 获得当前值转动一位可以转动到的所有情况
    private List<String> getNexts(String cur){
        List<String> list=new ArrayList<>();
        //四个轮盘，遍历四遍
        for(int i = 0; i < 4; i++){
            StringBuilder curBuilder = new StringBuilder(cur);
            char modChar = cur.charAt(i);
            //转盘向下转动
            curBuilder.setCharAt(i, modChar == '0' ? '9' : (char)(modChar - 1));
            list.add(curBuilder.toString());
            //转盘向上转动
            curBuilder.setCharAt(i, modChar == '9' ? '0' : (char)(modChar + 1));
            list.add(curBuilder.toString());
        }
        return list;
    }
}

/*["0201","0101","0102","1212","2002"]
"0202"*/
public class LeetCode752 {
    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        Solution752 solution = new Solution752();
        int answer = solution.openLock(deadends, target);
        System.out.println(answer);
    }
}
