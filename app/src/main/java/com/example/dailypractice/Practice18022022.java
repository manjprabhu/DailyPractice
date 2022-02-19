package com.example.dailypractice;

import android.util.Log;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

public class Practice18022022 {

    private final String TAG = Practice18022022.class.getSimpleName();

    void bubbleSort() {
        int a[] = {9, -2, 8, 11, 6, -9, 78, 4, 17, 32};

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

    void maxSumSubArray() {
        int[] a = {-5, 4, 6, -3, 4, -1};
        int cursum = 0, maxsum = 0;

        for ( int i = 0; i < a.length; i++ ) {
            cursum = cursum + a[i];
            if (cursum > maxsum)
                maxsum = cursum;
            if (cursum < 0)
                cursum = 0;
        }
        Log.d(TAG, "maxSumSubArray Kadens algorithm: " + maxsum);
    }

    void kthSmallestElement() {
        int a[] = {9, -2, 8, 11, 6, -9, 78, 4, 17, 32};
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int k = 3;
        for ( int i = 0; i < k; i++ ) {
            queue.add(a[i]);
        }
        for ( int i = k; i < a.length; i++ ) {
            if (queue.peek() > a[i]) {
                queue.poll();
                queue.add(a[i]);
            }
        }
        Log.d(TAG, k + " th Smallest Element is: " + queue.peek());
    }

    void kthLargestElement() {
        int a[] = {9, -2, 8, 11, 6, -9, 78, 4, 17, 32};
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int k = 4;
        for ( int i = 0; i < k; i++ ) {
            queue.add(a[i]);
        }
        for ( int i = k; i < a.length; i++ ) {
            if (queue.peek() < a[i]) {
                queue.poll();
                queue.add(a[i]);
            }
        }
        Log.d(TAG, k + " kth Largest Element: " + queue.peek());
    }

    void selectionSort() {
        int a[] = {9, -2, 8, 11, 6, -9, 78, 4, 17, 32};

        for ( int i = 0; i < a.length; i++ ) {
            int minindex = i;

            for ( int j = i; j < a.length; j++ ) {
                if (a[j] < a[minindex])
                    minindex = j;
            }
            if (i != minindex) {
                int temp = a[minindex];
                a[minindex] = a[i];
                a[i] = temp;
            }
        }
        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "selectionSort: " + a[k]);
        }
    }

    void insertionSort() {
        int a[] = {9, -2, 8, 11, 6, -9, 78, 4, 17, 32};

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

    void previousSmallerElement() {
        int a[] = {9, -2, 8, 11, 6, -9, 78, 4, 17, 32};
        Stack<Integer> stack = new Stack<>();

        for ( int i = 0; i < a.length; i++ ) {
            while (!stack.isEmpty() && stack.peek() > a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "previuosSmallerElement: of " + a[i] + " is:" + -1);
            } else {
                Log.d(TAG, "previuosSmallerElement: of " + a[i] + " is:" + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void iterativeBinarySearch() {
        int a[] = {4, 8, 11, 34, 36, 43, 47, 52, 57, 59};
        int key = 47;
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == a[mid]) {
                Log.d(TAG, "Element " + key + " found at position: " + mid);
                break;
            } else if (key > a[mid])
                low = mid + 1;
            else if (key < a[mid])
                high = mid - 1;
        }
    }

    void fibonacci() {
        int n = 10;
        int i = 0, sum = 0;
        int j = 1;
        int count = 0;
        while (count < n) {
            Log.d(TAG, "fibonacci: " + i);
            sum = i + j;
            i = j;
            j = sum;
            count++;
        }
    }

    void fibonacciRecursion() {
        int n = 10;
        for ( int i = 0; i < n; i++ ) {
            Log.d(TAG, "fibonacciRecursion: " + recursion(i));
        }
    }

    private int recursion(int i) {
        if (i == 0)
            return 0;
        if (i == 1)
            return 1;
        return recursion(i - 1) + recursion(i - 2);
    }

    void reverseWord() {
        String str = " hello this is testing string";
        String a[] = str.split(" ");
        String resumt = "";
        for ( int i = 0; i < a.length; i++ ) {
            resumt = " " + a[i] + resumt;
        }
        Log.d(TAG, "reverseWord: " + resumt);
    }

    void reverseNumber() {
        int num = 134;
        int rev = 0;
        int r = 0;

        while (num > 0) {
            r = num % 10;
            rev = (rev * 10) + r;
            num = num / 10;
        }
        Log.d(TAG, "reverseNumber: " + rev);
    }

    void pairWithGivenSum() {
        int a[] = {10, 5, -15, 13, 20, 15, 12};
        int sum = 25;
        for ( int i = 0; i < a.length - 1; i++ ) {
            for ( int j = i + 1; j < a.length; j++ ) {
                if (a[i] + a[j] == sum) {
                    Log.d(TAG, "pairWithGivenSum: (" + a[i] + "," + a[j] + ")");
                }
            }
        }
    }

    void pairWithGivenSumSolution2() {
        int a[] = {10, 5, -15, 13, 20, 15, 12};
        int sum = 25;

        Arrays.sort(a);

        int i = 0;
        int j = a.length - 1;

        while (i < j) {
            if (a[i] + a[j] < sum)
                i++;
            if (a[i] + a[j] > sum)
                j--;
            if (a[i] + a[j] == sum) {
                Log.d(TAG, "pairWithGivenSum solution2: (" + a[i] + "," + a[j] + ")");
                i++;
                j--;
            }
        }
    }

    void pairWithGivenSumSolution3() {
        int a[] = {10, 5, -15, 13, 20, 15, 12};
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for ( int i = 0; i < a.length; i++ ) {

            if (map.containsKey(sum - a[i])) {
                Log.d(TAG, "pairWithGivenSum solution3: (" + a[i] + "," + a[map.get(sum - a[i])] + ")");
            }
            map.put(a[i], i);
        }
    }

    void subArrayWithZeroSum() {
        int a[] = {1, 5, 7, 9, 12, -4, -8, 20};
        int sum = 0;

        HashSet<Integer> set = new HashSet<>();
        for ( int i = 0; i < a.length; i++ ) {

            sum = sum + a[i];
            if (a[i] == 0 || sum == 0 || set.contains(sum)) {
                Log.d(TAG, "pairWithZeroSum exists: ");
            }
            set.add(sum);
        }
    }
}
