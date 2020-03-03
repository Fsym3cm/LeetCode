package com.chengzimm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        helper(root, 0, lists);
        return lists;
    }

    public void helper(TreeNode root, Integer index, List<List<Integer>> lists){
        if (root == null) return;
        if (index  == lists.size()) lists.add(new LinkedList<>());
        lists.get(index).add(root.val);
        System.out.println(index);
        // 应该写 +1: 0,11,22， ++: 00,11,22
        if (root.left != null) helper(root.left, index + 1, lists);
        if (root.right != null) helper(root.right, index + 1, lists);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 0;
        while (!queue.isEmpty()){
            //将创建每层的list操作放在这儿
            lists.add(new LinkedList<>());
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                //通过get(index)确定list所在的位置
                lists.get(index).add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            index++;
        }
        return lists;
    }
}

public class LeetCode102 {
    public static void main(String[] args) {

    }
}
