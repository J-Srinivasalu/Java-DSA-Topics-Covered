import java.util.Arrays;

public class NonComparingSorting {
    public static void main(String[] args) {
        int[] arr = {1,2,45,12,567,234,176,21,42,542};
        System.out.println(Arrays.toString(arr));
        radixSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static String countSort(String arr)
    {
        // code here
        int[] count = new int[26];
        for(int i=0;i<arr.length();i++){
            count[arr.charAt(i) - 'a']++;
        }
        String ans = "";
        for(int i=0;i<26;i++){
            while(count[i] != 0){
                ans+=(char)(i + 'a');
                count[i]--;
            }
        }
        
        return ans;
    }

    static void radixSort(int[] arr, int n){
        int max = findMax(arr, n);

        for(int i=1;max/i>0;i*=10){
            countSort(arr, n, i);
        }
    }

    static void countSort(int[] arr, int n, int e){
        int[] count  = new int[10];
        int[] output = new int[n];
        //count the ith digits of arr elements
        for(int i=0;i<n;i++){
            count[(arr[i]/e)%10]++;
        }

        //converting count to position of that digit
        for(int i=1;i<n;i++){
            count[i] += count[i-1];
        }

        //build output
        for(int i=n-1;i>=0;i--){
            output[count[(arr[i]/e)%10]-1] = arr[i];
            count[(arr[i]/e)%10]--;
        }
        for(int i=0;i<n;i++){
            arr[i] = output[i];
        }
    }

    static int findMax(int[] arr, int n){
        int max = arr[0];
        
        for(int i=1;i<n;i++){
            if(max < arr[i]) max = arr[i];
        }

        return max;
    }
    
}
