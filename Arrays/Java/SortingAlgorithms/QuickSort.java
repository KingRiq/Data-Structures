package SortingAlgorithms;
//finally something fast 

public class QuickSort{

    // this will go alot like merge sort in the beginning.. but QS is inplace sorting 
    // no extra arrays so we save space
    public static int[] quickSort(int arr[]) {
        
        int start = 0;
        int end = arr.length-1;

        quickSort(arr,start,end);

        return arr;
    }


    // the method above is an abstraction decision the method below is the REAL quicksort
    static void quickSort(int arr[], int start, int end) {

        //fetch the pivot
        if(start < end) {
            int pivot = partition(arr,start,end);
        

            // sort before and after pivot
            quickSort(arr, start, pivot-1); //excluding pivot
            quickSort(arr, pivot+1, end);
        }

    }

    static int partition(int arr[], int start, int end) {

        // there are different methods and I dont care to teach you it
        // google it tbh the argument is messy but sound

        // I don't like to leave things in question. I will choose a random one
        //  (i prefer median of 3) 
        int i = start - 1;

        //pivot position
        int position = (int) (Math.random() * (end-start))+ start;
       
        swap(arr, position, end);
        int pivot = arr[end];
        
        // 2 points i and j
        
        for(int j = start; j < end; j++) {

            // if current element is smaller than the one in question
            if(arr[j] < pivot) {
                i++;
                swap(arr,i,j);
            }
        }
        
        swap(arr, i+1, end);
        return  i+1;  //by definition above everything before i+1 is smaller than the pivot
    }

    // basic swap operations! memorize this for linked lists
    static void swap(int arr[], int pos1, int pos2) {

        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;

    }
}