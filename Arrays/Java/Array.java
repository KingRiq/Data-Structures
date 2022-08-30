import java.util.Arrays;
import java.util.Scanner;

import SortingAlgorithms.*;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // for the sake of time I will add input validation later
        System.out.println("How big should the array be?");
        int input = sc.nextInt();
        // for now fail

        // fill array with random integers of specified size
        int[] int_array = new int[input];
        for (int i = 0; i < int_array.length; ++i) {
            int_array[i] = (int) (Math.random() * 1000);
        }

        // because lazy
        System.out.println(Arrays.toString(int_array) + "\n");

        // Lets show some sorting algos
        // Log

        long startTime, endTime, duration;

        int[] a = reset(int_array);
        int toSeconds = 1000000;
        // Bubble Sort
        System.out.println("1) Bubble Sort\n");
        // printArr(a);
        startTime = System.nanoTime();
        a = BubbleSort.bubbleSort(a);
        endTime = System.nanoTime();
        duration = endTime - startTime;// 1000000
        // printArr(a);
        System.out.println("This Took " + duration + " nanoseconds");
        System.out.println("Or " + (double) duration / toSeconds + "seconds");

        // Selection Sort
        a = reset(int_array);
        System.out.println("2) Selection Sort\n");
        // printArr(a);
        startTime = System.nanoTime();
        a = SelectionSort.selectionSort(a);
        endTime = System.nanoTime();
        duration = endTime - startTime;// 1000000
        // printArr(a);
        System.out.println("This Took " + duration + " nanoseconds");
        System.out.println("Or " + (double) duration / toSeconds + "seconds");

        // Insertion Sort
        a = reset(int_array);
        System.out.println("3) Insertion Sort\n");
        // printArr(a);
        startTime = System.nanoTime();
        a = InsertionSort.insertionSort(a);
        endTime = System.nanoTime();
        duration = endTime - startTime;// 1000000
        // printArr(a);
        System.out.println("This Took " + duration + " nanoseconds");
        System.out.println("Or " + (double) duration / toSeconds + "seconds");

        // Merge Sort
        a = reset(int_array);
        System.out.println("4) Merge Sort\n");
        // printArr(a);
        startTime = System.nanoTime();
        a = MergeSort.mergeSort(a);
        endTime = System.nanoTime();
        duration = endTime - startTime;// 1000000
        // printArr(a);
        System.out.println("This Took " + duration + " nanoseconds");
        System.out.println("Or " + (double) duration / toSeconds + "seconds\n");

        // Quick Sort
        a = reset(int_array);
        System.out.println("4) Quick Sort\n");
        // printArr(a);
        startTime = System.nanoTime();
        a = QuickSort.quickSort(a);
        endTime = System.nanoTime();
        duration = endTime - startTime;// 1000000
        // printArr(a);
        System.out.println("This Took " + duration + " nanoseconds");
        System.out.println("Or " + (double) duration / toSeconds + "seconds\n");

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
