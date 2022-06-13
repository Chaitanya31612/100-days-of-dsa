package day17_binarytree;

import java.util.ArrayList;

public class LeftView {
    int maxlevel = -1;
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        leftViewUtil(root, 0, list);
        return list;
    }

    void leftViewUtil(Node root, int level, ArrayList<Integer> list) {
        if(root == null) return;

        if(level > maxlevel) {
            list.add(root.data);
            maxlevel = level;
        }

        leftViewUtil(root.left, level + 1, list);
        leftViewUtil(root.right, level+1, list);
    }
}
