import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode input() {
        TreeNode newNode = new TreeNode();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value: ");
        int data = sc.nextInt();

        if(data == -1)
            return null;
        newNode.val = data;

        System.out.println("Enter left child of " + data);
        newNode.left = input();
        System.out.println("Enter right child of " + data);
        newNode.right = input();

        return newNode;
    }

    public TreeNode inputLevel() {
        Scanner sc = new Scanner(System.in);
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        int val = sc.nextInt();
        if(val == -1)
            return null;

        TreeNode root = new TreeNode(val);
        pendingNodes.add(root);

        while(!pendingNodes.isEmpty()) {
            TreeNode node = pendingNodes.poll();

            int leftChild = sc.nextInt();
            if(leftChild != -1) {
                TreeNode leftNode = new TreeNode(leftChild);
                node.left = leftNode;
                pendingNodes.add(leftNode);
            }
            int rightChild = sc.nextInt();
            if(rightChild != -1) {
                TreeNode rightNode = new TreeNode(rightChild);
                node.right = rightNode;
                pendingNodes.add(rightNode);
            }
        }

        return root;
    }

    public void print(TreeNode root) {
        if(root == null)
            return;

        String printString = root.val + ": ";
        if(root.left != null)
            printString += "L: " + root.left.val + ", ";
        if(root.right != null)
            printString += " R: " + root.right.val;

        System.out.println(printString);

        print(root.left);
        print(root.right);
    }
}