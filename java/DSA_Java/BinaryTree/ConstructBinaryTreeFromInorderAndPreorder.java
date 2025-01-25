import java.util.*;

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

class Solution {
    Map<Integer, Integer> inMap = new HashMap<>();  // Map to store inorder values and their indices
    int preIndex = 0;  // Index for tracking the current position in the preorder array

    public TreeNode buildTree(int[] inorder, int[] preorder) {
        // Fill the map with inorder values and their respective indices 
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        // Start building the tree from the preorder array
        return build(0, preorder.length - 1, preorder);
    }

    private TreeNode build(int left, int right, int[] preorder) {
        // Base case: If the index exceeds the length of the preorder array, return null
        if (preIndex >= preorder.length) return null;

        // Base case: If the right index is less than the left index, return null
        if (right < left) return null;

        // Create the root node using the current value from the preorder array
        TreeNode root = new TreeNode(preorder[preIndex]);

        // Get the index of the root value in the inorder array from the map
        int in = inMap.get(preorder[preIndex++]); // Increment pre after using it 

        // Recursively build the left subtree
        root.left = build(left, in - 1, preorder);

        // Recursively build the right subtree
        root.right = build(in + 1, right, preorder);

        // Return the constructed treenode
        return root;
    }

    // Helper function for in-order traversal (to verify the tree)
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        // Build the tree
        TreeNode root = solution.buildTree(inorder, preorder);

        System.out.println("In-order traversal of the tree:");
        solution.inorderTraversal(root);
        System.out.println();   
    }
}
