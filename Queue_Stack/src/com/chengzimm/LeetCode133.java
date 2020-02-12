/*克隆图*/
package com.chengzimm;

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int val, int i) {
        this.val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution133 {
    //bfs
   /* public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Node> map = new HashMap<>();
        queue.offer(node);
        //先生成第一个节点
        Node n = new Node();
        n.val = node.val;
        n.neighbors = new ArrayList<Node>();
        map.put(n.val, n);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node temp : cur.neighbors) {
                //没有生成的节点就生成
                if (!map.containsKey(temp.val)) {
                    n = new Node();
                    n.val = temp.val;
                    n.neighbors = new ArrayList<Node>();
                    map.put(n.val, n);
                    queue.offer(temp);
                }
                map.get(cur.val).neighbors.add(map.get(temp.val));
            }
        }
        return map.get(node.val);
    }*/
   //dfs
      /*public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Map<Integer, Node> map = new HashMap<>();
        return cloneGrapthHelper(node, map);
    }

    private Node cloneGrapthHelper(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        //生成当前节点
        Node n = new Node();
        n.val = node.val;
        n.neighbors = new ArrayList<Node>();
        map.put(node.val, n);
        //添加它的所有邻居节点
        for (Node temp : node.neighbors) {
            n.neighbors.add(cloneGrapthHelper(temp, map));
        }
        return n;
    }*/
}

public class LeetCode133 {
    public static void main(String[] args) { //{{2, 4},{1, 3},{2, 4},{1, 3}}
        ArrayList<Node> nodeList1 = new ArrayList<>();
        nodeList1.add(new Node(2,4));
        Node node1 = new Node(1, new ArrayList<>());

        ArrayList<Node> nodeList2 = new ArrayList<>();
        nodeList2.add(new Node(1,3));
        Node node2 = new Node(2, new ArrayList<>());

        ArrayList<Node> nodeList3 = new ArrayList<>();
        nodeList3.add(new Node(2,4));
        Node node3 = new Node(3, new ArrayList<>());

        ArrayList<Node> nodeList4 = new ArrayList<>();
        nodeList4.add(new Node(1,3));
        Node node4 = new Node(4, new ArrayList<>());

        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        Node node = new Node(0,nodes);
        Solution133 solution = new Solution133();
        /*Node answer = solution.cloneGraph(node);
        System.out.println(answer);*/
    }
}
