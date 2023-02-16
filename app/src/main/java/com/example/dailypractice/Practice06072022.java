package com.example.dailypractice;

import android.util.Log;

import java.util.Stack;

public class Practice06072022 {

    private final String TAG = Practice06072022.class.getSimpleName();

    void bubbleSort() {
        int[] a = {10, 4, -3, 9, 22, 54, 8, 15, 20, 99};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }

        }
        for (int k : a) {
            Log.d(TAG, "bubbleSort: " + k);
        }
    }

    void selectionSort() {
        int[] a = {10, 4, 8, -22, 9, 4, 8, 7, 11, 71};
        for (int i = 0; i < a.length; i++) {
            int min_index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min_index])
                    min_index = j;
            }
            if (i != min_index) {
                int temp = a[min_index];
                a[min_index] = a[i];
                a[i] = temp;
            }
        }
        for (int k : a) {
            Log.d(TAG, "selectionSort: " + k);
        }
    }

    void previousLargerElement() {
        int[] a = {1, 9, 13, 8, 4, 17, 5, 6};
        Stack<Integer> stack = new Stack<>();

        for (int j : a) {
            while (!stack.isEmpty() && stack.peek() < j) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                Log.d(TAG, "Previous Larger Element of: " + j + "is " + -1);
            } else {
                Log.d(TAG, "Previous Larger Element of: " + j + "is " + stack.peek());
            }
            stack.push(j);
        }
    }

    void previousSmallerElement() {
        int[] a = {1, 9, 13, 8, 4, 17, 5, 6};
        Stack<Integer> stack = new Stack<>();

        for (int j : a) {
            while (!stack.isEmpty() && stack.peek() > j) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "Previous Smaller Element of: " + j + "is " + -1);
            } else {
                Log.d(TAG, "Previous Smaller Element of: " + j + "is " + stack.peek());
            }
            stack.push(j);
        }
    }
}
