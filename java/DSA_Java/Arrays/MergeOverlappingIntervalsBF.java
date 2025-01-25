/*
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */

import java.util.*;


public class MergeOverlappingIntervalsBF {

    public static int[][] mergeOverlappingIntervals(int[][] arr) {
        int n = arr.length; // size of the array

        // Sort the given intervals based on the start time
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        // Use a list to dynamically store merged intervals
        List<int[]> merged = new ArrayList<>();

        // Iterate over the sorted intervals
        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            // If the list is empty or there is no overlap, add the interval
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < start) {
                merged.add(new int[]{start, end});
            } else {
                // Otherwise, merge the intervals by updating the end time
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], end);
            }
        }

        // Convert the list back to an array
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        int[][] ans = mergeOverlappingIntervals(arr);

        System.out.print("The merged intervals are: \n");
        for (int[] interval : ans) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
    }
}
