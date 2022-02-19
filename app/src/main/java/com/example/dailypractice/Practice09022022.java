package com.example.dailypractice;

import android.util.Log;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Practice09022022 {

    private final String TAG = Practice09022022.class.getSimpleName();

    void startBinarySearch() {
        int a[] = {5, 9, 11, 16, 19, 23, 28, 32, 37, 44, 57, 65, 79, 81, 84};
        int low = 0;
        int high = a.length - 1;

        int pos = search(low, high, a);
        if (pos != -1) {
            Log.d(TAG, "startBinarySearch: element found at position:" + pos);
        } else {
            Log.d(TAG, "startBinarySearch: element is not present");
        }
    }

    private int search(int low, int high, int a[]) {
        int key = 65;

        if (low < high) {
            int mid = low + (high - low) / 2;

            if (key == a[mid]) {
                return mid;
            } else if (key > a[mid]) {
                return search(mid + 1, high, a);
            } else if (key < a[mid]) {
                return search(low, mid - 1, a);
            }
        }
        return -1;
    }

    void iterativeBinarySearch() {
        int a[] = {5, 9, 11, 16, 19, 23, 28, 32, 37, 44, 57, 65, 79, 81, 84};
        int low = 0;
        int high = a.length - 1;
        int key = 19;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == a[mid]) {
                Log.d(TAG, "iterativeBinarySearch: element found at position:" + mid);
                return;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else if (key < a[mid]) {
                high = mid - 1;
            }
        }
    }

    void insertionSort() {
        int a[] = {19, 2, 65, 12, -2, -45, 78, 23, 8, 91, 9};

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
        int a[] = {19, 2, 65, 12, -2, -45, 78, 23, 8, 91, 9};
        for ( int i = 0; i < a.length; i++ ) {
            for ( int j = 0; j < a.length - i - 1; j++ ) {
                if (a[j] < a[j + 1]) {
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

    void selectionSort() {
        int a[] = {19, 2, 65, 12, -2, -45, 78, 23, 8, 91, 9};

        for ( int i = 0; i < a.length; i++ ) {
            int min_index = i;

            for ( int j = i; j < a.length; j++ ) {
                if (a[j] < a[min_index]) {
                    min_index = j;
                }
            }
            if (i != min_index) {
                int temp = a[min_index];
                a[min_index] = a[i];
                a[i] = temp;
            }
        }
        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "selectionSort: " + a[k]);
        }
    }

    void checkForPalindrome() {
        String str = "racecar";
        int l = 0;
        int r = str.length() - 1;
        boolean isPalindrome = isPalindrome(l, r, str);
        if (isPalindrome) {
            Log.d(TAG, "String: " + str + " is palindrome");
        } else {
            Log.d(TAG, "String: " + str + " NOT is palindrome");
        }
    }

    private boolean isPalindrome(int l, int r, String str) {

        if (str.charAt(l) != str.charAt(r)) {
            return false;
        }
        if (l >= r) {
            return true;
        }
        return isPalindrome(l + 1, r - 1, str);
    }

    void kthSmallestElement() {
        int a[] = {19, 2, 65, 12, -2, -45, 78, 23, 8, 91, 9};

        int k = 2;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for ( int i = 0; i < k; i++ ) {
            queue.add(a[i]);
        }
        for ( int j = k; j < a.length; j++ ) {
            if (queue.peek() > a[j]) {
                queue.poll();
                queue.add(a[j]);
            }
        }
        Log.d(TAG, "kthSmallestElement: is: " + queue.peek());
    }

    void kthLargestElement() {
        int a[] = {19, 2, 65, 12, -2, -45, 78, 23, 8, 91, 9};
        int k = 5;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for ( int i = 0; i < k; i++ ) {
            queue.add(a[i]);
        }

        for ( int j = k; j < a.length; j++ ) {
            if (queue.peek() < a[j]) {
                queue.poll();
                queue.add(a[j]);
            }
        }
        Log.d(TAG, "kthLargestElement: is " + queue.peek());
    }

    void largestElement() {
        int a[] = {19, 2, 65, 12, -2, -45, 58, 23, 8, 91, 9};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for ( int i = 0; i < a.length; i++ ) {
            if (a[i] > largest) {
                secondLargest = largest;
                largest = a[i];
            } else if (a[i] < largest && a[i] > secondLargest) {
                secondLargest = a[i];
            }
        }
        Log.d(TAG, "Largest Element: is: " + largest + " Second Largest :" + secondLargest);
    }

    void maxSumSubarray() {
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

        Log.d(TAG, "maxSumSubarray: :" + maxSum);
    }

    void startQuickSort() {
        int a[] = {19, 2, 65, 12, -2, 58, 23, 8, 1, 9};
        int low = 0;
        int high = a.length - 1;

        quicksort(low, high, a);
        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "startQuickSort: " + a[k]);
        }

    }

    private void quicksort(int low, int high, int[] a) {
        if (low <= high) {
            int pos = partition(low, high, a);
            quicksort(low, pos - 1, a);
            quicksort(pos + 1, high, a);
        }
    }

    private int partition(int low, int high, int[] a) {

        int i = low;
        int j = high;
        int pivot = a[low];

        while (i < j) {
            while (pivot > a[i]) {
                i++;
            }
            while (pivot < a[j]) {
                j--;
            }

            if (i < j) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }

        int temp = a[j];
        a[j] = pivot;
        pivot = temp;
        return j;
    }

    void startMergeSort() {
        int a[] = {19, 2, 65, 12, -2, 58, 23, 8, 1, 9};
        int l = 0;
        int r = a.length - 1;

        mergesort(l, r, a);

        for ( int i = 0; i < a.length; i++ ) {
            Log.d(TAG, "startMergeSort: " + a[i]);
        }

    }

    private void mergesort(int l, int r, int[] a) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergesort(l, mid, a);
            mergesort(mid + 1, r, a);
            merge(l, r, mid, a);
        }
    }

    void merge(int l, int r, int mid, int[] a) {

        int i = l;
        int j = mid + 1;
        int k = l;

        int b[] = new int[a.length];

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
                k++;
                j++;
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

    void firstRepeatingElementInArray() {
        int a[] = {10, 4, 5, 3, 4, 4, 3, 5, 6};

        for ( int i = 0; i < a.length; i++ ) {
            for ( int j = 0; j < a.length; j++ ) {
                if (a[i] == a[j] && i != j) {
                    Log.d("Practice10022022", "Solution1 firstRepeatingElementInArray: is " + a[i]);
                    return;
                }
            }
        }
    }

    void firstRepeatingElementInArraySolution2() {
        int a[] = {10, 4, 5, 3, 4, 4, 3, 5, 6};
        HashSet<Integer> set = new HashSet<>();
        int min = 0;
        for ( int i = a.length - 1; i >= 0; i-- ) {

            if (set.contains(a[i])) {
                min = i;
            } else {
                set.add(a[i]);
            }
        }

        if (min != 0) {
            Log.d("Practice10022022", "Solution2 firstRepeatingElementInArraySolution2: :" + a[min]);
        } else {
            Log.d(TAG, "No repeating element: ");
        }
    }

    void firstNONRepeatedElement() {
        int a[] = {9, 4, 9, 6, 7, 4};

        for ( int i = 0; i < a.length; i++ ) {
            for ( int j = 0; j < a.length; j++ ) {

                if (i != j && a[i] == a[j]) {
                    break;
                }
                if (j == a.length - 1) {
                    Log.d(TAG, "firstNONRepeatedElement: is:" + a[i]);
                    return;
                }
            }
        }
    }

    void firstRepeatedCharString() {
        String str = "hello geeks";
        for ( int i = 0; i < str.length(); i++ ) {
            for ( int j = 0; j < str.length(); j++ ) {
                if (i != j && str.charAt(i) == str.charAt(j)) {
                    Log.d(TAG, "firstRepeatedCharString: is:" + str.charAt(i));
                    return;
                }
            }
        }
    }

    void firstRepeatedCharStringSolution2() {
        String str = "hello geeks";
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++) {

            if(set.contains(str.charAt(i))) {
                Log.d(TAG, "firstRepeatedCharStringSolution2: "+str.charAt(i));
                return;
            }
            else
                set.add(str.charAt(i));
        }
    }

    //s1 = ABCD s2 = CDAB  rotated true
    //s1 = ABCD s2 = ACBD rotated false

    void checkForStringRotation() {
        String str1 = "ABCD";
        String str2 = "ACBD";
        
        if(str1.length() == str2.length() && (str1+str1).contains(str2)) {
            Log.d(TAG, "checkForStringRotation: is TURE");
        } else {
            Log.d(TAG, "checkForStringRotation: not Rotated");
        }
    }

    void determineStringHasUniqueChar() {
        String str =  "abcde";

        HashSet<Character> set = new HashSet<>();

        for(int i=0;i<str.length();i++) {

            if(!set.add(str.charAt(i))) {
                Log.d(TAG, "String has repeated char: ");
                return;
            } else {
                Log.d(TAG, "String has all unique char: ");
            }
            /*if(set.contains(str.charAt(i))) {
                Log.d(TAG, "String has repeated char: ");
                return;
            } else {
                set.add(str.charAt(i));
            }*/
        }
    }

    void maxOccuringCharString() {
        String str = "sample string";
        int count[] = new int[256];

        int len = str.length();
        for (int i=0; i<len; i++)
            count[str.charAt(i)]++;

        int max = -1;
        char result = ' ';

        for (int i = 0; i < len; i++) {
            Log.d(TAG, "Occurrence of char: "+str.charAt(i) + " is :"+ count[str.charAt(i)]);
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);

            }
        }
        Log.d(TAG, "maxOccuringCharString: "+result);
    }

    void frequencyOfChar() {
        String str = "jdsfadjjfsj";

        int count[] = new int[256];

        for(int i=0;i<str.length();i++) {
            count[str.charAt(i)]++;
        }

        for(int i=0;i<str.length();i++) {
            Log.d(TAG, "Frequency of Char: "+ str.charAt(i) + " is :"+ count[str.charAt(i)]);
        }
    }

}
