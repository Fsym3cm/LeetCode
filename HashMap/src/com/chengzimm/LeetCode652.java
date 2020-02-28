/*寻找重复的子树*/
package com.chengzimm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution652 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        if (root == null) return res;
        saveRoute(root, res, map);
        return res;
    }

    //递归获取每个子树的路径，保存于Map中
    private String saveRoute(TreeNode node, List<TreeNode> res, HashMap<String, Integer> map) {
        if (node == null) return "";
        //自底向上获取每个节点的序列化值
        String route = node.val + "," + saveRoute(node.left, res, map) + "," + saveRoute(node.right, res, map);
        //将结果放入map，判断是否有相同子树
        //避免出现多次相同子树
        if (map.get(route) != null && map.get(route) == 1) {
            res.add(node);
        }
        map.put(route, map.getOrDefault(route, 0) + 1);
        return route;
    }

    List<TreeNode> res = new ArrayList<TreeNode>();
    Map<String,Integer> map = new HashMap<String,Integer>();
    public List<TreeNode> findDuplicateSubtrees2(TreeNode root) {
        if (root == null)
            return res;
        System.out.println(printNode(root));
        return res;
    }

    //使用深度优先搜索，其中递归函数返回当前子树的序列化结果。把每个节点开始的子树序列化结果保存在 map 中，然后判断是否存在重复的子树。
    private String printNode(TreeNode node){
        if (node == null) return "#";

        String val = node.val + printNode(node.left) + printNode(node.right);
        if (map.get(val) == null){
            map.put(val, 1);
        }else if (map.get(val) == 1){
            res.add(node);
            map.put(val, 2);
        }
        return val;
    }
}

public class LeetCode652 {
    public static void main(String[] args) {

    }
}
