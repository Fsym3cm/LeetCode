/*中序遍历二叉树*/
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
class Solution94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode root, List<Integer> list){
        if (root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (!stack.isEmpty() || p != null){
            if (p != null){
                stack.push(p);
                p = p.left;
            }else {
                TreeNode cur = stack.pop();
                list.add(cur.val);
                p = cur.right;
            }
        }
        return list;
    }
}
public class LeetCode94 {
    public static void main(String[] args) {

    }
}
