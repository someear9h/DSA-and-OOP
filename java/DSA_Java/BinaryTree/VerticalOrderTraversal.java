import java.util.*;

// Definition of the TreeNode class representing nodes of the binary tree
class TreeNode {
    int data;       // The value of the node
    TreeNode left;  // Reference to the left child
    TreeNode right; // Reference to the right child

    TreeNode(int val) {
        data = val;
        left = null;  // Initialize left child as null
        right = null; // Initialize right child as null
    }
}

// Helper class to store a node and its corresponding column index
class Pair {
    TreeNode node;  // The current tree node
    int col;        // The column index of the node

    Pair(TreeNode node, int col) {
        this.node = node; // Assign the tree node
        this.col = col;   // Assign its column index
    }
}

// Main class containing the vertical order traversal logic
public class VerticalOrderTraversal {

    // Method to perform vertical order traversal
    private static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // List to store the final result

        // Edge case: If the tree is empty, return an empty result
        if (root == null) return result;

        // TreeMap to store nodes based on their column index (sorted automatically by column)
        TreeMap<Integer, List<Integer>> columnMap = new TreeMap<>();

        // Queue for level-order traversal (BFS), storing pairs of nodes and their column indices
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0)); // Start with the root at column 0

        // BFS traversal
        while (!queue.isEmpty()) {
            Pair current = queue.poll(); // Get the front pair from the queue
            TreeNode node = current.node; // Extract the tree node
            int col = current.col;       // Extract the column index

            // If the column does not exist in the map, create a new entry
            columnMap.putIfAbsent(col, new ArrayList<>());
            
            // Add the current node's value to the corresponding column list
            columnMap.get(col).add(node.data);

            // If the node has a left child, add it to the queue with column index - 1
            if (node.left != null) {
                queue.add(new Pair(node.left, col - 1));
            }

            // If the node has a right child, add it to the queue with column index + 1
            if (node.right != null) {
                queue.add(new Pair(node.right, col + 1));
            }
        }

        // Add the lists from the column map to the result in sorted order of columns
        for (List<Integer> column : columnMap.values()) {
            result.add(column);
        }

        return result; // Return the final vertical order traversal
    }

    // Main method to test the vertical order traversal
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Performing vertical order traversal
        List<List<Integer>> result = verticalOrder(root);

        // Printing the result
        for (List<Integer> column : result) {
            System.out.println(column);
        }
    }
}
