public class ArraysSearching {
    
    public static void main(String[] args) {
        
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int X = 4;
        // X=10;
        System.out.println(linearSearch(arr, X));
        System.out.println(binearySearchIterative(arr, X));
        System.out.println(binearySearchRecursive(arr,0, arr.length-1, X));
    }

    //Linear Search
    // TC: O(N)
    // SC: O(1)
    static int linearSearch(int[] arr, int X){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == X)
                return i;
        }
        return -1;
    }

    //Bineary Search Iterative
    // TC: O(log(N))
    // SC: O(1)
    static int binearySearchIterative(int arr[], int X){
        int s = 0;
        int e = arr.length-1;

        while(s<=e){
            int m = s + (e - s)/2;
            if(arr[m] == X)
                return m;
            else if(arr[m] > X)
                e = m-1;
            else
                s = m+1;
        }

        return -1;
    }

    //Bineary Search Recursive
    // TC: O(log(N))
    // SC: O(log(N))
    static int binearySearchRecursive(int arr[],int s, int e, int X){
        if(s<=e){
            int m = s + (e-s)/2;
            if(arr[m] == X)
                return m;
            else if(arr[m] > X)
                return binearySearchRecursive(arr, s, m-1, X);
            else
                return binearySearchRecursive(arr, m+1, e, X);
        }
        return -1;
    }

}
