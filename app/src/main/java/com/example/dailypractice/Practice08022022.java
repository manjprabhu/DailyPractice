package com.example.dailypractice;

import android.util.Log;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Practice08022022 {

    private final String TAG = Practice08022022.class.getSimpleName();

    void nextGreatestElement() {
        int a[] = {9, 4, 11, 6, 23, 54, 2, 9, 19, 51, 27};
        Stack<Integer> stack = new Stack<>();
        for ( int i = a.length - 1; i >= 0; i-- ) {
            while (!stack.isEmpty() && stack.peek() < a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "nextGreatestElement: of " + a[i] + " is: " + -1);
            } else {
                Log.d(TAG, "nextGreatestElement: of " + a[i] + " is: " + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void previousSmallestElement() {
        int a[] = {9, 4, 11, 6, 23, 54, 2, 9, 19, 51, 27};
        Stack<Integer> stack = new Stack<>();

        for ( int i = 0; i < a.length; i++ ) {
            while (!stack.isEmpty() && stack.peek() > a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "previousSmallestElement: of " + a[i] + " is :" + -1);
            } else {
                Log.d(TAG, "previousSmallestElement: of " + a[i] + " is :" + stack.peek());
            }

            stack.push(a[i]);
        }
    }

    void nextSmallestElement() {
        int a[] = {9, 4, 11, 6, 23, 54, 2, 9, 19, 51, 27};
        Stack<Integer> stack = new Stack<>();

        for ( int i = a.length - 1; i >= 0; i-- ) {
            while (!stack.isEmpty() && stack.peek() > a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "nextSmallestElement: of " + a[i] + " is :" + -1);
            } else {
                Log.d(TAG, "nextSmallestElement: of " + a[i] + " is :" + stack.peek());
            }

            stack.push(a[i]);
        }
    }

    void previousGreatestElement() {
        int a[] = {9, 4, 11, 6, 23, 54, 2, 9, 19, 51, 27};
        Stack<Integer> stack = new Stack<>();

        for ( int i = 0; i < a.length; i++ ) {
            while (!stack.isEmpty() && stack.peek() < a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "previousGreatestElement: of " + a[i] + " is:" + -1);
            } else {
                Log.d(TAG, "previousGreatestElement: of " + a[i] + " is:" + stack.peek());
            }

            stack.push(a[i]);
        }
    }

    void bubbleSort() {
        int a[] = {9, 4, 11, 6, 23, 54, 2, 9, 19, 51, 27};

        for ( int i = 0; i < a.length; i++ ) {
            for ( int j = 0; j < a.length - 1 - i; j++ ) {
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

    void selectionSort() {
        int a[] = {9, -4, 11, -6, 23, -54, 2, -9, 19, -51, 27};
        for ( int i = 0; i < a.length; i++ ) {
            int min_index = i;
            for ( int j = i + 1; j < a.length; j++ ) {
                if (a[j] < a[min_index]) {
                    min_index = j;
                }
            }
            if (i != min_index) {
                int temp = a[min_index];
                a[min_index] = a[i];
                a[i] = temp;
            }
        }

        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "selectionSort: " + a[k]);
        }
    }

    void insertionSort() {
        int a[] = {9, -4, 11, 6, 23, 54, 2, -9, 19, -51, 27};

        for ( int i = 1; i < a.length; i++ ) {

            int j = i - 1;
            int key = a[i];

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

    void startQuickSort() {
        int a[] = {9, -4, 11, 6, 23, 54, 2, -9, 19, -51, 27};

        int low = 0;
        int high = a.length - 1;

        quicksort(low, high, a);
        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "startQuickSort: " + a[k]);
        }

    }

    private void quicksort(int low, int high, int a[]) {
        if (low < high) {
            int pos = partition(low, high, a);
            quicksort(low, pos - 1, a);
            quicksort(pos + 1, high, a);
        }
    }

    private int partition(int low, int high, int a[]) {
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

    void startMergeSort() {
        int a[] = {9, -4, 11, 6, 23, 54, 2, -9, 19, -51, 27};
        int l = 0;
        int r = a.length - 1;
        mergeSort(l, r, a);

        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "startMergeSort: " + a[k]);
        }
    }

    private void mergeSort(int l, int r, int a[]) {

        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(l, mid, a);
            mergeSort(mid + 1, r, a);
            merge(l, r, mid, a);
        }
    }

    private void merge(int l, int r, int mid, int a[]) {

        int b[] = new int[a.length];
        int i = l;
        int j = mid + 1;
        int k = l;

        while (i <= mid && j <= r) {
            if (a[i] < a[j]) {
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                j++;
            }
            k++;
        }
        if (i > mid) {
            while (j <= r) {
                b[k] = a[j];
                j++;
                k++;
            }
        } else {
            while (i <= mid) {
                b[k] = a[i];
                i++;
                k++;
            }
        }

        for ( int m = l; m < r; m++ ) {
            a[m] = b[m];
        }
    }

    void largestSumSubArrayKadane() {
        int[] a = {-5, 4, 6, -3, 4, -1};

        int maxSum = 0;
        int curSum = 0;

        for ( int i = 0; i < a.length; i++ ) {
            curSum = curSum + a[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) {
                curSum = 0;
            }
        }
        Log.d(TAG, "largestSumSubArrayKadane: " + maxSum);
    }

    void largestSumSubArray() {
        int[] a = {-5, 4, 6, -3, 4, -1};
        int maxsum = Integer.MIN_VALUE;

        for ( int i = 0; i < a.length; i++ ) {
            int cursum = 0;

            for ( int j = i; j < a.length; j++ ) {
                cursum = cursum + a[j];
                if (cursum > maxsum) {
                    maxsum = cursum;
                }
            }

        }
        Log.d(TAG, "largestSumSubArray: " + maxsum);
    }

    void kthLargestElement() {
        int a[] = {9, -4, 11, 6, 23, 54, 2, -9, 19, -51, 27};
        int k = 5;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for ( int i = 0; i < k; i++ ) {
            queue.add(a[i]);
        }
        for ( int j = k; j < a.length; j++ ) {
            if (queue.peek() < a[j]) {
                queue.poll();
                queue.add(a[j]);
            }
        }
        Log.d(TAG, "kthLargestElement: " + queue.peek());
    }

    void kthSmallestElement() {
        int a[] = {9, -4, 11, 6, 23, 54, 2, -9, 19, -51, 27};
        int k = 3;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for ( int i = 0; i < k; i++ ) {
            queue.add(a[i]);
        }
        for ( int j = k; j < a.length; j++ ) {

            if (queue.peek() > a[j]) {
                queue.poll();
                queue.add(a[j]);
            }
        }
        Log.d(TAG, "kthSmallestElement: " + queue.peek());
    }

    void palindromeRecusrion() {
        String str = "dfdjsadjg";
        int l = 0;
        int r = str.length() - 1;

        boolean isPalindrome = reverse(l, r, str);
        if (isPalindrome) {
            Log.d(TAG, "String  " + str + " is palindrome");
        } else {
            Log.d(TAG, "String  " + str + " is NOT palindrome");
        }
    }

    private boolean reverse(int l, int r, String str) {
        if (str.charAt(l) != str.charAt(r)) {
            return false;
        }
        if (l >= r) {
            return true;
        }
        return reverse(l + 1, r - 1, str);
    }

    void iterativeBinarySearch() {
        int a[] = {3, 7, 9, 11, 23, 27, 31, 37, 45, 47, 71, 79};

        int low = 0;
        int high = a.length - 1;
        int key = 111;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (key == a[mid]) {
                Log.d(TAG, "iterativeBinarySearch: Element " + key + " found at position: " + mid);
                return;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else if (key < a[mid]) {
                high = mid - 1;
            } else {
                Log.d(TAG, "iterativeBinarySearch: Element " + key + " not found");
            }
        }
    }

    void startBinarySearch() {
        int a[] = {3, 7, 9, 11, 23, 27, 31, 37, 45, 47, 71, 79};
        int low = 0;
        int high = a.length - 1;
        int key = 44;
        int result = search(low, high, key, a);

        if (result != -1) {
            Log.d(TAG, "startBinarySearch: Element is found at position:" + result);
        } else {
            Log.d(TAG, "startBinarySearch: element is not present");
        }
    }

    private int search(int low, int high, int key, int a[]) {

        if (low < high) {
            int mid = low + (high - low) / 2;

            if (key == a[mid]) {
                return mid;
            } else if (key > a[mid]) {
                return search(mid + 1, high, key, a);
            } else if (key < a[mid]) {
                return search(low, mid - 1, key, a);
            }
        }
        return -1;
    }
}
