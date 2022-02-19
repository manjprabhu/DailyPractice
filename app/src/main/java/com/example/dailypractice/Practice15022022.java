package com.example.dailypractice;

import android.util.Log;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Practice15022022 {

    private final String TAG = Practice15022022.class.getSimpleName();


    void pairWithGivenSumSolution1() {
        int a[] = {10, 5, -15, 13, 20, 15, 12};
        int sum = 25;
        int cursum = 0;
        int count = 0;
        for ( int i = 0; i < a.length - 1; i++ ) {

            for ( int j = i + 1; j < a.length; j++ ) {
                cursum = a[i] + a[j];
                if (cursum == sum) {
                    Log.d(TAG, "pairWithGivenSumSolution1 pair: " + a[i] + " :" + a[j]);
                    count++;
                }
            }
        }
        Log.d(TAG, "Number of pair with given sum: " + count);
    }

    //Sort the array first
    //Use case when array is sorted
    void pairWithGivenSumSolution2() {
        int a[] = {10, 5, -15, 13, 20, 15, 12};
        int sum = 25;
        int cursum = 0;
        int count = 0;

        Arrays.sort(a);
        int low = 0;
        int high = a.length - 1;

        while (low < high) {
            cursum = a[low] + a[high];

            if (cursum > sum) {
                high--;
            }
            if (cursum < sum) {
                low++;
            }
            if (sum == cursum) {
                Log.d(TAG, "pairWithGivenSumSolution2 pair: " + a[low] + " :" + a[high]);
                count++;
                high--;
                low++;
            }
        }
        Log.d(TAG, "Number of pair with given sum: " + count);
    }

    void pairWithGivenSumSolution3() {
        int a[] = {10, 5, -15, 13, 20, 15, 12};
        int sum = 25;
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for ( int i = 0; i < a.length; i++ ) {

            if (set.contains(sum - a[i])) {
                count++;
            }
            set.add(a[i]);
        }
        Log.d(TAG, "pairWithGivenSumSolution3: " + count);
    }

    void pairWithGivenSumSolution4() {
        int a[] = {10, 5, -15, 13, 20, 15, 12};
        int sum = 25;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for ( int i = 0; i < a.length; i++ ) {

            if (map.containsKey(sum - a[i])) {
                Log.d(TAG, "pairWithGivenSumSolution4: " + a[i] + " :" + a[map.get(sum - a[i])]);
                count++;
            }
            map.put(a[i], i);
        }
        Log.d(TAG, "pairWithGivenSumSolution4: " + count);
    }

    void subArrayWithGivenSum() {
        int a[] = {10, 15, -5, 15, -10, 5};
        int sum = 5;
        int count = 0;
        int cursum = 0;
        int startIndex = 0;
        int endIndex = -1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for ( int i = 0; i < a.length; i++ ) {
            cursum = cursum + a[i];

            if (map.containsKey(cursum - sum)) {
                startIndex = map.get(cursum - sum) + 1;
                endIndex = i;
                break;
            }
            map.put(cursum, i);
        }
        if (endIndex == -1) {
            Log.d(TAG, "sub Array With GivenSum does not exists: ");
        } else {
            Log.d(TAG, "Sub Array WithGivenSum: " + startIndex + " to " + endIndex);
        }
    }

    //Kaden's Algorithm
    void maxSumOfSubArray() {
        int[] a = {-5, 4, 6, -3, 4, -1};
        int cursum = 0;
        int maxsum = 0;

        for ( int i = 0; i < a.length; i++ ) {
            cursum = cursum + a[i];

            if (cursum < 0) {
                cursum = 0;
            }

            if (cursum > maxsum) {
                maxsum = cursum;
            }
        }
        Log.d(TAG, "Kaden's Max Sum Of SubArray: " + maxsum);
    }

    void checkForZeroSumSubArray() {
        int a[] = {1, 5, 7, 9, 12, -4, -8};

        int sum = 0;
        HashSet<Integer> set = new HashSet<>();

        for ( int i = 0; i < a.length; i++ ) {
            sum = sum + a[i];

            if (sum == 0 || a[i] == 0 || set.contains(sum)) {
                Log.d(TAG, "checkForZeroSumSubArray TRUE: ");
            }
            set.add(sum);
        }
    }

    void prefixSumArray() {
        int[] a = {-5, 4, 6, -3, 4, -1};
        int sum = 0;

        for ( int i = 0; i < a.length; i++ ) {
            sum = sum + a[i];
            Log.d(TAG, "prefixSumArray: " + sum);
        }
    }

    void selectionSort() {
        int[] a = {-5, 4, 6, -3, 4, -1};

        for(int i=0;i<a.length;i++) {
            int min= i;

            for(int j=i+1;j<a.length;j++) {
                if(a[j] < a[min]) {
                    min =j;
                }
            }
            if(i!=min) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
        for(int k=0;k<a.length;k++) {
            Log.d(TAG, "selectionSort: "+a[k]);
        }
    }
}
