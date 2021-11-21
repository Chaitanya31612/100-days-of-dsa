package day18;

import day17.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int size = queue.size();
            for(int i = 1; i <= size; i++) {
                TreeNode node = queue.poll();

                tempList.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            list.add(new ArrayList<>(tempList));
        }

        return list;
    }
}
