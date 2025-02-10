package Stacks_and_Queues;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        // create a hashmap to stor next greater elements 
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];

            while(!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
            }

            // if stack is not empty, the top element is next greater element
            nextGreaterMap.put(num, stack.isEmpty() ? -1 : stack.peek());

            // push the current element on to the stack
            stack.push(num);
        }

        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementI solution = new NextGreaterElementI();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(solution.nextGreaterElement(nums1, nums2))); 
        // Output: [-1, 3, -1]
    }
}