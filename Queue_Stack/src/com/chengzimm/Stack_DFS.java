/**在大多数情况下，我们在能使用 BFS 时也可以使用 DFS。但是有一个重要的区别：遍历顺序。
 * 与 BFS 不同，更早访问的结点可能不是更靠近根结点的结点。
 * 因此，你在 DFS 中找到的第一条路径可能不是最短路径。*/
package com.chengzimm;

public class Stack_DFS {
    public static void main(String[] args) {

         //Return true if there is a path from cur to target.
         //如果存在从cur到目标的路径，则返回true
         /*
        boolean DFS(Node cur, Node target, Set<Node> visited) {
            return true if cur is target;
            for (next : each neighbor of cur) {
                if (next is not in visited) {
                    add next to visted;
                    return true if DFS(next, target, visited) == true;
                }
            }
            return false;
        }*/

        /*
         * Return true if there is a path from cur to target.
         */
       /* boolean DFS(int root, int target) {
            Set<Node> visited;
            Stack<Node> s;
            add root to s;
            while (s is not empty) {
                Node cur = the top element in s;
                return true if cur is target;
                for (Node next : the neighbors of cur) {
                    if (next is not in visited) {
                        add next to s;
                        add next to visited;
                    }
                }
                remove cur from s;
            }
            return false;
        }*/
    }
}
