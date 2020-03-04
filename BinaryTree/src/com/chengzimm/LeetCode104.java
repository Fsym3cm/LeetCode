/*二叉树的最大深度*/
package com.chengzimm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        List<Integer> list = new ArrayList<>();
        helper(root, 0, list);
        Collections.sort(list);
        return list.get(list.size() - 1) + 1;
    }

    public void helper(TreeNode root, Integer depth, List<Integer> list){
        System.out.println(depth);
        list.add(depth);
        if (root.left != null) {
            helper(root.left, depth + 1, list);
        }
        if (root.right != null) {
            helper(root.right, depth + 1, list);
        }
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int left = 1, right = 1;
        left += maxDepth2(root.left);
        right += maxDepth2(root.right);
        return Math.max(left, right);
    }

}

public class LeetCode104 {
    public static void main(String[] args) {

    }
}
