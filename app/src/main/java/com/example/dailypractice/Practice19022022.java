package com.example.dailypractice;

import android.util.Log;

public class Practice19022022 {

    private final String TAG = Practice19022022.class.getSimpleName();

    void recursiveBinarySearch() {
        int a[] = {4, 8, 11, 15, 18, 19, 21, 26, 32, 35, 38};
        int key = 118;
        int low = 0;
        int high = a.length - 1;
        int pos = recursion(low, high, key, a);
        if (pos != -1) {
            Log.d(TAG, "Element " + key + " found at position:" + pos);
        } else {
            Log.d(TAG, "Element " + key + " NOT found");
        }
    }

    private int recursion(int low, int high, int key, int[] a) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == a[mid])
                return mid;
            else if (key > a[mid])
                return recursion(mid + 1, high, key, a);
            else if (key < a[mid])
                return recursion(low, mid - 1, key, a);
        }
        return -1;
    }

    //rotate left
    void arrayRotationSolution1() {
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        int d = 1;

        int temp = a[0];
        for ( int i = 0; i < a.length - 1; i++ ) {
            a[i] = a[i + 1];
        }
        a[a.length - 1] = temp;

        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "arrayRotationSolution1: " + a[k]);
        }

    }

    void rotateArrayRight() {
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        int d = 1;
        int temp = a[a.length - 1];

        for ( int i = a.length - 1; i > 0; i-- ) {
            a[i] = a[i - 1];
        }
        a[0] = temp;

        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "arrayRotationSolution1: " + a[k]);
        }
    }

    void peakElementSolution1() {
        int a[] = {10, 20, 15, 2, 23, 90, 67};

        if (a[0] > a[1]) {
            Log.d(TAG, "peakElement is:" + a[0]);
            return;
        }

        if (a[a.length - 1] > a[a.length - 2]) {
            Log.d(TAG, "peakElement: " + a[a.length]);
            return;
        }

        for ( int i = 1; i < a.length - 2; i++ ) {
            if (a[i] > a[i - 1] && a[i] > a[i + 1])
                Log.d(TAG, "peakElement: " + a[i]);
        }
    }

    void peakElementSolution2() {
//        int a[] = {1, 3, 20, 4, 1, 0};
        int a[] = {10, 20, 15, 2, 23, 90, 67};

        int low = 0;
        int high = a.length - 1;

        int pos = recursivePeak(a, low, high);
        Log.d(TAG, "peakElementSolution2: " + a[pos]);
    }

    private int recursivePeak(int a[], int low, int high) {

        int mid = (low + high) / 2;

        if (a[mid] >= a[mid - 1] || a[mid] >= a[mid + 1])
            return mid;
        else if (a[mid] < a[mid - 1])
            return recursivePeak(a, low, mid - 1);
        else
            return recursivePeak(a, mid + 1, high);
    }

    void maxSumSubArrayKadensAlgo() {
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
        Log.d(TAG, "maxSumSubArrayKadensAlgo: " + maxsum);
    }

    void equilibriumIndexSolution1() {
        int a[] = {-7, 1, 5, 2, -4, 3};

        int leftsum =0;
        int rightSum =0;

        for(int i=0;i<a.length;i++) {

            leftsum =0;
            rightSum =0;

            for(int j=0;i<i;j++) {
                leftsum = leftsum +a[i];
            }

            for(int k=i+1;k<a.length;k++) {
                rightSum = rightSum +a[i];
            }
        }
    }
}
