
public class BubbleSort {
    public static void bubbleSort(int[] arr, int n) {
        for(int i = n-1; i >= 0; i--) {
            for(int j = 0; j <= i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("After Sorting: ");
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

        bubbleSort(arr, n);
        System.out.println();
    }
}
