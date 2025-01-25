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

public class LeftAndRIghtView {
    private static List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int levelSize = q.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode currNode = q.poll();
                if(i == levelSize - 1) result.add(currNode.data);

                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
            }
        }
        return result;
    }

    private static List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int levelSize = q.size();  // number of nodes in the current level of Tree
            for(int i = 0; i < levelSize; i++) {
                TreeNode currNode = q.poll();

                if(i == 0) result.add(currNode.data);

                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right); 
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);

        System.out.println("Left View: " + leftView(root));
        System.out.println("Rght View" + rightView(root));
    }
}