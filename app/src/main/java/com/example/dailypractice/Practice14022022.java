package com.example.dailypractice;

import android.util.Log;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

public class Practice14022022 {

    private final String TAG = Practice14022022.class.getSimpleName();
    int limit = 10;
    int stack[] = new int[limit];
    int top = -1;
    int queue[] = new int[limit];
    int front, rear = 0;

    void kthSmallestElement() {
        int a[] = {10, 3, 7, 18, 32, 45, -9, -17, 64, 27};
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
        Log.d(TAG, k + "th Smallest Element is: " + queue.peek());
    }

    void kthLargestElement() {
        int a[] = {10, 3, 7, 18, 32, 45, -9, -17, 64, 27};
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
        Log.d(TAG, k + "th Largest Element is: " + queue.peek());
    }

    void equilibriumIndex() {
        int a[] = {6, -7, 1, 5, 2, -4, 3, 0, 6};
        int leftSum = 0;
        int sum = 0;

        for ( int i = 0; i < a.length; i++ ) {
            sum = sum + a[i];
        }

        for ( int i = 0; i < a.length; i++ ) {
            sum = sum - a[i];
            if (leftSum == sum) {
                Log.d(TAG, "Equilibrium Index is: " + i);
                return;
            }
            leftSum = leftSum + a[i];
        }
    }

    void equilibriumIndexSolution2() {
        int a[] = {6, -7, 1, 5, 2, -4, 3, 0, 6};
        int leftSUm = 0;
        int rightSum = 0;
        for ( int i = 0; i < a.length; i++ ) {

            for ( int j = 0; j < i; j++ ) {
                leftSUm = leftSUm + a[j];
            }
            for ( int j = i + 1; j < a.length; j++ ) {
                rightSum = rightSum + a[j];
            }

            if (leftSUm == rightSum) {
                Log.d(TAG, "equilibriumIndexSolution2: " + i);
                return;
            }
        }
    }

    void prefixSubArray() {
        int a[] = {10, 20, 10, 5, 15};
        int sum = 0;
        for ( int i = 0; i < a.length; i++ ) {
            sum = sum + a[i];
            Log.d(TAG, "prefixSubArray: " + sum);
        }
    }

    void checkifSubarraywithZeroSumExists() {
        int a[] = {1, 5, 7, 9, 12};

        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for ( int i = 0; i < a.length; i++ ) {
            sum = sum + a[i];
            if (sum == 0 || a[i] == 0 || set.contains(sum)) {
                Log.d(TAG, "Sub array with zero sum exists: ");
                return;
            }
            set.add(sum);
        }
    }

    //Kaden's Algorithm
    void maxSumSubArray() {
        int[] a = {-5, 4, 6, -3, 4, -1};
        int cursum = 0;
        int maxsum = 0;

        for ( int i = 0; i < a.length; i++ ) {
            cursum = cursum + a[i];

            if (cursum > maxsum) {
                maxsum = cursum;
            }
            if (cursum < 0) {
                cursum = 0;
            }
        }
        Log.d(TAG, "maxSumSubArray: " + maxsum);
    }

    void recusrivePalidromeCheck() {
        String str = "hello";
        int i = 0;
        int j = str.length() - 1;
        if (isPalindrome(i, j, str)) {
            Log.d(TAG, str + " is Palindrome string ");
        } else {
            Log.d(TAG, str + " is not Palindrome string ");
        }
    }

    private boolean isPalindrome(int i, int j, String str) {
        if (str.charAt(i) != str.charAt(j))
            return false;
        if (i >= j)
            return true;
        return isPalindrome(i + 1, j - 1, str);
    }

    void fibonacci() {
        int n = 9;
        int count = 0;
        int i = 0;
        int j = 1;
        int sum = 0;

        while (count < n) {
            Log.d(TAG, "Fibonacci Series:" + i);
            sum = i + j;
            i = j;
            j = sum;
            count++;
        }
    }

    void recusriveFibonacci() {
        int n = 10;
        for ( int i = 0; i < n; i++ ) {
            Log.d(TAG, "Recusrive Fibonacci: " + recursion(i));
        }
    }

    private int recursion(int i) {
        if (i == 0)
            return 0;
        if (i == 1)
            return 1;
        return recursion(i - 1) + recursion(i - 2);
    }

    void checkifElementsareUnique() {
        int a[] = {10, 4, 7, 18, 19, 43, -8, -15, 79, 52};

        HashSet<Integer> set = new HashSet<>();
        for ( int i = 0; i < a.length; i++ ) {
            if (!set.add(a[i])) {
                Log.d(TAG, "Array contains duplicate element: ");
                return;
            }
            set.add(a[i]);
        }
    }

