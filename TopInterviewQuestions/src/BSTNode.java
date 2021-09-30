import java.util.ArrayList;
import java.util.Scanner;

public class BSTNode {

    public TreeNode input() {
        Scanner sc = new Scanner(System.in);
        TreeNode root = null;
        int data = sc.nextInt();

        while(data != -1) {
            root = insertHelper(root, data);
            data = sc.nextInt();
        }

        return root;
    }

    private TreeNode insertHelper(TreeNode root, int data) {
        if(root == null) {
            root = new TreeNode(data);
            return root;
        }

        if(data >= root.val) {
            root.right = insertHelper(root.right, data);
        } else {
            root.left = insertHelper(root.left, data);
        }

        return root;
    }

    public void print(TreeNode root) {
        if(root == null)
            return;

        System.out.print(root.val + " ");
        if(root.left != null)
            System.out.print("L: " + root.left.val + ", ");
        if(root.right != null)
            System.out.print("R: " + root.right.val + ", ");

        System.out.println();
        print(root.left);
        print(root.right);
    }

    public TreeNode delete(TreeNode root, int data) {
        if(root == null)
            return null;

        if(data > root.val) {
            root.right = delete(root.right, data);
        } else if(data < root.val) {
            root.left = delete(root.left, data);
        }
        if(data == root.val) {
            if(root.right == null && root.left == null)
                return null;
            else if(root.right == null)
                return root.left;
            else if(root.left == null)
                return root.right;
            else {
                // find inorder successor
                TreeNode minNode = root.right;
                // find the minimum node in the right subtree
                while(minNode.left != null) {
                    minNode = minNode.left;
                }
                root.val = minNode.val;
                root.right = delete(root.right, minNode.val);
            }
        }
        return root;
    }

    public boolean hasData(TreeNode root, int data) {
        if(root == null)
            return false;

        if(data > root.val)
            return hasData(root.right, data);
        else if(data < root.val)
            return hasData(root.left, data);
        else return true;
    }

    public TreeNode balancedBST(TreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        // for storing all nodes in arraylist
        getNodes(root, nodes);

        return buildBalancedBST(nodes, 0, nodes.size() - 1);
    }

    private TreeNode buildBalancedBST(ArrayList<Integer> nodes, int si, int ei) {
        if(si > ei)
            return null;

        int mid = (si + ei) / 2;
        TreeNode root = new TreeNode(nodes.get(mid));

        root.left = buildBalancedBST(nodes, si, mid - 1);
        root.right = buildBalancedBST(nodes, mid + 1, ei);

        return root;
    }

    private void getNodes(TreeNode root, ArrayList<Integer> nodes) {
        if(root == null)
            return;

        getNodes(root.left, nodes);
        nodes.add(root.val);
        getNodes(root.right, nodes);
    }

    public boolean isBST(TreeNode root) {
        if(root == null)
            return false;

        int leftMax = maximum(root.left);
        int rightMin = minimum(root.right);

        boolean isLeftBST = isBST(root.left);
        boolean isRightBST = isBST(root.right);

        boolean checkBST = (leftMax < root.val && rightMin > root.val) && isLeftBST && isRightBST;
        return checkBST;
    }

    public int minimum(TreeNode root) {
        if(root == null)
            return Integer.MAX_VALUE;

        return Math.min(root.val, Math.min(minimum(root.left), minimum(root.right)));
    }

    public int maximum(TreeNode root) {
        if(root == null)
            return Integer.MIN_VALUE;

        return Math.max(root.val, Math.max(maximum(root.left), maximum(root.right)));
    }
}
