package com.example.dailypractice;

import android.util.Log;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Practice18052023 {

    private final String TAG = Practice18052023.class.getSimpleName();

    public void kthSmallestElement() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int k = 3;
        int[] a = {10, 4, 7, 99, 12, 45, 5, 6, 1};

        for (int i = 0; i < k; i++) {
            queue.add(a[i]);
        }

        for (int i = k; i < a.length; i++) {
            if (queue.peek() > a[i]) {
                queue.poll();
                queue.add(a[i]);
            }
        }
        Log.d(TAG, k + "th smallest element is :" + queue.peek());

    }


    public void kthLargestElement() {
        int k = 3;
        int[] a = {10, 4, 7, 99, 12, 45, 5, 6, 1};
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int i = 0; i < k; i++) {
            queue.add(a[i]);
        }
        for (int i = k; i < a.length; i++) {
            if (queue.peek() < a[i]) {
                queue.poll();
                queue.add(a[i]);
            }
        }
        Log.d(TAG, k + "th largest element is :" + queue.peek());

    }

    void previousSmallerElement() {
        int[] a = {1, 4, 6, 3, 11, 9, 10};
        Stack<Integer> stack = new Stack<>();

        for (int j : a) {
            while (!stack.isEmpty() && stack.peek() >= j) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "Previous smaller element of " + j + " is " + -1);
            } else {
                Log.d(TAG, "Previous smaller element of " + j + "is " + stack.peek());
            }
            stack.push(j);
        }
    }

    void previousLargestElement() {
        int[] a = {1, 4, 6, 3, 11, 9, 10};
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= a[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                Log.d(TAG, "Previous smaller element of " + a[i] + " is " + -1);
            else
                Log.d(TAG, "Previous smaller element of " + a[i] + " is " + stack.peek());

            stack.push(a[i]);

        }
    }

    void nextSmallerElement() {
        int[] a = {1, 4, 6, 3, 11, 9, 10};
        Stack<Integer> stack = new Stack<>();

        for (int i = a.length - 1; i > 0; i--) {

            while (!stack.isEmpty() && stack.peek() >= a[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                Log.d(TAG, "Next smaller element of " + a[i] + " is " + -1);
            else
                Log.d(TAG, "Previous smaller element of " + a[i] + " is " + stack.peek());

            stack.push(a[i]);
        }
    }

    void nextGreaterElement() {
        int[] a = {1, 4, 6, 3, 11, 9, 10};
        Stack<Integer> stack = new Stack<>();

        for (int i = a.length - 1; i > 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= a[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                Log.d(TAG, "Next greater element of " + a[i] + " is " + -1);
            else
                Log.d(TAG, "Next greater element of " + a[i] + " is " + stack.peek());
            stack.push(a[i]);
        }
    }

    //Kadens
    void maxSumSubArray() {
        int[] a = {-5, 4, 6, -3, 4, -1};
        int maxSum = 0;
        int curSum = 0;

        for (int i = 0; i < a.length; i++) {
            curSum = curSum + a[i];

            if (curSum > maxSum)
                maxSum = curSum;

            if (curSum < 0)
                curSum = 0;

        }

        Log.d(TAG, "Max sum subarray Kadens: " + maxSum);
    }
}
