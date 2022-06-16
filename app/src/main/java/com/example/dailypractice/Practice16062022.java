package com.example.dailypractice;

import android.util.Log;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Practice16062022 {
    private final String TAG = Practice16062022.class.getSimpleName();

    void bubbleSort() {
        int[] a = {10, 4, 8, 11, -4, 56, 76, 45, 31, 55};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int k : a) {
            Log.d(TAG, "bubbleSort: " + k);
        }
    }

    void selectionSort() {
        int[] a = {5, 8, 11, 4, 9, 10, -32, 6, 8};
        for (int i = 0; i < a.length; i++) {
            int min_index = i;

            for (int j = i + 1; j < a.length; j++) {
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
        for (int k : a) {
            Log.d(TAG, "selectionSort: " + k);
        }
    }

    void largestNumber() {
        int[] a = {5, 8, 11, 4, 9, 10, 32, 6, 78};
        int largest = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > largest)
                largest = i;
        }
        Log.d(TAG, "Largest Number is: " + largest);
    }

    void smallestNumber() {
        int[] a = {5, 8, 11, 4, 9, 10, 32, -6, 8};
        int smallest = Integer.MAX_VALUE;
        for (int i : a)
            if (i < smallest)
                smallest = i;
        Log.d(TAG, "Smallest Number is : " + smallest);
    }

    void secondLargest() {
        int[] a = {5, 8, 11, 4, 19, 10, 32, 6, 8};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > largest) {
                secondLargest = largest;
                largest = i;
            } else if (i < largest && i > secondLargest) {
                secondLargest = i;
            }
        }
        Log.d(TAG, "Largest Number is :" + largest + " Second Largest number is: " + secondLargest);
    }

    void secondSmallestNumber() {
        int[] a = {5, 8, 11, -4, 9, 10, 32, 6, -8};
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i : a) {
            if (i < smallest) {
                secondSmallest = smallest;
                smallest = i;
            } else if (i > smallest && i < secondSmallest) {
                secondSmallest = i;
            }
        }

        Log.d(TAG, "Smallest Number is :" + smallest + " Second Smallest number is: " + secondSmallest);
    }

    void kthSmallestElement() {
        int[] a = {5, 18, -11, 4, 9, 10, 32, 6, 28};
        int k = 4;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            queue.add(a[i]);
        }
        for (int i = k; i < a.length; i++) {
            if (queue.peek() > a[i]) {
                queue.poll();
                queue.add(a[i]);
            }
        }
        Log.d(TAG, k + " th Smallest Element is: " + queue.peek());
    }

    void kthLargestElement() {
        int[] a = {5, 8, 11, 4, 9, 10, 32, 6, 8};
        int k = 3;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.add(a[i]);
        }
        for (int i = k; i < a.length; i++) {
            if (queue.peek() < a[i]) {
                queue.poll();
                queue.add(a[i]);
            }
        }
        Log.d(TAG, k + " th Largest Element is: " + queue.peek());
    }

    void previousLargerElement() {
        int[] a = {10, 4, 8, 11, -4, -56, 76, 45, 31, 55};
        Stack<Integer> stack = new Stack<>();
        for (int j : a) {
            while (!stack.isEmpty() && stack.peek() < j)
                stack.pop();

            if (stack.isEmpty()) {
                Log.d(TAG, "Previous Larger Element of " + j + " is :" + -1);
            } else {
                Log.d(TAG, "Previous Larger Element of " + j + " is :" + stack.peek());
            }
            stack.push(j);
        }
    }

    void nextLargerElement() {
        int[] a = {10, 4, 8, 11, -4, -56, 76, 45, 31, 55};
        Stack<Integer> stack = new Stack<>();
        for (int i = a.length - 1; i > -0; i--) {
            while (!stack.isEmpty() && stack.peek() < a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "Next Larger Element of " + a[i] + " is :" + -1);
            } else {
                Log.d(TAG, "Next Larger Element of " + a[i] + " is :" + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void previousSmallerElement() {
        int[] a = {10, 4, 8, 11, -4, -56, 76, 45, 31, 55};
        Stack<Integer> stack = new Stack<>();
        for (int j : a) {
            while (!stack.isEmpty() && stack.peek() > j) {
                stack.pop();
            }
            if (stack.isEmpty())
                Log.d(TAG, "Previous Smaller Element of " + j + " is :" + -1);
            else
                Log.d(TAG, "Previous Smaller Element of " + j + " is :" + stack.peek());
            stack.push(j);
        }
    }

    void nextSmallerElement() {
        int[] a = {10, 4, 8, 11, -4, 56, 76, 45, 31, 55};
        Stack<Integer> stack = new Stack<>();
        for (int i = a.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > a[i])
                stack.pop();
            if (stack.isEmpty())
                Log.d(TAG, "Next Smaller Element of " + a[i] + " is :" + -1);
            else
                Log.d(TAG, "Next Smaller Element of " + a[i] + " is :" + stack.peek());
            stack.push(a[i]);
        }
    }

    void reverseNumber() {
        int num = 194;
        int reverse = 0, r = 0;
        while (num > 0) {
            r = num % 10;
            reverse = reverse * 10 + r;
            num = num / 10;
        }
        Log.d(TAG, "Reverse Number is: " + reverse);
    }

    void sumOfDigits() {
        int num = 6231;
        int backup = num;
        int sum = 0, r = 0;
        while (num > 0) {
            r = num % 10;
            sum = sum + r;
            num = num / 10;
        }
        Log.d(TAG, "Sum Of Digits of " + backup + " is :" + sum);
    }

    void linearSearch() {
        int[] a = {49, 1, 10, 5, -3, 84, 73, 71, 39, 45, 65};
        int key = 49;
        for (int i = 0; i < a.length; i++) {

            if (a[i] == key) {
                Log.d(TAG, "Linear search ==>> Element " + key + " found at position: " + i);
                return;
            }
        }
        Log.d(TAG, "Linear search ==>> Element " + key + " not found");
    }

    // Need to check for some inputs
    void iterativeBinarySearch() {
        int[] a = {49, 1, 10, 5, -3, 84, 73, 71, 39, 45, 65};
        int key = 71;
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (key == a[mid]) {
                Log.d(TAG, "Iterative Binary Search: element " + key + " found at postion :" + mid);
                return;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else if (key < a[mid]) {
                high = mid - 1;
            }
        }
        Log.d(TAG, "Iterative Binary Search search ==>> Element " + key + " not found");
    }

}
