package com.example.dailypractice;

import android.util.Log;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Practice14062022 {

    private final String TAG = Practice14062022.class.getSimpleName();

    void bubbleSort() {
        int[] a = {19, 3, 7, 10, 3, 8, 22, 43, 9, 11};

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] < a[i]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int j : a) {
            Log.d(TAG, "bubbleSort: " + j);
        }
    }

    void kthLargestElement() {
        int[] a = {9, 35, 19, 5, 1, 33, 6, 43, 82};
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int k = 4;

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

    void kthSmallestElement() {
        int[] a = {9, 35, 19, 5, 1, 33, 6, 43, 82};
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int k = 4;
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

    void previousSmallerElement() {
        int[] a = {9, -2, 8, 11, 6, -9, 78, 4, 17, 32};
        Stack<Integer> stack = new Stack<>();

        for (int j : a) {
            while (!stack.isEmpty() && stack.peek() > j) {
                stack.pop();
            }
            if (stack.isEmpty())
                Log.d(TAG, "previous SmallerElement: of " + j + " is:" + -1);
            else
                Log.d(TAG, "previous SmallerElement: of " + j + " is:" + stack.peek());

            stack.push(j);
        }
    }

    void previousLargerElement() {
        int[] a = {9, -2, 8, 11, 6, -9, 78, 4, 17, 32};
        Stack<Integer> stack = new Stack<>();

        for (int j : a) {
            while (!stack.isEmpty() && stack.peek() < j) {
                stack.pop();
            }
            if (stack.isEmpty())
                Log.d(TAG, "previous Larger Element: of " + j + " is:" + -1);
            else
                Log.d(TAG, "previous Larger Element: of " + j + " is:" + stack.peek());
            stack.push(j);
        }
    }

    void nextLargerElement() {
        int[] a = {9, -2, 8, 11, 6, -9, 78, 4, 17, 32};
        Stack<Integer> stack = new Stack<>();
        for (int i = a.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < a[i])
                stack.pop();
            if (stack.isEmpty())
                Log.d(TAG, "Next Larger Element: of " + a[i] + " is:" + -1);
            else
                Log.d(TAG, "Next Larger Element: of " + a[i] + " is:" + stack.peek());
            stack.push(a[i]);
        }
    }

    void nextSmallerElement() {
        int[] a = {9, -2, 8, 11, 6, -9, 78, 4, 17, 32};
        Stack<Integer> stack = new Stack<>();
        for(int i=a.length-1;i>=0;i--) {
            while (!stack.isEmpty() && stack.peek() > a[i]) {
                stack.pop();
            }
            if(stack.isEmpty())
                Log.d(TAG, "Next Smaller Element: of " + a[i] + " is:" + -1);
            else
                Log.d(TAG, "Next Smaller Element: of " + a[i] + " is:" + stack.peek());
            stack.push(a[i]);
        }
    }

}
