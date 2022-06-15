package com.example.dailypractice;

import android.util.Log;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

public class Practice17022022 {

    private final String TAG = Practice17022022.class.getSimpleName();

    void previousSmallestElement() {
        int a[] = {10, 3, 7, 22, 32, 6, -9, 7, 15, -4, 13};

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && stack.peek() > a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "Previous smallest element of " + a[i] + " is " + -1);
            } else {
                Log.d(TAG, "Previous smallest element of " + a[i] + " is " + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void previousLargestElement() {
        int a[] = {10, 3, 7, 22, 32, 6, -9, 7, 15, -4, 13};
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && stack.peek() < a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "Previous largest element of " + a[i] + " is " + -1);
            } else {
                Log.d(TAG, "Previous largest element of " + a[i] + " is " + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void nextLargestElement() {
        int a[] = {10, 3, 7, 22, 32, 6, -9, 7, 15, -4, 13};
        Stack<Integer> stack = new Stack<>();

        for (int i = a.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "Next largest element of " + a[i] + " is " + -1);
            } else {
                Log.d(TAG, "Next largest element of " + a[i] + " is " + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void nextSmallestElement() {
        int a[] = {10, 3, 7, 22, 32, 6, -9, 7, 15, -4, 13};
        Stack<Integer> stack = new Stack<>();

        for (int i = a.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "Next Smallest element of " + a[i] + " is " + -1);
            } else {
                Log.d(TAG, "Next Smallest element of " + a[i] + " is " + stack.peek());
            }
            stack.push(a[i]);
        }
    }

    void kthSmallestElement() {
        int a[] = {10, 3, 7, 22, 32, 6, -9, 15, -4, 13};

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
        Log.d(TAG, "kthSmallestElement is:" + queue.peek());
    }

    void kthLargestElement() {
        int a[] = {10, 3, 7, 22, 32, 6, -9, 15, -4, 13};
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
        Log.d(TAG, "kthLargestElement is: " + queue.peek());
    }

    void equilibriumIndex() {
        int a[] = {-7, 1, 5, 2, -4, 3};

        int leftSum, rightSum;
        for (int i = 0; i < a.length; i++) {
            leftSum = 0;
            rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum = leftSum + a[j];
            }

            for (int j = i + 1; j < a.length; j++) {
                rightSum = rightSum + a[j];
            }

            if (leftSum == rightSum) {
                Log.d(TAG, "equilibriumIndex is: " + i);
            }
        }
    }

    void equilibriumIndexSolution1() {
        int a[] = {-7, 1, 5, 2, -4, 3};
        int sum = 0, leftSUm = 0;

        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }

        for (int i = 0; i < a.length; i++) {
            sum = sum - a[i];

            if (sum == leftSUm) {
                Log.d(TAG, "equilibriumIndexSolution1 is: " + i);
            }
            leftSUm = leftSUm + a[i];
        }
    }

    void fibonacciSeries() {
        int n = 10;
        int count = 0;
        int i = 0;
        int j = 1;
        int sum = 0;

        while (count < n) {

            Log.d(TAG, "fibonacciSeries: " + i);
            sum = i + j;
            i = j;
            j = sum;
            count++;
        }
    }

    void fibonacciRecusrion() {
        int n = 10;


        for (int i = 0; i < n; i++) {
            int num = recursion(i);
            Log.d(TAG, "fibonacciRecusrion: " + num);
        }
    }

    private int recursion(int i) {
        if (i == 0)
            return 0;
        if (i == 1)
            return 1;
        return recursion(i - 1) + recursion(i - 2);
    }

    void palindromeRecusrion() {
        String str = "racdecar";
        int i = 0;
        int j = str.length() - 1;

        if (recursionPalindrome(i, j, str)) {
            Log.d(TAG, str + " is palindrome string ");
        } else {
            Log.d(TAG, str + " is palindrome NOT string ");
        }
    }

    private boolean recursionPalindrome(int i, int j, String str) {
        if (str.charAt(i) != str.charAt(j))
            return false;
        if (i >= j)
            return true;
        return recursionPalindrome(i + 1, j - 1, str);
    }

    void zeroSumSubarray() {
        int a[] = {1, 5, 7, 9, 12, -4, -8};
        int sum = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            if (a[i] == 0 || sum == 0 || set.contains(sum)) {
                Log.d(TAG, "There exists a zero sum subarray ");
                break;
            }
            set.add(sum);
        }
    }

    void kadensAlgorithm() {
        int[] a = {-5, 4, 6, -3, 4, -1};

        int cursum = 0;
        int maxsum = 0;

        for (int i = 0; i < a.length; i++) {
            cursum = cursum + a[i];

            if (cursum > maxsum) {
                maxsum = cursum;
            }

            if (cursum < 0) {
                cursum = 0;
            }
        }
        Log.d(TAG, "kadensAlgorithm: " + maxsum);
    }

    void subArrayWithGivenSum() {
        int a[] = {10, 15, -5, 15, -10, 5};
        int sum = 5;
        int curSum = 0;

        int startIndex = 0;
        int endIndex = -1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            curSum = curSum + a[i];// calculate the prefix sum

            if (map.containsKey(curSum - sum)) {
                startIndex = map.get(curSum - sum);
                endIndex = i;
                break;
            }
            map.put(curSum, i);
        }

        if (endIndex == -1) {

            Log.d(TAG, "sub Array With GivenSum does not exists: ");
        } else {
            Log.d(TAG, "Sub Array WithGivenSum: " + startIndex + " to " + endIndex);
        }

    }

    void startQuickSort() {
        int a[] = {10, 3, 7, 22, 32, 6, -9, 15, -4, 13};
        int low = 0;
        int high = a.length - 1;

        quickSort(low, high, a);
        for (int k = 0; k < a.length; k++) {
            Log.d(TAG, "startQuickSort: " + a[k]);
        }

    }

    private void quickSort(int low, int high, int[] a) {
        if (low < high) {
            int pos = partition(low, high, a);
            quickSort(low, pos - 1, a);
            quickSort(pos + 1, high, a);
        }
    }

    private int partition(int low, int high, int[] a) {
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

    void selectionSort() {
        int a[] = {10, 3, 7, 22, 32, 6, -9, 15, -4, 13};

        for (int i = 0; i < a.length; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index])
                    index = j;
            }
            if (i != index) {
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }
        for (int k = 0; k < a.length; k++) {
            Log.d(TAG, "selectionSort: " + a[k]);
        }
    }

    void insertionSort() {
        int a[] = {10, 3, 7, 22, 32, 6, -9, 15, -4, 13};

        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
        for (int k = 0; k < a.length; k++) {
            Log.d(TAG, "insertionSort: " + a[k]);
        }
    }

    void findSubArrayWithZeroSum() {
        int a[] = {1, 5, 7, 9, 12, -4, -8, 20};
        int sum = 0;
        int start = 0;
        int end = -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        int cursum = 0;

        for (int i = 0; i < a.length; i++) {
            cursum = cursum + a[i];

            if (map.containsKey(cursum - sum)) {
                end = i;
                start = map.get(cursum - sum) + 1;
            }
            map.put(cursum, i);
        }
        if (end == -1) {
            Log.d(TAG, "Subarray with zero sum does not exists: ");
        } else {
            Log.d(TAG, "Subarray with zero sum exists from: " + start + " to " + end);
        }

    }

}
