import java.util.ArrayList;
import java.util.List;

public class Inorder {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderUtil(root, list);

        return list;
    }

    public static void inorderUtil(TreeNode root, List<Integer> list) {
        if(root == null)
            return;

        inorderUtil(root.left, list);
        list.add(root.val);
        inorderUtil(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode();
        TreeNode root = t.inputLevel();
        System.out.println(inorderTraversal(root));
    }
}
