/**
 * 广度优先搜索（BFS）的一个常见应用是找出从根结点到目标结点的最短路径。*/
package com.chengzimm;

public class Queue_BFS {
    public static void main(String[] args) {
    /*    *//**
         * Return the length of the shortest path between root and target node.
         *//*
        int BFS(Node root, Node target) {
            Queue<Node> queue;  // store all nodes which are waiting to be processed
            int step = 0;       // number of steps neeeded from root to current node
            // initialize
            add root to queue;
            // BFS
            while (queue is not empty) {
                step = step + 1;
                // iterate the nodes which are already in the queue
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    Node cur = the first node in queue;
                    return step if cur is target;
                    for (Node next : the neighbors of cur) {
                        add next to queue;
                    }
                    remove the first node from queue;
                }
            }
            return -1;          // there is no path from root to target
        }*/

    /*    *//**
         * Return the length of the shortest path between root and target node.
         *//*
        int BFS(Node root, Node target) {
            Queue<Node> queue;  // store all nodes which are waiting to be processed
            Set<Node> used;     // store all the used nodes
            int step = 0;       // number of steps neeeded from root to current node
            // initialize
            add root to queue;
            add root to used;
            // BFS
            while (queue is not empty) {
                step = step + 1;
                // iterate the nodes which are already in the queue
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    Node cur = the first node in queue;
                    return step if cur is target;
                    for (Node next : the neighbors of cur) {
                        if (next is not in used) {
                            add next to queue;
                            add next to used;
                        }
                    }
                    remove the first node from queue;
                }
            }
            return -1;          // there is no path from root to target
        }*/
    }
}
