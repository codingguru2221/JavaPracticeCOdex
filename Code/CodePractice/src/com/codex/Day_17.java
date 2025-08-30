package com.codex;

import java.util.Arrays;

public class Day_17 {

    // ---------------- QuickSort ----------------
    static class QuickSort {
        public void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);   // sort left
                quickSort(arr, pi + 1, high); // sort right
            }
        }

        private int partition(int[] arr, int low, int high) {
            int pivot = arr[high];  // last element as pivot
            int i = (low - 1);

            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, high);
            return i + 1;
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // ---------------- MergeSort ----------------
    static class MergeSort {
        public void mergeSort(int[] arr, int left, int right) {
            if (left < right) {
                int mid = (left + right) / 2;
                mergeSort(arr, left, mid);       // sort left half
                mergeSort(arr, mid + 1, right); // sort right half
                merge(arr, left, mid, right);   // merge halves
            }
        }

        private void merge(int[] arr, int left, int mid, int right) {
            int n1 = mid - left + 1;
            int n2 = right - mid;

            int[] L = new int[n1];
            int[] R = new int[n2];

            for (int i = 0; i < n1; i++)
                L[i] = arr[left + i];
            for (int j = 0; j < n2; j++)
                R[j] = arr[mid + 1 + j];

            int i = 0, j = 0, k = left;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }

            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
    }

    // ---------------- Main method to test ----------------
    public static void main(String[] args) {
        int[] arr1 = {34, 7, 23, 32, 5, 62};
        int[] arr2 = arr1.clone();

        QuickSort qs = new QuickSort();
        qs.quickSort(arr1, 0, arr1.length - 1);
        System.out.println("QuickSort Result: " + Arrays.toString(arr1));

        MergeSort ms = new MergeSort();
        ms.mergeSort(arr2, 0, arr2.length - 1);
        System.out.println("MergeSort Result: " + Arrays.toString(arr2));
    }
}
