import java.util.Arrays;

public class ArraySortingRec {
    
    public static void main(String[] args) {
        int[] arr = {1,4,7,2,67,2,231,34,121,65};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        
    }

    static void mergeSort(int[] arr, int l, int h){
        if(l >=h) return;
        int m = l + (h - l)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, h);

        merge(arr, l, m, h);
    }

    static void merge(int[] arr, int l, int m, int h){
        int i=l;
        int j=m+1;
        int k=0;
        int[] temp = new int[h-l+1];
        while(i<=m && j<=h){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        while(i<=m){
            temp[k++] = arr[i++];
        }
        while(j<=h){
            temp[k++] = arr[j++];
        }

        for(i=l, k=0;i<=h;i++, k++){
            arr[i] = temp[k];
        }

    }

    static void quickSort(int[] arr, int l, int h){
        if(l>=h) return;
        int p = partition(arr, l, h);
        quickSort(arr, l, p-1);
        quickSort(arr, p+1, h);
    }

    static int partition(int[] arr, int l, int h){
        int p = h;
        int i = l;
        int j = h;
        while(i<j){
            while(i<h && arr[i] >= arr[p])
                i++;
            while(j>l && arr[j] < arr[p])
                j--;
            if(i<j) swap(arr, i, j);
        }
        swap(arr, p, j);
        return j;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
