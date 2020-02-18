/*二叉树的最大深度*/
package com.chengzimm;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


// Definition for a binary tree node.
/*public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }*/
class Solution104 {
    /*public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int depth){
        if (root == null){
            return depth;
        }
        int left = helper(root.left, depth + 1);
        int right = helper(root.right, depth + 1);
        return left > right ? left : right;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int step = 0;
        while (!queue.isEmpty()){
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }
        return step;
    }*/
}
public class LeetCode104 {
    public static void main(String[] args) {
        Solution104 solution = new Solution104();

    }
}
