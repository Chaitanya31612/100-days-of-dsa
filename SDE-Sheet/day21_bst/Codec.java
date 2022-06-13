package day21_bst;

import day17_binarytree.TreeNode;

import java.util.*;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            TreeNode front = queue.poll();

            if(front == null) {
                list.add(null);
                continue;
            }

            list.add(front.val);

            queue.add(front.left);
            queue.add(front.right);
        }
        String s = list.toString();
        // System.out.println(s);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        List<String> list = Arrays.asList(data.substring(1, data.length()-1).split(", "));

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        queue.add(root);
        if(data.length() == 1) return root;
        int idx = 1;

        while(!queue.isEmpty()) {
            TreeNode front = queue.poll();

            if(!list.get(idx).equals("null")) {
                TreeNode leftnode = new TreeNode(Integer.parseInt(list.get(idx)));
                front.left = leftnode;
                queue.add(leftnode);
            } else
                front.left = null;

            idx++;

            if(!list.get(idx).equals("null")) {
                TreeNode rightnode = new TreeNode(Integer.parseInt(list.get(idx)));
                front.right = rightnode;
                queue.add(rightnode);
            } else
                front.right = null;

            idx++;

        }

        return root;
    }
}