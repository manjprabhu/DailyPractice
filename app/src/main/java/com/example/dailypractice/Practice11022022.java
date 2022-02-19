package com.example.dailypractice;

import android.util.Log;

import java.util.HashSet;

public class Practice11022022 {

    private final String TAG = Practice11022022.class.getSimpleName();

    void countOccurrenceOfElement() {
        int a[] = {10, 3, 54, 12, 17, 23, 43, 12, 16, 17, 16, 14, 10};
        int count = 0;
        int key = 10;

        for ( int i = 0; i < a.length; i++ ) {
            if (key == a[i]) {
                count++;
            }
        }
        Log.d(TAG, "Element " + key + " is occurred " + count + " times");
    }

    void firstRepeatedElementSolution1() {
        int a[] = {10, 3, 54, 12, 17, 23, 12, 10, 16, 17, 16, 14, 10};

        for ( int i = 0; i < a.length; i++ ) {
            for ( int j = 0; j < a.length; j++ ) {
                if (a[i] == a[j] && i != j) {
                    Log.d(TAG, "firstRepeatedElementSolution1: " + a[i]);
                    return;
                }
            }
        }
    }

    void firstRepeatedElementSolution2() {
        int a[] = {10, 3, 54, 12, 17, 23, 12, 10, 16, 17, 16, 14, 10};

        HashSet<Integer> set = new HashSet<>();

        for ( int i = 0; i < a.length; i++ ) {

            if (!set.add(a[i])) {
                Log.d(TAG, "firstRepeatedElementSolution2: " + a[i]);
                return;
            }
            set.add(a[i]);
        }
    }

    void firstNonRepeatedElement() {
        int a[] = {10, 3, 54, 12, 17, 23, 12, 10, 16, 54, 16, 3, 10};

        for ( int i = 0; i < a.length; i++ ) {

            for ( int j = 0; j < a.length; j++ ) {

                if (j == a.length - 1) {
                    Log.d(TAG, "firstNonRepeatedElement: " + a[i]);
                    return;
                }
                if (a[i] == a[j] && i != j) {
                    break;
                }
            }
        }
    }

    void firstRepeatedCharString() {
        String str = "sfafjjksadfhksf";

        HashSet<Character> set = new HashSet<>();

        for ( int i = 0; i < str.length(); i++ ) {

            if (!set.add(str.charAt(i))) {
                Log.d(TAG, "firstRepeatedCharString: " + str.charAt(i));
                return;
            }
            set.add(str.charAt(i));
        }
    }

    void firstNonRepeatedChar() {
        String str = "sfafjjksadfhksf";

        for ( int i = 0; i < str.length(); i++ ) {

            for ( int j = 0; j < str.length(); j++ ) {

                if (j == str.length() - 1) {
                    Log.d(TAG, "firstNonRepeatedChar: " + str.charAt(i));
                    return;
                }
                if (str.charAt(i) == str.charAt(j) && i != j) {
                    break;
                }
            }
        }
    }

    void frequencyOfChar() {
        String str = "sfafjjksdfhksf";
        int count[] = new int[256];

        for ( int i = 0; i < str.length(); i++ ) {
            count[str.charAt(i)]++;
        }

        for ( int i = 0; i < str.length(); i++ ) {
            Log.d(TAG, "frequencyOfChar: " + str.charAt(i) + " Occurs " + count[str.charAt(i)] + " times");
        }
    }

    void mostRepeatingChar() {
        String str = "sfafjjksdfhksf";

        int count[] = new int[256];

        for ( int i = 0; i < str.length(); i++ ) {
            count[str.charAt(i)]++;
        }
        int max = 0;

        for ( int i = 0; i < str.length(); i++ ) {
            if (count[str.charAt(i)] > max) {
                max = count[str.charAt(i)];
            }
        }

        Log.d(TAG, "mostRepeatingChar: " + max);
    }

    void capitalizeFirstChar() {

        String str = "hello this iiis tetsing";

        String arr[] = str.split(" ");
        String nstr = " ";

        for ( int i = 0; i < arr.length; i++ ) {
            nstr = " " + arr[i].charAt(0) + nstr;
        }

        Log.d(TAG, "capitalizeFirstChar: " + nstr);

    }

    void reverseWords() {
        String str = "hello this is testing";

        String arr[] = str.split(" ");
        String nstr = " ";

        for ( int i = 0; i < arr.length; i++ ) {
            nstr = " " + arr[i] + nstr + " ";
        }

        Log.d(TAG, "reverseWords: " + nstr);
    }
}
