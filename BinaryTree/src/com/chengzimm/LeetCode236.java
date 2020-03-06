/*二叉树的最近公共祖先*/
package com.chengzimm;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution236 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();

        map.put(root, null);
        stack.push(root);

        //迭代直到找到节点p和q
        while (!map.containsKey(p) || !map.containsKey(q)) {

            TreeNode node = stack.pop();

            //在遍历树时，请继续保存父指针。
            if (node.left != null) {
                map.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                map.put(node.right, node);
                stack.push(node.right);
            }
        }

        //节点p的祖先set（）。
        Set<TreeNode> ancestors = new HashSet<>();

        //使用父指针处理节点p的所有祖先。
        while (p != null) {
            //p的祖先set（）中出现的q的第一个祖先是它们的最低公共祖先。所以第一个放自己本身，然后放map中的祖先节点
            ancestors.add(p);
            p = map.get(p);
        }
        //当祖先中不包含q，则需要到map中寻找最低公共祖先，否则q就直接为p的祖先节点
        while (!ancestors.contains(q))
            q = map.get(q);

        return q;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        //如果左子树没有这个祖先，则返回右子树。
        if (left == null) return right;
        if (right == null) return left;
        //返回的root随着递归，移动到了两个节点的根位置
        return root;
    }
}

public class LeetCode236 {
    public static void main(String[] args) {

    }
}
