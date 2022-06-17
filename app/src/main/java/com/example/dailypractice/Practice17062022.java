package com.example.dailypractice;

import android.util.Log;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Practice17062022 {

    private final String TAG = Practice17062022.class.getSimpleName();

    void bubbleSort() {
        int[] a = {10, 4, 78, -32, 9, 11, 32, 45, 92, 6};

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for (int i : a) {
            Log.d(TAG, "bubbleSort: " + i);
        }
    }

    void selectionSort() {
        int[] a = {10, 4, 18, 32, 9, -11, 2, 45, 92, 6};
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[min])
                    min = j;
            }
            if (i != min) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
        for (int i : a) {
            Log.d(TAG, "selectionSort: " + i);
        }
    }

    void sumOfDigits() {
        int num = 1293;
        int backup = num;
        int sum = 0, r = 0;
        while (num > 0) {
            r = num % 10;
            sum = sum + r;
            num = num / 10;
        }
        Log.d(TAG, "Sum of Digits of number " + backup + " is: " + sum);
    }

    void reverseNumber() {
        int num = 3628;
        int backup = num;
        int r = 0, reverse = 0;
        while (num > 0) {
            r = num % 10;
            reverse = reverse * 10 + r;
            num = num / 10;
        }
        Log.d(TAG, "Reverse of " + backup + " is : " + reverse);
    }

    void largestNumber() {
        int[] a = {1, 9, 13, 8, 4, 17, 51, 6};
        int largest = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > largest)
                largest = i;
        }
        Log.d(TAG, "Largest Number is: " + largest);
    }

    void smallestNumber() {
        int[] a = {1, 9, 13, 8, 4, -17, 5, 6};
        int smallest = Integer.MAX_VALUE;
        for (int i : a) {
            if (i < smallest)
                smallest = i;
        }
        Log.d(TAG, "Smallest Number is: " + smallest);
    }

    void secondLargestNumber() {
        int[] a = {1, 9, 13, 8, 4, 27, 5, 6};
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > largest) {
                secondLargest = largest;
                largest = i;
            } else if (i < largest && i > secondLargest)
                secondLargest = i;
        }
        Log.d(TAG, "Largest :" + largest + " Second Largest Number: " + secondLargest);
    }

    void secondSmallestNumber() {
        int[] a = {1, 9, 13, 8, 4, 17, -5, 6};
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for (int i : a) {
            if (i < smallest) {
                secondSmallest = smallest;
                smallest = i;
            } else if (i > smallest && i < secondSmallest) {
                secondSmallest = i;
            }
        }
        Log.d(TAG, "smallest :" + smallest + " Second Smallest Number: " + secondSmallest);
    }

    void kthSmallestNumber() {
        int[] a = {1, 9, 13, 8, 4, 17, 5, 6};
        int k = 2;
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
        Log.d(TAG, k + " th Smallest Number is : " + queue.peek());
    }

    void kthLargestNumber() {
        int[] a = {1, 9, 13, 18, 4, 17, 5, 6};
        int k = 4;
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
        Log.d(TAG, k + " th Largest Number is : " + queue.peek());
    }

    void previousSmallerElement() {
        int[] a = {1, 9, 13, 8, 4, 17, 5, 6};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && stack.peek() > a[i])
                stack.pop();
            if (stack.isEmpty())
                Log.d(TAG, "Previous Smaller Element of " + a[i] + " is :" + -1);
            else
                Log.d(TAG, "Previous Smaller Element of " + a[i] + " is :" + stack.peek());
            stack.push(a[i]);
        }
    }

    void nextLargerElement() {
        int[] a = {1, 9, 13, 8, 4, 17, 5, 6};
        Stack<Integer> stack = new Stack<>();
        for (int i = a.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < a[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                Log.d(TAG, "Next larger Element of " + a[i] + " is :" + -1);
            else
                Log.d(TAG, "Next larger Element of " + a[i] + " is :" + stack.peek());
            stack.push(a[i]);
        }
    }

    void previousLargerElement() {
        int[] a = {1, 9, 13, 8, 4, 17, 5, 6};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && stack.peek() < a[i])
                stack.pop();
            if (stack.isEmpty())
                Log.d(TAG, "Previous larger Element of " + a[i] + " is :" + -1);
            else
                Log.d(TAG, "Previous larger Element of " + a[i] + " is :" + stack.peek());
            stack.push(a[i]);
        }
    }

    void nextSmallerElement() {
        int[] a = {1, 9, 13, 8, 4, 17, 5, 6};
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
}
