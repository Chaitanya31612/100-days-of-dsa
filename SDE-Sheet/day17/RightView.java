package day17;

import java.util.ArrayList;
import java.util.List;

public class RightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightViewUtil(root, list, 0);
        return list;
    }

    public void rightViewUtil(TreeNode root, List<Integer> list, int level) {
        if(root == null) return;

        if(level == list.size()) {
            list.add(root.val);
        }

        rightViewUtil(root.right, list, level+1);
        rightViewUtil(root.left, list, level+1);
    }
}
