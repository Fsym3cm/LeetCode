/*从中序与后序遍历序列构造二叉树*/
package com.chengzimm;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution106 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return new TreeNode(1);
    }
}

public class LeetCode106 {
    public static void main(String[] args) {

    }
}
