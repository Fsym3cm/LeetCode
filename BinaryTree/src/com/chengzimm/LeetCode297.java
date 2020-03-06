/*二叉树的序列化与反序列化*/
package com.chengzimm;

import java.util.Arrays;
import java.util.LinkedList;
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
class Codec {

     public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serialize(root, "");
    }

    /**/
    public String serialize(TreeNode root, String str){
         if (root == null){
             str += "null,";
         } else {
             str += str.valueOf(root.val) + ",";
             str = serialize(root.left, str);
             str = serialize(root.right, str);
         }
        System.out.println(str);
         return str;
    }

    //对第一种 string+进行优化，使用sb
    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeCore2(root, sb);
        return sb.toString();
    }
    private void serializeCore2(TreeNode root, StringBuilder sb){
        if(root==null) sb.append("null,");
        else{
            sb.append(root.val + ",");
            serializeCore2(root.left, sb);
            serializeCore2(root.right, sb);
        }
    }

    public String serialize3(TreeNode root) {
        if (root == null){
            return "null,";
        }
        String str = root.val + "," + serialize3(root.left) + serialize3(root.right);
        System.out.println(str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(array));
        return rdeserialize(list);
    }

    public TreeNode rdeserialize(List<String> list) {
        // Recursive deserialization.
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

public class LeetCode297 {
    public static void main(String[] args) {

    }
}
