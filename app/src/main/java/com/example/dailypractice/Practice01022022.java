package com.example.dailypractice;

import android.util.Log;

import java.util.Stack;

public class Practice01022022 {

    final String TAG = Practice01022022.class.getSimpleName();

    void nextSmallestElement() {
        int a[] = {10, 2, 54, 3, 65, 21, 45, 32, 10, 11};

        Stack<Integer> stack = new Stack<>();

        for ( int i = a.length - 1; i >= 0; i-- ) {
            while (!stack.isEmpty() && stack.peek() > a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "nextSmallestElement: of is:" + a[i] + " is :" + -1);
            } else {
                Log.d(TAG, "nextSmallestElement: of is:" + a[i] + " is :" + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void iterativeBinarySearch() {

        int a[] = {3, 6, 9, 11, 15, 18, 23, 27, 29, 31, 37, 39, 44, 53, 61, 70, 89};

        int low = 0, high = a.length - 1;
        int key = 31;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (key == a[mid]) {
                Log.d(TAG, "iterativeBinarySearch: Element " + key + " is found at :" + mid);
                return;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else if (key < a[mid]) {
                high = mid - 1;
            }
        }
        Log.d(TAG, "iterativeBinarySearch: Element not found");
    }

    void bubbleSort() {
        int a[] = {10, 2, 54, -3, 65, 21, 45, 32, -10, 11};

        for ( int i = 0; i < a.length; i++ ) {

            for ( int j = 0; j < a.length - i - 1; j++ ) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "bubbleSort: " + a[k]);
        }
    }

    void insertionSort() {
        int a[] = {10, 2, 54, -3, 65, 21, 45, 32, -10, 11};

        for ( int i = 1; i < a.length; i++ ) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }

        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "insertionSort: " + a[k]);
        }
    }

    void selectionSort() {
        int a[] = {10, 2, 54, -3, 65, 21, 45, 32, -10, 11};

        for ( int i = 0; i < a.length; i++ ) {

            int min_index = i;

            for ( int j = i + 1; j < a.length; j++ ) {
                if (a[j] < a[min_index]) {
                    min_index = j;
                }
            }

            if (i != min_index) {
                int temp = a[i];
                a[i] = a[min_index];
                a[min_index] = temp;
            }
        }

        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "selectionSort: " + a[k]);
        }
    }

    void previousSmallestElement() {
        int a[] = {10, 2, 54, -3, 65, 21, 45, 32, -10, 11};

        Stack<Integer> stack = new Stack<>();

        for ( int i = 0; i < a.length; i++ ) {
            while (!stack.isEmpty() && stack.peek() > a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "previousSmallestElement: of is:" + a[i] + " is :" + -1);
            } else {
                Log.d(TAG, "previousSmallestElement: of is:" + a[i] + " is :" + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void previousLargestElement() {
        int a[] = {10, 2, 54, -3, 65, 21, 45, 32, -10, 11};

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<a.length;i++) {

            while (!stack.isEmpty() && stack.peek() <a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "previousLargestElement: of is:" + a[i] + " is :" + -1);
            } else {
                Log.d(TAG, "previousLargestElement: of is:" + a[i] + " is :" + stack.peek());
            }
            stack.push(a[i]);
        }
    }

}
