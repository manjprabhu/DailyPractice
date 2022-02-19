package com.example.dailypractice;

import android.util.Log;

public class Practice07022022 {

    private final String TAG = Practice07022022.class.getSimpleName();

    //Kadane's Algorithm
    void maxSumSubArrayKadaneAlgo() {
        int[] a = {-5, 4, 6, -3, 4, -1};
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
        Log.d(TAG, "Kadane's Algorithm maxSumSubArray:" + maxSum);
    }

    //Using iterative/ Brute force way
    void maxSumSubArray() {
        int[] a = {-5, 4, 6, -3, 4, -1};
        int maxSum = Integer.MIN_VALUE;

        for ( int i = 0; i < a.length; i++ ) {
            int curSum = 0;
            for ( int j = i; j < a.length; j++ ) {
                curSum = curSum + a[j];
                if (curSum > maxSum) {
                    maxSum = curSum;
                }
            }
        }
        Log.d(TAG, "maxSumSubArray: " + maxSum);
    }

    // TODO: 07-02-2022 : Correct it for all -ve numbers
    //Kadane's Algorithm
    void maxSumSubArrayKadaneAlgoAllNegative() {
    }

    void startMergeSort() {

        int[] a = {2, 7, 1, 4, -2, 9, -5, 3, 10};
        int l = 0;
        int r = a.length - 1;
        mergeSort(l, r, a);

        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "startMergeSort: " + a[k]);
        }
    }

    private void mergeSort(int l, int r, int[] a) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(l, mid, a);
            mergeSort(mid + 1, r, a);
            merge(l, mid, r, a);
        }
    }

    private void merge(int l, int mid, int r, int[] a) {
        int i = l;
        int j = mid + 1;
        int k = l;

        int[] b = new int[a.length];

        while (i <= mid && j <= r) {
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
            while (j <= r) {
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

        for ( int m = l; m <= r; m++ ) {
            a[m] = b[m];
        }
    }

    void startQuickSort() {
        int[] a = {2, 7, 1, 4, -2, 9, -5, 3, 10};
        int low = 0;
        int high = a.length - 1;

        quickSort(low, high, a);
        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "startQuickSort: " + a[k]);
        }
    }

    private void quickSort(int low, int high, int[] a) {

        if (low < high) {
            int pos = partition(low, high, a);
            quickSort(low, pos, a);
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

    void reverseString() {
        String str = "abcded";
        String nStr = "";
        for ( int i = 0; i < str.length(); i++ ) {
            char ch = str.charAt(i);
            nStr = ch + nStr;
        }
        Log.d(TAG, "reverseString: :" + nStr);
    }

    void palindromeRecursion() {
        String str = "racecar";
        int l = 0;
        int r = str.length() - 1;
        boolean palindrome = reverse(l, r, str);
        if (palindrome) {
            Log.d(TAG, "String " + str + " is palindrome");
        } else {
            Log.d(TAG, "String " + str + " is Not a palindrome");
        }

    }

    private boolean reverse(int l, int r, String s) {
        if (s.charAt(l) != s.charAt(r)) {
            return false;
        }
        if (l >= r) {
            return true;
        }
        return reverse(l + 1, r - 1, s);
    }

    void fibbonaciSeries() {
        int n = 10;

    }
}
