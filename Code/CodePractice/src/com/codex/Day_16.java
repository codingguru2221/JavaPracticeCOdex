package com.codex;

// 📌 Day 16: Binary Search Variations
public class Day_16 {
    public static void main(String[] args) {
        System.out.println("Binary Search Variations - Day 16");

        // Run some sample tests
        int[] arr = {2, 4, 4, 4, 8, 10, 12, 14};

        System.out.println("Standard Binary Search: " + StandardBinarySearch.binarySearch(arr, 10));
        System.out.println("First Occurrence: " + FirstOccurrence.firstOccurrence(arr, 4));
        System.out.println("Last Occurrence: " + LastOccurrence.lastOccurrence(arr, 4));
        System.out.println("Count Occurrences: " + CountOccurrences.countOccurrences(arr, 4));

        int[] rotated = {6, 7, 9, 1, 2, 3, 5};
        System.out.println("Rotated Array Search: " + RotatedBinarySearch.search(rotated, 3));

        System.out.println("Square Root of 40: " + SquareRootBinarySearch.squareRoot(40));
    }
}

// 1. Standard Binary Search
class StandardBinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}

// 2. First Occurrence
class FirstOccurrence {
    public static int firstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return result;
    }
}

// 3. Last Occurrence
class LastOccurrence {
    public static int lastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return result;
    }
}

// 4. Count Occurrences
class CountOccurrences {
    static int firstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return result;
    }

    static int lastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return result;
    }

    public static int countOccurrences(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        if (first == -1) return 0;
        int last = lastOccurrence(arr, target);
        return last - first + 1;
    }
}

// 5. Rotated Array Search
class RotatedBinarySearch {
    public static int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;

            if (arr[low] <= arr[mid]) { // Left sorted
                if (target >= arr[low] && target < arr[mid]) high = mid - 1;
                else low = mid + 1;
            } else { // Right sorted
                if (target > arr[mid] && target <= arr[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}

// 6. Square Root Binary Search
class SquareRootBinarySearch {
    public static int squareRoot(int n) {
        int low = 0, high = n, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;
            if (square == n) return mid;
            if (square < n) {
                ans = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        return ans;
    }
}
