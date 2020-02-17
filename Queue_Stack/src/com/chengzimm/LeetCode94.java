/*二叉树的中序遍历*/
package com.chengzimm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**root为单个节点，一个个进入其中*/
//  Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> target = new ArrayList<>();
        helper(root, target);
        return target;
    }

    public void helper(TreeNode root, List<Integer> target){
        if(root != null){
            if(root.left != null){
                //当进行完左子树的递归，则会调用add方法。
                helper(root.left, target);
            }
            //添加中间节点的值
            target.add(root.val);
            if(root.right != null){
                //当进行完右子树的递归，则会调用add方法。
                helper(root.right, target);
            }
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> target = new ArrayList<>();
        if(root == null){
            return target;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //当栈为空时则操作完成。
        while(!stack.isEmpty()){
            if(root != null && root.left != null){
                stack.push(root.left);
                root = root.left;
            }else{
                TreeNode pop = stack.pop();
                //添加栈pop出的值。
                target.add(pop.val);
                if(pop.right != null){
                    stack.push(pop.right);
                    root = pop.right;
                }
            }
        }
        return target;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> target = new ArrayList<>();
        helper(root, target);
        return target;
    }
    public void helper2(TreeNode root, List<Integer> target){
        if (root == null){
            return;
        }
        helper2(root.left, target);
        target.add(root.val);
        helper2(root.right, target);
    }
}

public class LeetCode94 {
    public static void main(String[] args) {

    }
}
