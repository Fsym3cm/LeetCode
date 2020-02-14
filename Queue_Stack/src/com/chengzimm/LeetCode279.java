/**完全平方数
 * 转化为图的问题，*/
package com.chengzimm;

import java.util.*;

class Solution279 {
    //四方定理：任何一个 自然数都可以用至多 四个数的平方来表示。  那么这道题就是变成了判断到底是用几个数表示
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        if (check1(n)) {
            return 1;
        } else if (check2(n)) {
            return 2;
        } else if (check3(n)) {
            return 3;
        } else {
            return 4;
        }
    }

    public boolean check1(int n) {
        int tem = (int) Math.sqrt(n);
        return tem * tem == n;
    }

    public boolean check2(int n) {
        for (int i = 1; i * i < n; i++) {
            if (check1(n - i * i))
                return true;
        }
        return false;
    }

    public boolean check3(int n) {
        for (int i = 1; i * i < n; i++) {
            if (check2(n - i * i)) {
                return true;
            }
        }
        return false;
    }
/*变成图，使用bfs*/
    private class Node {
        int val;
        int step;

        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }

    public int numSquares2(int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 1));
        boolean used[] = new boolean[n];
        while (!queue.isEmpty()) {
            //使用BFS模板
 /*           int size = queue.size();
            for (int i = 0; i < size; i++) {*/
                Node cur = queue.poll();
                int val = cur.val;
                int step = cur.step;
                for (int j = 1; val - j * j >= 0; j++) {
                    int nextVal = val - j * j;
                    if (nextVal == 0) {
                        return step;
                    }
                    if (!used[nextVal]) {
                        queue.offer(new Node(nextVal, step + 1));
                        used[nextVal] = true;
                    }
                }
   /*         }*/
            //每一层顺序遍历，当nextVal<0时跳入下一层。
            /*Node cur = queue.poll();
            int val = cur.val;
            int step = cur.step;
            // 每一层的广度遍历
            for (int j = 1; ; j++) {
                int nextVal = val - j * j;
                // 说明已到最大平方数
                if (nextVal < 0) {
                    break;
                }
                // 由于是广度遍历，所以当遍历到0时，肯定是最短路径
                if (nextVal == 0) {
                    return step;
                }
                // 当再次出现时没有必要加入，因为在该节点的路径长度肯定不小于第一次出现的路径长
                if (!used[nextVal]) {
                    queue.offer(new Node(nextVal, step + 1));
                    used[nextVal] = true;
                }
            }*/
        }
        return -1;
    }

    //不使用Node
    public int numSquares3(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean used[] = new boolean[n];
        queue.offer(n);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1; cur - j * j >= 0; j++) {
                    int nextVal = cur - j * j;
                    if (nextVal == 0) {
                        return step;
                    }
                    if (!used[nextVal]) {
                        queue.offer(nextVal);
                        used[nextVal] = true;
                    }
                }
            }
        }
        return -1;
    }

}


public class LeetCode279 {
    public static void main(String[] args) {
        int n = 13;
        Solution279 solution = new Solution279();
        int answer = solution.numSquares2(n);
        System.out.println(answer);
    }
}
