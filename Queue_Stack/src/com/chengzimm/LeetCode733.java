/*图像渲染*/
package com.chengzimm;

import java.util.LinkedList;
import java.util.Queue;

class Solution733 {
    /**
     * 1 1 1
     * 1 1 0
     * 1 0 1
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        for (int[] items : image) {
            for (int item : items) {
                System.out.print(item);
            }
            System.out.println();
        }
//        bfs(image, sr, sc, newColor);
        int color = image[sr][sc];
        if (color != newColor) dfs2(image, sr, sc, color, newColor);
        return image;
    }

    public void bfs(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> queue = new LinkedList<>();
        int temp = image[sr][sc];
        if (temp != newColor) {
            queue.offer(new int[]{sr, sc});
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                sr = cur[0];
                sc = cur[1];
                /*判断条件应该为当前遍历的点的情况*/
                if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == temp) {
                    image[sr][sc] = newColor;
                    queue.add(new int[]{sr - 1, sc});
                    queue.add(new int[]{sr + 1, sc});
                    queue.add(new int[]{sr, sc - 1});
                    queue.add(new int[]{sr, sc + 1});
                }
            }
        }
    }

    public void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        if (image[sr][sc] == color) {
            image[sr][sc] = newColor;
            if (sr >= 1) dfs(image, sr - 1, sc, color, newColor);
            if (sc >= 1) dfs(image, sr, sc - 1, color, newColor);
            if (sr + 1 < image.length) dfs(image, sr + 1, sc, color, newColor);
            if (sc + 1 < image[0].length) dfs(image, sr, sc + 1, color, newColor);
//            if (sr > 0 && sr + 1 < image.length && sc > 0 && sc + 1 < image[0].length) {
//                dfs(image, sr - 1, sc, color, newColor);
//                dfs(image, sr + 1, sc, color, newColor);
//                dfs(image, sr, sc - 1, color, newColor);
//                dfs(image, sr, sc + 1, color, newColor);
//            }
        }
    }

    public void dfs2(int[][] image, int sr, int sc, int color, int newColor) {
        /**与岛屿问题的不同是，其周围没有0作为停止标识符，如果写符合条件则操作的话则会发生溢出，改对时则，周围一圈无法进行操作
         *所以反着写条件，当不符合条件则break；符合条件则进行操作，
         *要给dfs一个原来的颜色用来比对其是否需要进行操作*/
        if (sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0 || image[sr][sc] != color) {
            return;
        }
        image[sr][sc] = newColor;
        dfs2(image, sr - 1, sc, color, newColor);
        dfs2(image, sr + 1, sc, color, newColor);
        dfs2(image, sr, sc - 1, color, newColor);
        dfs2(image, sr, sc + 1, color, newColor);
    }

}
public class LeetCode733 {
    public static void main(String[] args) {
        //{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}
        //{0, 0, 0}, {0, 1, 1}
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        Solution733 solution = new Solution733();
        int[][] answer = solution.floodFill(image, sr, sc, newColor);
        for (int[] items : answer){
            for (int item : items){
                System.out.print(item);
            }
            System.out.println();
        }
    }
}
