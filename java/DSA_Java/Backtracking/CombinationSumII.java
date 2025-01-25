package Backtracking;
import java.util.*;

public class CombinationSumII {
    
    private void backtrack(int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> comb) {
        // base case
        if(target == 0) {
            result.add(new ArrayList<>(comb)); // add current valid combination
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            // skip duplicates
            if(i > index && candidates[i] == candidates[i-1]) {
                continue;
            }

            if(candidates[i] > target) {
                break;
            }

            // backtrack
            comb.add(candidates[i]); // add the current element
            backtrack(candidates, i + 1, target - candidates[i], result, comb);
            comb.remove(comb.size() - 1); // remove the last element
        }

    }
    private List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(candidates, 0, target, result, comb);
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        // object creation
        CombinationSumII solution = new CombinationSumII();
        List<List<Integer>> result = solution.combinationSumII(candidates, target);

        // printing
        System.out.println("The combinations which sum up to target are: ");
        System.out.println(result);
        
    }
}
        

/*
 Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]


 */
