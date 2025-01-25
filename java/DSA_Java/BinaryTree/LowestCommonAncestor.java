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

public class LowestCommonAncestor {
    private static TreeNode lowstCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) return root;

        // recur for left and right subtrees
        TreeNode left = lowstCommonAncestor(root.left, p, q);
        TreeNode right = lowstCommonAncestor(root.right, p, q);

        // if both child of a root node return non null values i.e, p and q, root is LCA
        if(left != null && right != null) return root;

        // if either of the child node is not null then return the non null node
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // define two nodes whose LCA is to be found
        TreeNode p = root.left; // Node with value 5
        TreeNode q = root.left.right.right; // Node with value 4

        TreeNode lca = lowstCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of nodes " + p.data + " and " + q.data + " is " + lca.data);
    }
}
        

