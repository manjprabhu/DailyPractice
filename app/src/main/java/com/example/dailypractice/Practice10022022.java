package com.example.dailypractice;

import android.util.Log;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Practice10022022 {

    private final String TAG = Practice10022022.class.getSimpleName();
    int top = -1;
    int limit = 10;
    int a[] = new int[limit];
    int front = 0;
    int rear = 0;
    int qLimit = 10;
    int queue[] = new int[qLimit];

    void countOccuranceofAnElement() {
        int a[] = {10, 3, 6, 10, 8, 3, 9, 11, 9};
        int key = 11;
        int count = 0;

        for ( int i = 0; i < a.length; i++ ) {
            if (a[i] == key) {
                count++;
            }
        }
        Log.d(TAG, "Element " + key + " occurred " + count + " times");
    }

    void frequencyOfElements() {
        int a[] = {10, 3, 54, 17, 17, 23, 43, 12, 16, 17, 16, 10, 10};

        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for ( int i = 0; i < a.length; i++ ) {

            if (map.containsKey(a[i])) {
                count = count + 1;
                map.put(a[i], count);
            } else {
                map.put(a[i], 1);
            }
        }
        for ( Map.Entry entry : map.entrySet() ) {
            Log.d("Practice11022022", "Element : " + entry.getKey() + " occurred " + entry.getValue() + " times");
        }
    }

    void firstRepeatedElementArraySolution1() {
        int a[] = {10, 4, 5, 3, 4, 4, 3, 5, 6};

        for ( int i = 0; i < a.length; i++ ) {
            for ( int j = 0; j < a.length; j++ ) {
                if (a[i] == a[j] && i != j) {
                    Log.d(TAG, "Solution1 First Repeated Element Array is: " + a[i]);
                    return;
                }
            }
        }
    }

    void firstRepeatedElementArraySolution2() {
        int a[] = {10, 4, 5, 3, 4, 4, 3, 5, 6};

        HashSet<Integer> set = new HashSet<>();
        for ( int i = 0; i <= a.length; i++ ) {

            if (set.contains(a[i])) {
                Log.d(TAG, "Solution2 First Repeated Element Array is: " + a[i]);
                return;
            } else {
                set.add(a[i]);
            }
        }
    }

    void firstNonRepeatedElementSolution1() {
        int a[] = {10, 4, 5, 4, 4, 5, 10, 5, 3};

        for ( int i = 0; i < a.length; i++ ) {

            for ( int j = 0; j < a.length; j++ ) {
                if (a[i] == a[j] && i != j) {
                    break;
                }
                if (j == a.length - 1) {
                    Log.d(TAG, "First Non Repeated Element Solution1 is: " + a[i]);
                    return;
                }
            }
        }
    }

    void firstRepeatingCharSolution1() {
        String str = "abcdefbacd";

        for ( int i = 0; i < str.length(); i++ ) {
            for ( int j = 0; j < str.length(); j++ ) {
                if (str.charAt(i) == str.charAt(j) && i != j) {
                    Log.d(TAG, "First Repeating Char Solution1 is: " + str.charAt(i));
                    return;
                }
            }
        }
    }

    void firstRepeatingCharSolution2() {
        String str = "abcdefbacd";
        HashSet<Character> set = new HashSet<>();

        for ( int i = 0; i < str.length(); i++ ) {
            if (!set.add(str.charAt(i))) {
                Log.d(TAG, "First Repeating Char Solution2 is: " + str.charAt(i));
                return;
            } else {
                set.add(str.charAt(i));
            }
        }
    }

    void checkForStringRotation() {
        String str1 = "abcdef";
        String str2 = "efagbcd";
        if (str1.length() == str2.length() && (str1 + str1).contains(str2)) {
            Log.d(TAG, "String are rotated strings ");
        } else {
            Log.d(TAG, "String are NOT rotated strings ");
        }
    }

    void mostRepeatedChar() {
        String str1 = "hfhfhfhfhhffhfh";

        int count[] = new int[256];

        for ( int i = 0; i < str1.length(); i++ ) {
            count[str1.charAt(i)]++;
        }
        int max = -1;
        char c = ' ';
        for ( int j = 0; j < str1.length(); j++ ) {
            if (count[str1.charAt(j)] > max) {
                max = count[str1.charAt(j)];
                c = str1.charAt(j);
            }
        }
        Log.d(TAG, "mostRepeatedChar: is " + c + " occurring " + max + " times");
    }

    void frequencyOfChar() {
        String str = "aabbbcccdef";

        int count[] = new int[256];

        for ( int i = 0; i < str.length(); i++ ) {
            count[str.charAt(i)]++;
        }

        for ( int i = 0; i < str.length(); i++ ) {
            Log.d(TAG, "Frequency of Char: " + str.charAt(i) + " is :" + count[str.charAt(i)]);
        }
    }

    void recursivePalindrome() {
        String str = "sdjfjsdfa";

        int l = 0;
        int r = str.length() - 1;

        boolean isPalindrome = reverse(l, r, str);
        if (isPalindrome) {
            Log.d(TAG, "String " + str + " is palindrome ");
        } else {
            Log.d(TAG, "String " + str + " NOT is palindrome ");
        }
    }

    //*********************************************************************************

//    Array implementation of stack

    private boolean reverse(int l, int r, String str) {
        if (str.charAt(l) != str.charAt(r)) {
            return false;
        }
        if (l >= r) {
            return true;
        }
        return reverse(l + 1, r - 1, str);
    }

    void fibonacci() {
        int n = 10;
        int count = 0;

        int i = 0;
        int j = 1;
        int sum = 0;

        while (count < n) {
            Log.d(TAG, "fibonacci: " + i);
            sum = i + j;
            i = j;
            j = sum;
            count++;
        }
    }

    void fibonacciRecursion() {
        for ( int i = 0; i < 10; i++ ) {
            Log.d(TAG, "fibonacciRecursion: " + recursion(i));
        }
    }

    private int recursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return recursion(n - 1) + recursion(n - 2);
    }

    void insertionSort() {
        int a[] = {10, 4, 7, -2, 65, -22, 89, 17, 53};

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

    void selectionSort() {

        int a[] = {10, 4, 7, -2, 65, -22, 89, 17, 53};

        for ( int i = 0; i < a.length; i++ ) {
            int min_index = i;

            for ( int j = i + 1; j < a.length; j++ ) {
                if (a[j] < a[min_index]) {
                    min_index = j;
                }
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

    void bubbleSort() {
        int a[] = {10, 4, 7, -2, 65, -22, 89, 17, 53};

        for ( int i = 0; i < a.length; i++ ) {
            for ( int j = 0; j < a.length - 1 - i; j++ ) {
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

//    ************************************************************************
//    Array implementation of queue

    void push(int data) {
        if (top == limit) {
            Log.d(TAG, "push: Stack is overflowing");
            return;
        }
        top = top + 1;
        a[top] = data;
    }

    void pop() {
        if (top == -1) {
            Log.d(TAG, "pop: Stack underflow");
            return;
        }

        Log.d(TAG, "Popped element is:" + a[top]);
        top = top - 1;
    }

    void peek() {
        if (top == -1) {
            Log.d(TAG, "peek: Stack is empty");
            return;
        }
        Log.d(TAG, "Top element is:" + a[top]);
    }

    void display() {
        if (top == -1) {
            Log.d(TAG, "display: Stack is empty");
            return;
        }
        for ( int i = top; i >= 0; i-- ) {
            Log.d(TAG, "display: elements are:" + a[i]);
        }
    }

    void enQueue(int data) {

        if (rear == qLimit - 1) {
            Log.d(TAG, "enQueue: Queue is full");
            return;
        }
        queue[rear] = data;
        rear = rear + 1;
    }

    void dequeue() {
        if (front == rear) {
            Log.d(TAG, "dequeue: Queue is empty");
            return;
        }
        Log.d(TAG, "dequeue: element is" + queue[front]);
        front = front + 1;
    }

    void displayQueue() {
        if (front == rear) {
            Log.d(TAG, "displayQueue: Queue is empty");
            return;
        }
        for ( int i = front; i < rear; i++ ) {
            Log.d(TAG, "displayQueue: " + queue[i]);
        }
    }

    void reverseWords() {
        String str = " hello this is test";

        String a[] = str.split(" ");

        String result = "";

        for ( int i = 0; i < a.length; i++ ) {
            if (i == a.length - 1)
                result = a[i] + result;
            else
                result = " " + a[i] + result;
        }

        Log.d(TAG, "reverseWords: " + result);
    }

    void removeFirstLastChar() {

        String str = " hello this is test";
        String a[] = str.split(" ");
        String result = "";

        for ( String s : a ) {
            if (s.length() > 2)
                result = result + s.substring(1, s.length() - 1) + " ";
        }
        Log.d(TAG, "removeFirstLastChar: " + result);
    }


}
