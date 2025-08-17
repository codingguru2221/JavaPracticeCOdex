package com.codex;

import java.util.Arrays;

class ExampleArray {
    // 1D Array
    int[] arr;          // preferred
    int arr1[];         // also valid

    // 2D Array
    int[][] matrix;     // preferred
    int matrix1[][];    // also valid
}

public class Day_05 {
    public static void main(String[] args) {
        // 1D Array example
        int[] numbers = {5, 2, 9, 1, 7};
        System.out.println("1D Array: " + Arrays.toString(numbers));

        // Sort the array
        Arrays.sort(numbers);
        System.out.println("Sorted 1D Array: " + Arrays.toString(numbers));

        // Binary search (array must be sorted)
        int index = Arrays.binarySearch(numbers, 7);
        System.out.println("Index of 7: " + index);

        // Fill example
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 10);
        System.out.println("Filled Array: " + Arrays.toString(filledArray));

        // Copy array
        int[] copyArray = Arrays.copyOf(numbers, 7);
        System.out.println("Copied Array: " + Arrays.toString(copyArray));

        // Equals check
        int[] checkArray = {1, 2, 5, 7, 9};
        System.out.println("Arrays equal? " + Arrays.equals(numbers, checkArray));

        // 2D Array example
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("2D Array: " + Arrays.deepToString(matrix));
    }
}
