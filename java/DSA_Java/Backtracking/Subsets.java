package Backtracking;
import java.util.*;

public class Subsets {

    private void backtrack(int[] nums, int index, List<List<Integer>> result, List<Integer> comb) {
        // Instead of the base condition, we add the current combination at each step
        result.add(new ArrayList<>(comb));

        for (int i = index; i < nums.length; i++) {
            comb.add(nums[i]); // Add the element
            backtrack(nums, i + 1, result, comb); // Move to the next element
            comb.remove(comb.size() - 1); // Backtrack, remove the last element
        }
    }

    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        backtrack(nums, 0, result, comb); // Start from index = 0
        return result;
    }

    public static void main(String[] args) {
        Subsets solution = new Subsets();
        
        int[] nums = {1, 2, 3}; // Input array
        List<List<Integer>> subsets = solution.subsets(nums);

        System.out.println("All subsets (powersets): ");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
