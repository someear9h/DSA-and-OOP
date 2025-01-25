class RotateArrayToLeft {
    public static void rotateArray(int[] arr, int n) {
        int[] temp = new int[n];

        for(int i = 1; i < n; i++) {
            temp[i-1] = arr[i];
        }
        temp[n-1] = arr[0];
        System.out.print("Sorted Array: ");
        for(int num : temp) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        System.out.print("Original Array: ");
        for(int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        rotateArray(arr, n);
        System.out.println();
    }
}