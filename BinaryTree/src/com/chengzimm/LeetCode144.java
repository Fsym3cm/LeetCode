/*二叉树的前序遍历*/
package com.chengzimm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution144 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return list;
    }

    public void helper(TreeNode root){
        if (root == null) return;
        list.add(root.val);
        helper(root.left);
        helper(root.right);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                arr.add(root.val);
                stack.add(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return arr;
    }
}

public class LeetCode144 {
    public static void main(String[] args) {

    }
}
