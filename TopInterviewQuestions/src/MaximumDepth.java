import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaximumDepth {
    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode();
        TreeNode root = t.inputLevel();
//        t.print(root);

        System.out.println(maxDepth(root));
    }
}

/*
1
2 3
4 5 -1 6
-1 -1 -1 -1 -1 -1
* */