// Time complexity: O(N^2), (where N = size of the array), for the worst, and average cases.

public class InsertionSort {
    public static void insertionSort(int[] arr, int n) {
        for(int i = 0; i <= n-1; i++) {
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]){
                // swap
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        System.out.println("Sorted Array");
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        int n = arr.length;

        System.out.println("Original Array: ");
        for(int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        insertionSort(arr, n);
        System.out.println();
    }
}
