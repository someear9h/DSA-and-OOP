// Problem Statement: Given an array of integers arr[] and an integer target.
// 1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.
// 2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.

import java.util.*;
public class TwoSum {
    private static String twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int wantedElement = target - nums[i];
            if(map.containsKey(wantedElement)) {
                return "Yes";
            }
            // if map doesnt contain the key put that element with index in map
            map.put(nums[i], i);
        }
        return "No";
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,4};
        int target = 4;

        System.out.println(twoSum(nums, target));
    }
}
            