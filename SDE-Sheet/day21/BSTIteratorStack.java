package day21;

import day17.TreeNode;

import java.util.List;
import java.util.Stack;

public class BSTIteratorStack {
    Stack<TreeNode> stack;
    TreeNode currNode = null;
    public BSTIteratorStack(TreeNode root) {
        stack = new Stack<>();
        currNode = root;
    }

    public void traverse(TreeNode root, List<Integer> list) {
        if(root == null) return;

        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

    public int next() {
        while(currNode != null) {
            stack.push(currNode);
            currNode = currNode.left;
        }
        TreeNode top = stack.pop();
        currNode = top.right;
        return top.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || currNode != null;
    }
}
