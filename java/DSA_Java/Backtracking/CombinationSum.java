package Backtracking;
import java.util.*;

public class CombinationSum {
    
    private void backtrack(int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> comb) {
        // base case
        if(target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            
            if(candidates[i] > target) {
                break;
            }

            comb.add(candidates[i]); // add the current number
            // Recur with the same index i since we can use the same number multiple times
            backtrack(candidates, i, target - candidates[i], result, comb);
            comb.remove(comb.size() - 1); // Backtrack to try other combinations
        }
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        backtrack(candidates, 0, target, result, comb);
        return result;
    }

    // main method
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;

        CombinationSum solution = new CombinationSum();
        solution.combinationSum(candidates, target);

        // printing
        System.out.println("The combinations are: ");
        for(List<Integer> element : solution.combinationSum(candidates, target)) {
            System.out.println(element);
        }

        System.out.println();
    }
}


/*
 Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []

 */