package SortingAlgorithms;
//finally something fast 


// tip do not worry about the numbers in the array we are only concerned with distances and indexes which cannot be changed
// their values within can change but index 0 will always be index 0
public class MergeSort {

    // merge sort is divide and conquer algo that uses recursion to divide and conquers from the bottom of the recustion tree to the top 

    // I want the user to be abstracted from the understanding so only accept an array
    public static int[] mergeSort(int[] arr) {

        // lets take this slow
        // you have the array now get the indicies in question beginning and end
        // these are done by index
        int start = 0;  //start
        int end = arr.length-1; //end
        sort(arr,start,end);
        return arr;
    }

    // its funny because the merge function does all the sorting
    static void sort(int[] arr, int start, int end) {

        //find the median of the array
        if( start < end) {
            int mid = start + (end-start) /2;  // clever math: we want the distance(hi-low) then divide by 2 but wait... were working with POSITIONS
                                          // NOT numbers we want the middle POSITION not number. Remember this when you implement it. This is why we add L back in.
            
            // divide until you cant anymore (refer to line 21) base case: array with one item is sorted.
            sort(arr, start, mid);
            sort(arr, mid+1, end);

            //conquer
            merge(arr,start,mid,end);
        }
    }

    // merges sub arrays together
    static void merge(int[] arr, int start, int mid, int end) {

        //find sub array sizes
        int size1 = mid-start +1; // [0,1,2]=3;  = 1-0+1 = 2 REMEMBER [0,1] = 2 ITEMS NOT NUMBERS
        int size2 = end- mid;    // 3-2 = 1 <- we considered mid in the line above dont over count.
        
        /* I should be more explicit! You are getting the length of the subarray
        /  Implication: the starting index counts so you need to add it back in.
        /  So 3-0 = 3 yes the distance between index 0 and 3 but we are EXPLICITLY
        /   trying to get the SIZE of the array here not the distance. 0->1->2->3 = 4 items = size = 4
        /  Remember the difference between distance between indices and size of an array and this algorithm is
        /  easy. Ex 3-2 = 1 distance 3-2+1 = 2 size 
        */

        // create two temp arrays
        int left[] = new int[size1]; //the left size of our merged array
        int right[] = new int[size2];
        
        //Copy into temp

        // Did you forget we were starting at low (index)? indexes not numbers!
        for(int i =0; i< left.length; ++i)
            left[i] = arr[start+i];
        for(int i = 0; i < right.length; ++i)
            right[i] = arr[mid+1 +i];       //look at line 44 if confused
        
        //MERGE!!!

        //3 pointers REMEMBER indexes! (i for left, j for right, k for arr) arr= the original array 
        int i = 0, j = 0, k=start;

        // iterate until one of our points hits the end
        while(i < left.length && j < right.length) {
            
            // sort
            // if the number in left is smaller insert it into our original arr
            if(left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            
            // else put the right in our orig arr
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // pump the rest of the values into place the loop above results in one array being completely copied 
        // but not the other

        while(i < left.length) { // this will run
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j < right.length) { // or this will run
            arr[k] = right[j];
            j++;
            k++;
        }

        // easy right?
    }
}