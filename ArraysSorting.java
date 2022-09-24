import java.util.Arrays;

public class ArraysSorting {
    public static void main(String[] args) {
        int[] arr = {1,6,7,82,3,5,2,34,64};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {2,1,4,6,5};
        cyclicSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void bubbleSort(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                if(arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
    }

    static void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]<key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    static void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min] > arr[j])
                    min = j;
            }
            swap(arr, min, i);
        }
    }

    static void cyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int curr = arr[i];
            if(curr < arr.length && arr[curr-1] != curr){
                swap(arr, curr-1, i);
            }else{
                i++;
            }
        }
    }

}
