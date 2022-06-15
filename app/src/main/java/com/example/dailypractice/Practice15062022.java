package com.example.dailypractice;

import android.util.Log;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Practice15062022 {
    private final String TAG = Practice15062022.class.getSimpleName();

    void bubbleSort() {
        int[] a = {6, 8, 11, 3, 98, 21, 99, 4, 69};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++)
            Log.d(TAG, "bubbleSort: " + a[i]);
    }

    void kthLargestElement() {
        int[] a = {6, 8, 11, 3, 98, 21, 99, 4, 69};
        int k = 4;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            queue.add(a[i]);
        for (int i = k; i < a.length; i++) {
            if (queue.peek() < a[i]) {
                queue.poll();
                queue.add(a[i]);
            }
        }
        Log.d(TAG, k + " th Largest Element is: " + queue.peek());
    }

    void kthSmallestElement() {
        int[] a = {6, 8, 11, 3, 98, 21, 99, 4, 69};
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
        Log.d(TAG, k + " th Smallest Element: " + queue.peek());
    }

    void smallestElement() {
        int[] a = {6, 8, 11, 3, 98, 21, 99, 4, 69};
        int smallest = Integer.MAX_VALUE;
        for (int j : a) {
            if (j < smallest)
                smallest = j;
        }
        Log.d(TAG, "Smallest Element is: " + smallest);
    }

    void largestElement() {
        int[] a = {6, 8, 11, 3, 98, 21, 99, 4, 69};
        int largest = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > largest)
                largest = i;
        }
        Log.d(TAG, "Largest Element is: " + largest);
    }

    void previousSmallestElement() {
        int[] a = {6, 8, 11, 3, 98, 21, 99, 4, 69};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && stack.peek() > a[i])
                stack.pop();
            if (stack.isEmpty())
                Log.d(TAG, "Previous Smallest Element of " + a[i] + " is " + -1);
            else
                Log.d(TAG, "Previous Smallest Element of " + a[i] + " is " + stack.peek());
            stack.push(a[i]);
        }
    }

    void nextSmallerElement() {
        int[] a = {6, 8, 11, 3, 98, 21, 99, 4, 69};
        Stack<Integer> stack = new Stack<>();
        for (int i = a.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > a[i])
                stack.pop();
            if (stack.isEmpty()) {
                Log.d(TAG, "Next Smallest Element of " + a[i] + " is " + -1);
            } else {
                Log.d(TAG, "Next Smallest Element of " + a[i] + " is " + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void nextLargerElement() {
        int[] a = {6, 8, 11, 3, 98, 21, 99, 4, 69};
        Stack<Integer> stack = new Stack<>();
        for (int i = a.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < a[i])
                stack.pop();
            if (stack.isEmpty())
                Log.d(TAG, "Next LargerElement of " + a[i] + " is :" + -1);
            else
                Log.d(TAG, "Next LargerElement of " + a[i] + " is :" + stack.peek());
            stack.push(a[i]);
        }
    }

    void previousLargerElement() {
        int[] a = {6, 8, 11, 3, 98, 21, 99, 4, 69};
        Stack<Integer> stack = new Stack<>();
        for (int i : a) {
            while (!stack.isEmpty() && stack.peek() < i)
                stack.pop();
            if (stack.isEmpty())
                Log.d(TAG, "Previous LargerElement of " + i + " is :" + -1);
            else
                Log.d(TAG, "Previous LargerElement of " + i + " is :" + stack.peek());
            stack.push(i);
        }
    }

    void selectionSort() {
        int a[] = {19, 2, 65, 12, -2, -45, 78, 23, 8, 91, 9};

        for (int i = 0; i < a.length; i++) {
            int min_index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min_index])
                    min_index = j;
            }
            if (i != min_index) {
                int temp = a[i];
                a[i] = a[min_index];
                a[min_index] = temp;
            }
        }
        for (int k : a)
            Log.d(TAG, "selectionSort: " + k);
    }
}
