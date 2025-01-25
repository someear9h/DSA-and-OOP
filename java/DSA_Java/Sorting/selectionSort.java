
class SelectionSort {
    public static void selectionSort(int[] arr) {
        int N = arr.length;

        for(int i = 0; i < N-1; i++){
            int min = i;

            for(int j = i+1; j < N; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }

            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);

        System.out.println("Sorted Array: ");
        for(int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}