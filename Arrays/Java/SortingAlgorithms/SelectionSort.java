package SortingAlgorithms;

public class SelectionSort { 
    public static int[] selectionSort(int[] array){
        
        // listen carefully I got something to say
        // Selection sort finds the minimum indice and moves it to the front
        // we are comparing the minimum index in question with the minimum value when we find the smallest value we put it in its place.
        

        // dont create variable multiple times
        int temp;
        if(array.length > 1) {

            // iterate over the entire array n-1 because we only need to change n-1 values at most
            for(int i = 0; i < array.length-1; i++) {
                
                 // save our place
                 int min_idx = i;
                 
                // iterate from i forward looking for the next smallest int
                for(int j = i+1; j < array.length; j++ ) {


                    // we found a value smaller int than our current one and need to swap it
                    if(array[j] < array[min_idx]) 
                        min_idx = j;
                }
                
                // NOTE save state of where the smallest int is at THEN swap it with curr index (i)
                temp = array[min_idx];
                
                // swap
                array[min_idx] = array[i];
                array[i] = temp;
                    
            }
        }
        return array;
    }
}