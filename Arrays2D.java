public class Arrays2D {
    public static void main(String[] args) {

        int[][] arr = {
            {1,2,3,4},
            {5,6,7,8},
            {23, 45, 56, 78}
        };
        int target = 560;

        System.out.println(search(arr, target));
        System.out.println(binarySearch(arr, target));

    }

    static class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
        @Override
        public String toString() {
            return "{ "+i+", "+j+"}";
        }
    }

    //Search in 2D array row and column wise sorted
    static Pair search(int[][] arr, int target){
        int i = 0;
        int j = arr[0].length-1;

        while(i < arr.length && j >= 0){
            if(arr[i][j] == target){
                return new Pair(i, j);
            }
            else if(arr[i][j] > target){
                j--;
            }
            else{
                i++;
            }
        }


        return new Pair(-1, -1);
    }
    static Pair binarySearch(int[][] arr, int target){
        int m = arr.length;
        int n = arr[0].length;
        int s = 0;
        int e = m*n - 1;
        while(s <= e){
            int mid = s + (e - s)/2;
            int i = mid/n;
            int j = mid%n;
            if(arr[i][j] == target){
                return new Pair(i, j);
            }else if(arr[i][j] > target){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return new Pair(-1, -1);
    }
}
