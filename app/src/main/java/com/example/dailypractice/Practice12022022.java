package com.example.dailypractice;

import android.util.Log;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Practice12022022 {

    private final String TAG = Practice12022022.class.getSimpleName();

    void nextSmallestElement() {

        int a[] = {19, 3, 64, 2, 56, 71, 89, 90, 19};
        Stack<Integer> stack = new Stack<>();

        for ( int i = a.length - 1; i >= 0; i-- ) {

            while (!stack.isEmpty() && stack.peek() > a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "nextSmallestElement of ->" + a[i] + " is " + -1);
            } else {
                Log.d(TAG, "nextSmallestElement of ->" + a[i] + " is " + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void previousSmallestElement() {
        int a[] = {19, 3, 64, 2, 56, 71, 89, 90, 19};

        Stack<Integer> stack = new Stack<>();

        for ( int i = 0; i < a.length; i++ ) {
            while (!stack.isEmpty() && stack.peek() > a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "previousSmallestElement: of ->" + a[i] + " is:" + -1);
            } else {
                Log.d(TAG, "previousSmallestElement of ->" + a[i] + " is " + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void previousLargestElement() {
        int a[] = {19, 3, 64, 2, 56, 71, 89, 90, 19};
        Stack<Integer> stack = new Stack<>();

        for ( int i = 0; i < a.length; i++ ) {
            while (!stack.isEmpty() && stack.peek() < a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "previousLargestElement: of ->" + a[i] + " is:" + -1);
            } else {
                Log.d(TAG, "previousLargestElement of ->" + a[i] + " is " + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void nextLargestElement() {
        int a[] = {19, 3, 64, 2, 56, 71, 89, 90, 19};
        Stack<Integer> stack = new Stack<>();

        for ( int i = a.length - 1; i >= 0; i-- ) {
            while (!stack.isEmpty() && stack.peek() < a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "nextLargestElement: of ->" + a[i] + " is:" + -1);
            } else {
                Log.d(TAG, "nextLargestElement of ->" + a[i] + " is " + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void kthSmallestElement() {
        int a[] = {19, 3, 64, 2, 56, 71, 89, 90};
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int k = 4;

        for ( int i = 0; i < k; i++ ) {
            queue.add(a[i]);
        }
        for ( int i = k; i < a.length; i++ ) {
            if (queue.peek() > a[i]) {
                queue.poll();
                queue.add(a[i]);
            }
        }
        Log.d(TAG, "kthSmallestElement: " + queue.peek());
    }

    void kthLargestElement() {
        int a[] = {19, 3, 64, 2, 56, 71, 89, 90};
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int k = 3;

        for ( int i = 0; i < k; i++ ) {
            queue.add(a[i]);
        }

        for ( int i = k; i < a.length; i++ ) {
            if (queue.peek() < a[i]) {
                queue.poll();
                queue.add(a[i]);
            }
        }
        Log.d(TAG, "kthLargestElement: " + queue.peek());
    }

    void maxSumSubArray() {
        int a[] = {2, 7, -8, 34, -2, 7, -10, 4, -6, 7};

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
        Log.d(TAG, "maxSumSubArray: " + maxSum);
    }

    void iterativeBinarySearch() {

        int a[] = {5, 8, 9, 10, 13, 16, 19, 23, 27, 29, 31, 38, 39};

        int key = 16;

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (key == a[mid]) {
                Log.d(TAG, "Element " + key + " found at position: " + mid);
                return;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else if (key < a[mid]) {
                high = mid - 1;
            }
        }
    }

    void selectionSort() {
        int a[] = {10, 4, 8, 11, 45, 32, -8, -19, 7, 73, 91, 82, 6};

        for ( int i = 0; i < a.length; i++ ) {
            int min_index = i;

            for ( int j = i; j < a.length; j++ ) {
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
        int a[] = {10, 4, 8, 11, 45, 32, -8, -19, 7, 73, 91, 82, 6};

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

    void bubbleSort() {
        int a[] = {10, 4, 8, 11, 45, 32, -8, -19, 7, 73, 91, 82, 6};

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

    void startQuickSort() {
        int a[] = {10, 4, 8, 11, 45, 32, -8, -19, 7, 73, 91, 82, 6};

        int low = 0;
        int high = a.length - 1;

        quickSort(low, high, a);

        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "startQuickSort: " + a[k]);
        }

    }

    private void quickSort(int low, int high, int a[]) {

        if (low < high) {
            int pos = partition(low, high, a);
            quickSort(low, pos - 1, a);
            quickSort(pos + 1, high, a);
        }
    }

    private int partition(int low, int high, int a[]) {
        int i = low;
        int j = high;

        int pivot = a[high];

        while (i < j) {

            while (a[i] > pivot) {
                i++;
            }

            while (a[j] < pivot) {//reverse order sort
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
        int a[] = {10, 4, 8, 11, 45, 32, -8, -19, 7, 73, 91, 82, 6};

        int low = 0;
        int high = a.length - 1;

        mergeSort(low, high, a);

        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "startMergeSort: " + a[k]);
        }
    }

    private void mergeSort(int low, int high, int a[]) {

        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid, a);
            mergeSort(mid + 1, high, a);
            merge(low, high, mid, a);
        }
    }

    private void merge(int low, int high, int mid, int a[]) {

        int i = low;
        int j = mid + 1;
        int k = low;
        int b[] = new int[a.length];

        while (i <= mid && j <= high) {

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
            while (j <= high) {
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

        for ( int m = low; m <= high; m++ ) {
            a[m] = b[m];
        }
    }

    void firstNonRepeatingChar() {
        String str = "abcdedadjsces";

        for ( int i = 0; i < str.length(); i++ ) {
            for ( int j = 0; j < str.length(); j++ ) {
                if (str.charAt(i) == str.charAt(j) && i != j) {
                    break;
                }
                if (j == str.length() - 1) {
                    Log.d(TAG, "firstNonRepeatingChar: " + str.charAt(i));
                    return;
                }
            }
        }
    }

    void firstRepeatingChar() {
        String str = "abcdeadjsces";

        HashSet<Character> set = new HashSet<>();
        for ( int i = 0; i < str.length(); i++ ) {

            if (!set.add(str.charAt(i))) {
                Log.d(TAG, "firstRepeatingChar: " + str.charAt(i));
                return;
            }
        }
    }

    void frequencyOfChar() {
        String str = "abcdefedba";

        int count[] = new int[256];

        for ( int i = 0; i < str.length(); i++ ) {
            count[str.charAt(i)]++;
        }

        for ( int i = 0; i < str.length(); i++ ) {
            Log.d(TAG, "Character " + str.charAt(i) + " occurred " + count[str.charAt(i)] + " times");
        }
    }

    void frequencyOfElement() {
        int a[] = {10, 3, 6, 71, 81, 6, 8, 25, 6, 7};
        HashMap<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < a.length; i++ ) {
            int count;
            if (map.containsKey(a[i])) {
                count = map.get(a[i]);
                count++;
                map.put(a[i], count);
            } else {
                map.put(a[i], 1);
            }
        }
        for ( Map.Entry entry : map.entrySet() ) {
            Log.d(TAG, "frequencyOfElement: " + entry.getKey() + " times:" + entry.getValue());
        }
    }

    void reverseWord() {
        String str = "hello this testing";

        String[] s = str.split(" ");

        String result = "";

        for ( int i = 0; i < s.length; i++ ) {

            result =  " " + s[i] +  result+ " ";
        }

        Log.d(TAG, "reverseWord: "+ result);
    }


}
