/*从前序与中序遍历序列构造二叉树*/
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
class Solution105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     */
    int pre = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int start, int end){
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[pre++]);
        int index = map.get(root.val);
        //要先建立左子树，(前序遍历根左右)
        root.left = helper(preorder, start, index - 1);
        root.right = helper(preorder, index + 1, end);
        return root;
    }
}

public class LeetCode105 {
    public static void main(String[] args) {

    }
}
