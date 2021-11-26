import SortingAlgorithms.BubbleSort;
import SortingAlgorithms.SelectionSort;

import java.util.Arrays;
import java.util.Scanner;


public class Array{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // for the sake of time I will add input validation later
        System.out.println("How big should the array be?");
        int input = sc.nextInt();
        // for now fail

        // fill array with random integers of specified size
        int[] int_array = new int[input];
        for(int i = 0; i < int_array.length; ++i) {
            int_array[i] = (int) (Math.random() * 1000);
        }

        // because lazy
        System.out.println(Arrays.toString(int_array));

        // Lets show some sorting algos
        //Log

        
        
        // Bubble Sort
        int[] a = reset(int_array);
        System.out.println("1) Bubble Sort\n");
        printArr(a);
        a = BubbleSort.bubbleSort(a);
        printArr(a);
        
        // Selection Sort
        a = reset(int_array);
        System.out.println("2) Selection Sort\n");
        printArr(a);
        a = SelectionSort.selectionSort(a);  
        printArr(a);
        
        

    }

    // restore back to unsorted state
    public static int[] reset(int[] arr) {

        int[] a = Arrays.copyOf(arr, arr.length);

        return a;
    }
    public static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr) + "\n");
    }
}