    void previousSmallestElement() {
        int a[] = {10, 4, 7, 18, 19, 43, -8, -15, 79, 52};
        Stack<Integer> stack = new Stack<>();
        for ( int i = 0; i < a.length; i++ ) {
            while (!stack.isEmpty() && stack.peek() > a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "Previous Smallest Element of " + a[i] + " is :" + -1);
            } else {
                Log.d(TAG, "Previous Smallest Element of " + a[i] + " is :" + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void previousLargestElement() {
        int a[] = {10, 4, 7, 18, 19, 43, -8, -15, 79, 52};
        Stack<Integer> stack = new Stack<>();
        for ( int i = 0; i < a.length; i++ ) {
            while (!stack.isEmpty() && stack.peek() < a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "Previous Largest Element of " + a[i] + " is :" + -1);
            } else {
                Log.d(TAG, "Previous Largest Element of " + a[i] + " is :" + stack.peek());
            }
            stack.push(a[i]);
        }
    }

//    *********************************************************************

    void nextSmallestElement() {
        int a[] = {10, 4, 7, 18, 19, 43, -8, -15, 79, 52};
        Stack<Integer> stack = new Stack<>();

        for ( int i = a.length - 1; i >= 0; i-- ) {
            while (!stack.isEmpty() && stack.peek() > a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "Next smallest Element of " + a[i] + " is :" + -1);
            } else {
                Log.d(TAG, "Next smallest Element of " + a[i] + " is :" + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void nextGreaterElement() {
        int a[] = {10, 4, 7, 18, 19, 43, -8, -15, 79, 52};
        Stack<Integer> stack = new Stack<>();

        for ( int i = a.length - 1; i >= 0; i-- ) {
            while (!stack.isEmpty() && stack.peek() < a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "Next Greater Element of " + a[i] + " is :" + -1);
            } else {
                Log.d(TAG, "Next Greater Element of " + a[i] + " is :" + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void selectionSort() {
        int a[] = {10, 4, 7, 18, 19, 43, -8, -15, 79, 52};

        for ( int i = 0; i < a.length; i++ ) {
            int min_index = i;

            for ( int j = i + 1; j < a.length; j++ ) {
                if (a[j] < a[min_index])
                    min_index = j;
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

    void insertionSort() {
        int a[] = {10, 4, 7, 18, 19, 43, -8, -15, 79, 52};

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
        int a[] = {10, 4, 7, 18, 19, 43, -8, -15, 79, 52};

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

    void push(int data) {
        if (top == limit) {
            Log.d(TAG, "push: Stack overflow");
            return;
        }
        top = top + 1;
        stack[top] = data;
    }

    void pop() {
        if (top == -1) {
            Log.d(TAG, "pop: Stack underflow");
            return;
        }
        Log.d(TAG, "pop: " + stack[top]);
        top = top - 1;
    }

//    ****************************

    void peek() {
        if (top == -1) {
            Log.d(TAG, "peek: Stack is empty");
            return;
        }
        Log.d(TAG, "peek: " + stack[top]);
    }

    void display() {
        if (top == -1) {
            Log.d(TAG, "display: Stack is empty");
            return;
        }
        for ( int i = top; i >= 0; i-- ) {
            Log.d(TAG, "display: " + stack[i]);
        }
    }

    void enqueue(int data) {
        if (rear == limit) {
            Log.d(TAG, "enqueue: Queue is full");
            return;
        }
        queue[rear] = data;
        rear++;
    }

    void dequeue() {
        if (front == rear) {
            Log.d(TAG, "dequeue: Queue is empty");
            return;
        }
        Log.d(TAG, "dequeue: " + queue[front]);
        front++;
    }

    void queueDisplay() {
        if (rear == front) {
            Log.d(TAG, "queueDisplay: Queue is empty");
            return;
        }
        for ( int i = front; i < rear; i++ ) {
            Log.d(TAG, "queueDisplay: " + queue[i]);
        }
    }

    void iterativeBinSearch() {
        int a[] = {4, 9, 11, 16, 19, 21, 27, 32, 37, 44, 49, 52, 58};
        int key = 65;
        int low = 0;
        int high = a.length - 1;
        int pos = search(low, high, key, a);
        if (pos != -1) {
            Log.d(TAG, "Element " + key + " found at position :" + pos);
        } else {
            Log.d(TAG, "Element " + key + " is not present");
        }
    }

    private int search(int low, int high, int key, int[] a) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == a[mid]) {
                return mid;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else if (key < a[mid]) {
                high = mid - 1;
            }
        }
        return -1;
    }

    void recursiveBinSearch() {
        int a[] = {4, 9, 11, 16, 19, 21, 27, 32, 37, 44, 49, 52, 58};

        int low = 0;
        int high = a.length - 1;
        int key = 19;

        int pos = recursiveBinSearch(low, high, key, a);

        if (pos != -1) {
            Log.d(TAG, "Element " + key + " found at position :" + pos);
        } else {
            Log.d(TAG, "Element " + key + " is not present");
        }
    }

    private int recursiveBinSearch(int low, int high, int key, int[] a) {

        if (low < high) {
            int mid = low + (high - low) / 2;
            if (key == a[mid]) {
                return mid;
            } else if (key > a[mid]) {
                return recursiveBinSearch(mid + 1, high, key, a);
            } else if (key < a[mid]) {
                return recursiveBinSearch(low, mid - 1, key, a);
            }
        }
        return -1;
    }

    void reversewordString() {
        String str = " hello this is testing string";

        String s[] = str.split(" ");
        String result = "";
        for ( int i = 0; i < s.length; i++ ) {
            result = " " + s[i] + result;
        }

        Log.d(TAG, "reversewordString: " + result);
    }

    void stringrotationornot() {
        String str1 = "abcdef";
        String str2 = "cdbefab";

        if (str1.length() == str2.length() && (str1 + str2).contains(str2)) {
            Log.d(TAG, "stringrotationornot: TRUE");
        } else {
            Log.d(TAG, "stringrotationornot: FALSE");
        }
    }

    void tripletwithGivenSum() {
        int a[] = {12, 3, 4, 1, 6, 9};
        int sum = 24;

        for(int i=0;i<a.length-2;i++) {
            for (int j=i+1;j<a.length-1;j++ ) {
                for(int k=j+1;k<a.length;k++) {
                    if(a[i] +a[j]+a[k] == sum) {
                        Log.d(TAG, "tripletwithGivenSum: "+ a[i] + " " + a[j]+ " "+ a[k]);
                        return;
                    }
                }
            }
        }

    }
}
