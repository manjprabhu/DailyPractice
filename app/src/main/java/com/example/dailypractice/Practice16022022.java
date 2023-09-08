package com.example.dailypractice;

import android.util.Log;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class Practice16022022 {

    private final String TAG = Practice16022022.class.getSimpleName();

    void checkPalindrome() {
        String str = "racesdfcar";
        int i = 0, j = str.length() - 1;

        boolean ispalindrome = isPalindrome(i, j, str);
        if (ispalindrome) {
            Log.d(TAG, "String " + str + " is palindrome");
        } else {
            Log.d(TAG, "String " + str + " is NOT palindrome");
        }
    }

    private boolean isPalindrome(int i, int j, String str) {
        if (str.charAt(i) != str.charAt(j)) {
            return false;
        }
        if (i >= j) {
            return true;
        }
        return isPalindrome(i + 1, j - 1, str);
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

    void fibonacciRecursion() {
        int n = 10;

        for (int i = 0; i < n; i++) {
            int x = recursion(i);
            Log.d(TAG, "fibonacciRecursion: " + x);
        }
    }

    private int recursion(int i) {
        if (i == 0)
            return 0;
        if (i == 1)
            return 1;
        return recursion(i - 1) + recursion(i - 2);
    }

    void recursiveBinarySearch() {
        int a[] = {3, 7, 9, 14, 17, 21, 26, 28, 31, 33, 37, 39, 46, 67};
        int key = 934;
        int low = 0;
        int high = a.length - 1;
        int pos = recursiveBinarySearch(low, high, key, a);

        if (pos != -1) {
            Log.d(TAG, "Element " + key + " found at position:" + pos);
        } else {
            Log.d(TAG, "Element " + key + " is not present");
        }
    }

    private int recursiveBinarySearch(int low, int high, int key, int[] a) {

        if (low < high) {
            int mid = low + (high - low) / 2;

            if (key == a[mid]) {
                return mid;
            } else if (key > a[mid]) {
                return recursiveBinarySearch(mid + 1, high, key, a);
            } else if (key < a[mid]) {
                return recursiveBinarySearch(low, mid - 1, key, a);
            }
        }
        return -1;
    }

    void reverseword() {
        String str = " hello this is for testing purpose";
        String s[] = str.split(" ");
        String result = "";
        for (int i = 0; i < s.length; i++) {
            result = " " + s[i] + result;
        }
        Log.d(TAG, "reverseword: " + result);
    }

    void equilibriumIndex() {
        int a[] = {-7, 1, 5, 2, -4, 3, 0};
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < a.length; i++) {

            leftSum = 0;
            rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum = leftSum + a[j];
            }

            for (int k = i + 1; k < a.length; k++) {
                rightSum = rightSum + a[k];
            }
            if (leftSum == rightSum) {
                Log.d(TAG, "equilibriumIndex is:" + i);
                return;
            }
        }
    }

    void equilibriumIndexSolution2() {
        int[] a = {-7, 1, 5, 2, -4, 3, 0};
        int sum = 0;
        int leftSum = 0;

        for (int j : a) {
            sum = sum + j;
        }
        for (int i = 0; i < a.length; i++) {
            sum = sum - a[i];

            if (sum == leftSum) {
                Log.d(TAG, "equilibriumIndex is:" + i);
                break;
            }
            leftSum = leftSum + a[i];
        }
    }

    void prefixSumArray() {
        int a[] = {-7, 1, 5, 2, -4, 3, 0};
        int pSum = 0;
        for (int j : a) {
            pSum = pSum + j;
            Log.d(TAG, "prefixSumArray: " + pSum);
        }
    }

    void checkForZeroSumSubarray() {
        int a[] = {1, 5, 7, 9, 12, -4, -8};
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int j : a) {
            sum = sum + j;
            if (j == 0 || sum == 0 || set.contains(sum)) {
                Log.d(TAG, "Zero sum subarray is present: ");
                break;
            }
            set.add(sum);
        }
    }

    void kthSmallestElement() {
        int[] a = {1, 5, 7, 9, 12, -4, -8};

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int k = 2;
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
        int[] a = {1, 15, 7, 9, 12, -4, -8};
        int k = 3;

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
        Log.d(TAG, "kthLargestElement: " + queue.peek());
    }


    void frequencyOfElement() {
        int[] a = {10, 4, 7, 12, 45, 23, 12, 45, 23, 78, 89, 12, 23};
        HashMap<Integer, Integer> map = new HashMap<>();
        int count;
        for (int j : a) {
            if (map.containsKey(j)) {
                count = map.get(j);
                count++;
                map.put(j, count);
            } else {
                map.put(j, 1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            Log.d(TAG, "Element " + entry.getKey() + " Appears " + entry.getValue() + " times");
        }
    }

    void frequencyofChar() {
        String str = "abcdefghacbde";

        int[] count = new int[256];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            Log.d(TAG, "Character " + str.charAt(i) + " Appears " + count[str.charAt(i)] + " times");
        }
    }

    void countTheOccurrenceofChar() {
        String str = "abcdacfgadfeAaers";
        char c = 'a';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'A') {
                count++;
            }
        }
        Log.d(TAG, "Character " + c + " appeared " + count + " times");
    }

    void firstRepeatedChar() {
        String str = "abcdacfgadfeAaers";

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            if (!set.add(str.charAt(i))) {
                Log.d(TAG, "firstRepeatedChar is:" + str.charAt(i));
                break;
            }
        }
    }

    //Kaden's algorithm
    void maxSumOfSubarray() {
        int[] a = {-5, 4, 6, -3, 4, -1};

        int sum = 0;
        int cursum = 0;

        for (int j : a) {
            cursum = cursum + j;
            if (cursum > sum) {
                sum = cursum;
            }
            if (cursum < 0) {
                cursum = 0;
            }
        }
        Log.d(TAG, "maxSumOfSubArray: " + sum);
    }

    void pairWithGivenSum() {
        int a[] = {10, 5, -15, 13, 20, 15, 12};
        int sum = 25;

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == sum) {
                    Log.d(TAG, "pairWithGivenSum: " + a[i] + " And " + a[j]);
                }
            }
        }
    }

    void pairWithGivenSumSolution2() {
        int a[] = {10, 5, -15, 13, 20, 15, 12};
        Arrays.sort(a);
        int i = 0;
        int j = a.length - 1;
        int sum = 25;

        while (i < j) {
            if (a[i] + a[j] > sum) {
                j--;
            }
            if (a[i] + a[j] < sum) {
                i++;
            }
            if (sum == a[i] + a[j]) {
                Log.d(TAG, "pairWithGivenSum: " + a[i] + " And " + a[j]);
                i++;
                j--;
            }
        }
    }

    void pairWithGivenSumSolution3() {
        int a[] = {10, 5, -15, 13, 20, 15, 12};
        int sum = 25;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {

            if (map.containsKey(sum - a[i])) {
                Log.d(TAG, "Pair with given sum: " + a[i] + " And " + a[map.get(sum - a[i])]);
            }
            map.put(a[i], i);
        }
    }

    void countPairWithGivenSumSolution4() {
        int a[] = {10, 5, -15, 13, 20, 15, 12};
        int sum = 25;
        int count = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            if (set.contains(sum - a[i])) {
                count++;
            }
            set.add(a[i]);
        }
        Log.d(TAG, "countPairWithGivenSumSolution4: " + count);
    }

}
