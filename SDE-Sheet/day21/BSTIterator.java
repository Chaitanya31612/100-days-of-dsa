package day21;

import day17.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {

    List<Integer> list;
    int currentIdx;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        traverse(root, list);
        currentIdx = 0;
    }

    public void traverse(TreeNode root, List<Integer> list) {
        if(root == null) return;

        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

    public int next() {
        int value = list.get(currentIdx);
        currentIdx++;
        return value;
    }

    public boolean hasNext() {
        return currentIdx < list.size();
    }
}
