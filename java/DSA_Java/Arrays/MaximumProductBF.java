/*
 * Problem Statement: Given an array that contains both negative and positive integers, find the maximum product subarray.

Examples
Example 1:
Input:

 Nums = [1,2,3,4,5,0]
Output: 120
Explanation:
In the given array, we can see 1×2×3×4×5 gives maximum product value.

*/

public class MaximumProductBF {
   private static int maxProduct(int[] nums) {
    int result = Integer.MIN_VALUE;
    for(int i = 0; i < nums.length - 1; i++) {
        for(int j = i + 1; j < nums.length; j++) {
            int product = 1;
            for(int k = i; k <= j; k++) {
                product *= nums[k];
            }
            result = Math.max(result, product);
        }
    }
    return result;
   }

   public static void main(String[] args) {
       int[] nums = {1, 2, -3, 0, -4, -5};
       int answer = maxProduct(nums);
       System.out.println(answer);
   }
}

