package SortingAlgorithms;

public class BubbleSort {

    public BubbleSort(){}

    // This algorithm after each iteration indice(n-i-1) will have the correct number there.
    public static int[] bubbleSort(int[] array) {
        
        // listen carefully
        // we iterate over n-1 because we are comparing two indices so an array
        // of size 2 only needs to be compared once

        //the inner loop does not need to consider the indices compared in previous iterations.
        if(array.length == 0 || array.length == 1) {
            return array;
        }
        
        int n = array.length-1;
        // n-1 comparisons
        for(int i = 0; i < n; i++) {

            // check until n-i
            for(int j = 0; j< n-i; j++) {
                
                // compare j and j+1
                if(array[j] > array[j+1]) {

                    //swap
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;

                }
            }
        }

        /*
        System.out.println("BubbleSort");
        System.out.println("Average Time Complexity: ")
        System.out.println("Time Complexity worst cast:");
        System.out.println("Original Array: " + Arrays.toString(int_array));
        System.out.println("BubbleSort");
        System.out.println("BubbleSort");*/
        return array;
    }

}