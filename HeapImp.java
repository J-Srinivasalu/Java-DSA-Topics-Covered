public class HeapImp {
    static int N = 10000; // Max length of heap;
    static int[] maxHeap = new int[N];
    static int[] minHeap = new int[N];
    static int posMaxHeap = 0; // Current size or last element position in Max Heap
    static int posMinHeap = 0; // Current size or last element position in Max Heap

    public static void main(String[] args) {
        insertMax(1);
        insertMax(13);
        insertMax(12);
        insertMax(4);
        insertMax(42);
        insertMax(21);
        insertMin(1);
        insertMin(13);
        insertMin(12);
        insertMin(4);
        insertMin(42);
        insertMin(21);
        printHeap(maxHeap, posMaxHeap);
        printHeap(minHeap, posMinHeap);
        deleteMax();
        deleteMin();
        printHeap(maxHeap, posMaxHeap);
        printHeap(minHeap, posMinHeap);
    }
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //Print Heap
    static void printHeap(int[] heap, int size){
        System.out.print("{ ");
        for(int i=1;i<size;i++){
            System.out.print(heap[i]+", ");
        }
        System.out.print(heap[size]+"}");
        System.out.println();
    }

    //maxHeap insertion
    static void insertMax(int val){
        if(posMaxHeap >= N){
            System.out.println("Heap is full");
            return;
        }
        posMaxHeap = posMaxHeap+1;
        maxHeap[posMaxHeap] = val;
        int i = posMaxHeap;
        while(i>1){
            int p = i/2;
            if(maxHeap[p]<maxHeap[i]){ // for max heap p > i
                swap(maxHeap, i, p);
                i = p;
            }else{
                return;
            }
        }
    }//maxHeap insertion
    static void insertMin(int val){
        if(posMinHeap >= N){
            System.out.println("Heap is full");
            return;
        }
        posMinHeap = posMinHeap+1;
        minHeap[posMinHeap] = val;
        int i = posMinHeap;
        while(i>1){
            int p = i/2;
            if(minHeap[p]>minHeap[i]){ //For min heap p < i
                swap(minHeap, i, p);
                i = p;
            }else{
                return;
            }
        }
    }

    //maxHeap deletion
    static void deleteMax(){
        maxHeap[1] = maxHeap[posMaxHeap];
        posMaxHeap--;
        int i=1;

        while(i<posMaxHeap){
            int left = maxHeap[2*i];
            int right = maxHeap[2*i+1];
            int larger = left > right? 2*i:2*i+1;
            if(maxHeap[i] < maxHeap[larger]){ //for max heap
                swap(maxHeap, larger, i);
                i=larger;
            }else{
                return;
            }
        }
    }
        //minHeap deletion
    static void deleteMin(){
        minHeap[1] = minHeap[posMinHeap];
        posMinHeap--;
        int i=1;

        while(i<posMinHeap){
            int left = minHeap[2*i];
            int right = minHeap[2*i+1];
            int smaller = left < right? 2*i:2*i+1;
            if(minHeap[i] > minHeap[smaller]){ //for min heap
                swap(minHeap, smaller, i);
                i=smaller;
            }else{
                return;
            }
        }

    }
}
