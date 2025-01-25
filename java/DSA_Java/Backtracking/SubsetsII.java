package Backtracking;
import java.util.*;

public class SubsetsII {

    private void backtrack(int[] nums, int index, List<List<Integer>> result, List<Integer> comb) {

        result.add(new ArrayList<>(comb)); // add the current subset

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i-1]) { // skip duplicates in the array
                continue;
            }

            // backtracking
            comb.add(nums[i]);
            backtrack(nums, i + 1, result, comb);
            comb.remove(comb.size() - 1);
        }
    }


    private List<List<Integer>> subsetsII(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        backtrack(nums, 0, result, comb);

        return result;
    }

    // main method
    public static void main(String[] args) {
        // create an instance of class- object
        SubsetsII solution = new SubsetsII();
        int[] nums = {1, 2, 2};
        solution.subsetsII(nums);

        // printing
        System.out.println("Subsets are: ");
        for(List<Integer> element : solution.subsetsII(nums)) {
            System.out.println(element);
        }
        System.out.println();
    }
}


