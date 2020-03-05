/*从中序与后序遍历序列构造二叉树*/
package com.chengzimm;

import java.util.HashMap;

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

    /**
     * 以中序为基础，以后序链表从后往前的顺序构建出每个节点的左子树和右子树
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]*/
    int post_idx;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //从最后一个postorder元素开始(后续遍历最后一个节点必为根节点)
        post_idx = postorder.length - 1;
        //建立一个hashmap值->它的索引
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return helper(postorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] postorder, int in_left, int in_right) {
        //如果没有可以构造子树的元素
        if (in_left > in_right) return null;

        //拿起post_idx元素作为根
        TreeNode root = new TreeNode(postorder[post_idx]);
        //递归
        post_idx--;
        //得到中序的索引 (根拆分顺序列表, 分为左右子树)
        int index = map.get(root.val);
        //先建立右子树（后序遍历，左右根 , 树要满足这个顺序 根右左）
        root.right = helper(postorder, index + 1, in_right);
        //建立左子树
        root.left = helper(postorder, in_left, index - 1);
        return root;
    }

}

public class LeetCode106 {
    public static void main(String[] args) {

    }
}
