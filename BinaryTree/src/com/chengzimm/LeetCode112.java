/*路径总和*/
package com.chengzimm;

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
class Solution112 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //遍历左右子树，当有一个子树满足条件则返回true
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null){
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    //用栈实现迭代，原理同上
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        nodeStack.push(root);
        sumStack.push(sum - root.val);

        while (!nodeStack.isEmpty()){
            TreeNode cur = nodeStack.pop();
            int num = sumStack.pop();

            if (cur.left == null && cur.right == null && num == 0)
                return true;
            if (cur.left != null){
                nodeStack.push(cur.left);
                sumStack.push(num - cur.left.val);
            }
            if (cur.right != null){
                nodeStack.push(cur.right);
                sumStack.push(num - cur.right.val);
            }
        }
        return false;
    }
}

public class LeetCode112 {
    public static void main(String[] args) {
        Solution112 solution = new Solution112();
    }
}
