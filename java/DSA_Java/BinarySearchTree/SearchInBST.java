class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class SearchInBST {
    private static TreeNode binarySearch(TreeNode root, int val) {
        if (root == null) return null;
        if (root.data == val) return root;

        if (val < root.data) {
            // Search in left subtree
            return binarySearch(root.left, val);
        } else {
            // Search in right subtree
            return binarySearch(root.right, val);
        }
    }

    public static void main(String[] args) {
        int val = 2;

        // Constructing the BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // Searching for the value
        TreeNode result = binarySearch(root, val);
        if (result != null) {
            System.out.println("Node found with value: " + result.data);
        } else {
            System.out.println("Value not found in the BST.");
        }
    }
}
