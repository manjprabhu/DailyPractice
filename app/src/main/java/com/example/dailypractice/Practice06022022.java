package com.example.dailypractice;

import android.util.Log;

import java.util.Stack;

public class Practice06022022 {

    private final String TAG = Practice06022022.class.getSimpleName();

    void nextSmallestElement() {

        int arr[] = {10, 3, 6, 21, 656, 2, 4, 1, 8, 11};
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "nextSmallestElement: of " + arr[i] + " is :" + -1);
            } else {
                Log.d(TAG, "nextSmallestElement: of " + arr[i] + " is :" + stack.peek());
            }
            stack.push(arr[i]);
        }
    }

    void previousLargestElement() {
        int arr[] = {10, 3, 6, 21, 656, 2, 4, 1, 8, 11};
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "previousLargestElement: of  " + arr[i] + " is :" + -1);
            } else {
                Log.d(TAG, "previousLargestElement: " + arr[i] + " is :" + stack.peek());
            }
            stack.push(arr[i]);
        }
    }

    void nextLargestElement() {
        int arr[] = {10, 3, 6, 21, 656, 2, 4, 1, 8, 11};
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "nextLargestElement: of  " + arr[i] + " is :" + -1);
            } else {
                Log.d(TAG, "nextLargestElement: " + arr[i] + " is :" + stack.peek());
            }
            stack.push(arr[i]);
        }
    }

    void previousSmallest() {
        int arr[] = {10, 3, 6, 21, 656, 2, 4, 1, 8, 11};
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length - 1; i++) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "previousSmallest: of  " + arr[i] + " is :" + -1);
            } else {
                Log.d(TAG, "previousSmallest: of " + arr[i] + " is :" + stack.peek());
            }
            stack.push(arr[i]);
        }
    }

    void selectionSort() {

        int arr[] = {10, 3, 6, 21, 656, 2, 4, 1, 8, 11};

        for (int i = 0; i < arr.length; i++) {
            int min_index = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }

            if (i != min_index) {
                int temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;
            }

        }

        for (int k = 0; k < arr.length; k++) {
            Log.d(TAG, "selectionSort: " + arr[k]);
        }
    }

    void bubbleSort() {
        int a[] = {9, 32, -1, 5, 1, 8, 22, 16, 9, -9};

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for (int k = 0; k < a.length; k++) {
            Log.d(TAG, "bubbleSort: " + a[k]);
        }
    }

    void insertionSort() {
        int a[] = {9, 32, -1, 5, 1, 8, 22, 16, 9, -9};

        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
        for (int k = 0; k < a.length; k++) {
            Log.d(TAG, "insertionSort: " + a[k]);
        }
    }

    void StartQuickSort() {
        int a[] = {91, 32, -1, 5, 1, 8, 22, 16, 9, -9};
        int low = 0;
        int high = a.length - 1;

        quickSort(low, high, a);

        for (int k = 0; k < a.length; k++) {
            Log.d(TAG, "StartQuickSort: " + a[k]);
        }

    }

    private void quickSort(int low, int high, int[] a) {

        if (low < high) {
            int pos = partition(low, high, a);
            quickSort(low, pos - 1, a);
            quickSort(pos + 1, high, a);
        }
    }

    private int partition(int low, int high, int[] a) {
        int i = low;
        int j = high;
        int pivot = a[low];


        while (i < j) {
            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[j];
        a[j] = pivot;
        pivot = temp;
        return j;
    }

    void binarySearch() {
        int a[] = {2, 5, 8, 10, 13, 17, 21, 26, 35, 38};
        int i = 0;
        int j = a.length - 1;
        int pos = recursiveBinarySearch(i, j, a);

        if (pos == -1) {
            Log.d(TAG, "binarySearch: Element not found");
        } else {
            Log.d(TAG, "binarySearch: Element found at:" + pos);
        }
    }

    private int recursiveBinarySearch(int low, int high, int a[]) {

        int key = 21;
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == a[mid]) {
                return mid;
            } else if (key > a[mid]) {
                return recursiveBinarySearch(mid + 1, high, a);
            } else if (key < a[mid]) {
                return recursiveBinarySearch(low, mid - 1, a);
            }
        }
        return -1;
    }

    private int iterativeBinarySearch() {
        int a[] = {2, 5, 8, 10, 13, 17, 21, 26, 35, 38};
        int key = 111;

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == a[mid]) {
                Log.d(TAG, "iterativeBinarySearch: Element " + key + " is found at:" + mid);
                ;
                return mid;
            } else if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }

    void palindromeUsingRecursion() {
        String str = "malayalam";

        int l = 0;
        int r = str.length() - 1;
        boolean ispalidrome = isPalindrome(l, r, str);
        if (ispalidrome) {
            Log.d(TAG, "palindromeUsingRecursion: String  " + str + "  is palindrome:");
        } else {
            Log.d(TAG, "palindromeUsingRecursion: String " + str + "is NOT palindrome:");
        }
    }

    private boolean isPalindrome(int l, int r, String str) {
        if (str.charAt(l) != str.charAt(r)) {
            return false;
        }
        if (l >= r) {
            return true;
        }
        return isPalindrome(l + 1, r - 1, str);
    }

    void fibbonacci() {
        int n = 10;
        int i = 0;
        int j = 1;

        int sum = 0;
        int count = 0;

        while (count < n) {
            Log.d(TAG, "fibbonaci: Iterative:" + i);
            sum = i + j;
            i = j;
            j = sum;
            count = count + 1;
        }
    }

    void fibbonaciRecursive() {
        int n = 10;
        int i = 0;
        int j = 1;

        for (int k = 0; k < n; k++) {
            int x = fRecursion(k);
            Log.d(TAG, "fibbonaciRecursive: :" + x);
        }
    }

    private int fRecursion(int i) {
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else {
            return fRecursion(i - 1) + fRecursion(i - 2);
        }
    }

}
