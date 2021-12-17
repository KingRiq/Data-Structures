package SortingAlgorithms;

public class InsertionSort {


    // This algorithm after each iteration indice(n-i-1) will have the correct number there.
    public static int[] insertionSort(int[] array) {
        
        // listen carefully
        // we iterate over n-1 because we are comparing two indices so an array
        // of size 2 only needs to be compared once

        //the inner loop does not need to consider the indices compared in previous iterations.
        if(array.length == 0 || array.length == 1) {
            return array;
        }
        
        // iterate over the entire array
        for(int i = 1; i < array.length; i++) {

            // save our key and from i-1 put everything in over
            int key = array[i];
            int j = i-1;

            // if this doesnt run (we are comparing j to our key and placing)
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            // nothing changes here
            array[j + 1] = key;
        }

        return array;
    }

}