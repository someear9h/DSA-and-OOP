/*
 * Time Complexity: O(n log n), where n is the number of elements. 
 * Space Complexity: O(n), since we use an additional ArrayList
 */

import java.util.*;

public class MergeSort {
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low; // starting index of left half of arr
        int right = mid + 1; // starting index of right half of arr

        // storing elements in the temporary array in a sorted manner
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left to get added in temp array
        while(left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // if elements on the right half are still left
        while(right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transferring all elements from temp to arr
        for(int i = low; i <= high; i++) { // Use <= high here
            arr[i] = temp.get(i - low);
        }
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if(low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid); // left half
        mergeSort(arr, mid + 1, high); // right half
        merge(arr, low, mid, high); // merging sorted halves
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};  // Example input
        int n = arr.length;

        System.out.println("Unsorted array:");
        System.out.println(Arrays.toString(arr));

        mergeSort(arr, 0, n - 1);  // Call mergeSort on the entire array

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }
}
