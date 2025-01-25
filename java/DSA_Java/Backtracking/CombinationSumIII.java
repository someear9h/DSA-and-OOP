package Backtracking;
import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    private void backtrack(int k, int target, int start, List<Integer> combination, List<List<Integer>> result) {
        // Base case: if we've selected k numbers and the target is met
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        
        // If `k` becomes negative or the target becomes negative, terminate that branch
        if (k < 0 || target < 0) {
            return;
        }

        // Explore numbers from `start` to 9
        for (int i = start; i <= 9; i++) {
            combination.add(i); // Add the current number
            backtrack(k - 1, target - i, i + 1, combination, result); // Move to the next number
            combination.remove(combination.size() - 1); // Backtrack to try other possibilities
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(k, n, 1, combination, result); // Start backtracking with numbers 1-9
        return result;
    }

     // Test the solution
     public static void main(String[] args) {
        CombinationSumIII sol = new CombinationSumIII();
        int k = 3, n = 7;
        List<List<Integer>> result = sol.combinationSum3(k, n);
        System.out.println(result); // Output: [[1, 2, 4]]
    }
}

/*
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.

Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.

Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 */
