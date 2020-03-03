/*二叉树的后序遍历*/
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
class Solution145 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode root, List<Integer> list){
        if (root == null) return;
        helper(root.left, list);
        helper(root.right, list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode r = null;
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.peek();
                System.out.println(root);
                if (root.right == null || root.right == r) {
                    list.add(root.val);
                    r = root;
                    stack.pop();
                    root = null;
                }
                else
                    root = root.right;
            }
        }
        return list;
    }
}

public class LeetCode145 {
    public static void main(String[] args) {

    }
}
