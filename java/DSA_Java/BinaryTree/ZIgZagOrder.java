
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class ZIgZagOrder {
    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result; // return empty result

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        // Perform level-order traversal with zigzag pattern
        while(!queue.isEmpty()) {
            int levelSize = queue.size(); // number of nodes at current level
            Deque<Integer> currentLevel = new LinkedList<>();

            for(int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // If leftToRight is true, add node value to the end of the deque
                if(leftToRight) {
                    currentLevel.addLast(currentNode.val);
                } else {
                    // If leftToRight is false, add node value to the front of the deque
                    currentLevel.addFirst(currentNode.val);
                }

                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }
            result.add(new ArrayList<>(currentLevel));
            leftToRight = !leftToRight; // toggle the direction for the next level
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left= new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = zigzagLevelOrder(root);

        for(List<Integer> level : result) {
            System.out.print(level + " ");
        }
        System.out.println();
    }
}


