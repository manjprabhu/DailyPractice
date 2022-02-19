package com.example.dailypractice;

import android.util.Log;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

public class Practice13022022 {

    private final String TAG = Practice13022022.class.getSimpleName();
    int top = -1;
    int limit = 10;
    int stack[] = new int[limit];
    int queue[] = new int[limit];
    int front = 0;
    int rear = 0;
    Node head;

    void maxSubArraySum() {
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
        Log.d(TAG, "maxSubArraySum: " + maxSum);
    }

    void kthLargestElement() {
        int a[] = {10, 4, 8, 12, 54, 31, 8, -9, 7, 23, 7, 36};
        int k = 4;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for ( int i = 0; i < k; i++ ) {
            queue.add(a[i]);
        }
        for ( int i = k; i < a.length; i++ ) {
            if (queue.peek() < a[i]) {
                queue.poll();
                queue.add(a[i]);
            }
        }
        Log.d(TAG, k + "th largestElement is : " + queue.peek());
    }

    void kthSmallestElement() {
        int a[] = {10, 4, 8, 12, 54, 31, 8, -9, 7, 23, 7, 36};
        int k = 6;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for ( int i = 0; i < k; i++ ) {
            queue.add(a[i]);
        }
        for ( int i = k; i < a.length; i++ ) {
            if (queue.peek() > a[i]) {
                queue.poll();
                queue.add(a[i]);
            }
        }
        Log.d(TAG, k + "th SmallestElement is: " + queue.peek());
    }

    void previousSmallestElement() {
        int a[] = {10, 4, 8, 12, 54, 31, 8, -9, 7, 23, 7, 36};

        Stack<Integer> stack = new Stack<>();

        for ( int i = 0; i < a.length; i++ ) {
            while (!stack.isEmpty() && stack.peek() > a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "Previous Smallest eElement of " + a[i] + " is :" + -1);
            } else {
                Log.d(TAG, "Previous Smallest eElement of " + a[i] + " is :" + stack.peek());
            }
            stack.add(a[i]);
        }
    }

    void nextLargestElement() {
        int a[] = {10, 4, 8, 12, 54, 31, 8, -9, 7, 23, 7, 36};

        Stack<Integer> stack = new Stack<>();

        for ( int i = a.length - 1; i >= 0; i-- ) {
            while (!stack.isEmpty() && stack.peek() < a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                Log.d(TAG, "Next greater eElement of " + a[i] + " is :" + -1);
            } else {
                Log.d(TAG, "Next greater eElement of " + a[i] + " is :" + stack.peek());
            }
            stack.add(a[i]);
        }
    }

    void selectionSort() {
        int a[] = {10, 4, 8, 12, 54, 31, 8, -9, 7, 23, 7, 36};

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

    void insertionSort() {
        int a[] = {10, 4, 8, 12, 54, 31, 8, -9, 7, 23, 7, 36};

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
        int a[] = {10, 4, 8, 12, 54, 31, 8, -9, 7, 23, 7, 36};

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

    void iterativeBinarySearch() {
        int a[] = {4, 9, 14, 17, 19, 23, 27, 34, 37, 54, 58, 59, 61};
        int k = 61;
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (k == a[mid]) {
                Log.d(TAG, "Element  " + k + " found at position:" + mid);
                return;
            } else if (k > a[mid]) {
                low = mid + 1;
            } else if (k < a[mid]) {
                high = mid - 1;
            }
        }
    }

    void checkForPalindrome() {
        String str = "racecarq";
        int l = 0;
        int r = str.length() - 1;

        if (isPalindrome(l, r, str)) {
            Log.d(TAG, str + " is palindrome string");
        } else {
            Log.d(TAG, str + " is NOT palindrome string:");
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

    void fibonacci() {
        int n = 10;
        int count = 0;

        int i = 0;
        int j = 1;
        int sum;

        while (count < n) {
            Log.d(TAG, "fibonacci: " + i);
            sum = i + j;
            i = j;
            j = sum;
            count = count + 1;
        }
    }

    void fibonacciRecursion() {
        int n = 10;
        for ( int i = 0; i < n; i++ ) {
            int num = recursion(i);
            Log.d(TAG, "fibonacciRecursion: " + num);
        }
    }

    private int recursion(int i) {
        if (i == 0)
            return 0;
        if (i == 1)
            return 1;
        return recursion(i - 1) + recursion(i - 2);
    }

    void startBinarySearch() {
        int a[] = {4, 9, 14, 17, 19, 23, 27, 34, 37, 54, 58, 59, 61};

        int low = 0;
        int high = a.length - 1;
        int key = 59;
        int result = binSearchRecursion(low, high, key, a);
        if (result != -1) {
            Log.d(TAG, "Element " + key + " found at position:" + result);
        } else {
            Log.d(TAG, "Element " + key + " is not present");
        }
    }

    private int binSearchRecursion(int low, int high, int key, int a[]) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == a[mid]) {
                return mid;
            } else if (key > a[mid]) {
                return binSearchRecursion(mid + 1, high, key, a);
            } else if (key < a[mid]) {
                return binSearchRecursion(low, mid - 1, key, a);
            }
        }
        return -1;
    }

    void checkIfStringsAreRotated() {
        String str1 = "abcd";
        String str2 = "cdaby";

        if (str1.length() == str2.length() && (str1 + str1).contains(str2)) {
            Log.d(TAG, str2 + " is rotated version of " + str1);
        } else {
            Log.d(TAG, str2 + " is NOT rotated version of " + str1);
        }
    }

    void reverseWord() {
        String str = "hello this is for testing";

        String s[] = str.split(" ");
        String result = "";

        for ( int i = 0; i < s.length; i++ ) {
            result = " " + s[i] + result + " ";
        }
        Log.d(TAG, "reverseWord: " + result);
    }

    void subArrayWithZeroSumExists() {
//        int a[] = {-3, 2, 3, 1, 6}; // negative use case
        int a[] = {1, 4, -2, -2, 5, -4, 3};

        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for ( int i = 0; i < a.length; i++ ) {
            sum = sum + a[i];

            if (sum == 0 || set.contains(sum) || a[i] == 0) {
                Log.d(TAG, "Sub Array with zero sum exists ");
                return;
            }
            set.add(sum);
        }
    }

    void allthePairwithGivenSumSolution1() {
        int a[] = {4, 9, 14, 12, 19, 23, 7, 23, 0, 4, 11, 12, 61};
        int sum = 23;
        for ( int i = 0; i < a.length; i++ ) {
            for ( int j = i + 1; j < a.length; j++ ) {
                if (sum == (a[i] + a[j]) && i != j) {
                    Log.d(TAG, "Pairs with sum = " + sum + " are " + a[i] + " : " + a[j]);
                }
            }
        }
    }

    void allPairSolution2() {
        int a[] = {4, 9, 14, 12, 19, 23, 7, 23, 0, 4, 11, 12, 61};
        int sum = 23;

        HashMap<Integer, Integer> map = new HashMap<>();

        for ( int i = 0; i < a.length; i++ ) {
            if (map.containsKey(sum - a[i])) {
                Log.d(TAG, "Pair  " + a[i] + " and " + a[map.get(sum - a[i])]);
            }
            map.put(a[i], i);
        }
    }

    void prefixSubArray() {
        int a[] = {10, 20, 10, 5, 15};
//        int prefixSum[] = {10, 30, 40, 45, 60}; //This is expected output for the given input
        int prefix_sum = 0;

        for ( int i = 0; i < a.length; i++ ) {
            prefix_sum = prefix_sum + a[i];
            Log.d(TAG, "prefixSubArray: " + prefix_sum);
        }
    }

    //    Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal
//    to the sum of elements at higher indexes
    void equilibriumIndexSolution1() {

        int a[] = {-7, 1, 5, 2, -4, 3, 0};

        int leftsum = 0;
        int rightsum = 0;
        for ( int i = 0; i < a.length; i++ ) {

            leftsum =0;
            rightsum =0;
            for ( int j = 0; j < i; j++ ) {
                leftsum = leftsum + a[j];
            }

            for ( int j = i + 1; j < a.length; j++ ) {
                rightsum = rightsum + a[j];
            }

            if (rightsum == leftsum) {
                Log.d(TAG, "Equilibrium index is : " + i);
            }
        }
    }
//    *********************************************************

    void equilibriumIndexSolution2() {

        int a[] = {-7, 1, 5, 2, -4, 3, 0};

        int sum = 0;
        int leftSum = 0;

        for ( int i = 0; i < a.length; i++ ) {
            sum = sum + a[i];
        }

        for ( int i = 0; i < a.length; i++ ) {
            sum = sum - a[i];
            if (sum == leftSum) {
                Log.d(TAG, "Solution 2 Equilibrium Index is : " + i);
                return;
            }
            leftSum = leftSum + a[i];
        }
    }

    void startQuickSort() {
        int a[] = {3, 8, 1, 33, 5, 19, 10, 32, 39, 41, 45, 47, 51, 58};
        int low = 0;
        int high = a.length - 1;

        quicksort(low, high, a);

        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "startQuickSort: " + a[k]);
        }
    }

    private void quicksort(int low, int high, int a[]) {

        if (low < high) {
            int pos = partition(low, high, a);
            quicksort(low, pos - 1, a);
            quicksort(pos + 1, high, a);
        }
    }

    private int partition(int low, int high, int a[]) {
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

    void startMergeSort() {
        int a[] = {10, 4, 8, 11, 45, 32, -8, -19, 7, 73, 91, 82, 6};
        int low = 0;
        int high = a.length - 1;

        mergesort(low, high, a);

        for ( int k = 0; k < a.length; k++ ) {
            Log.d(TAG, "startMergeSort: " + a[k]);
        }
    }

    private void mergesort(int low, int high, int a[]) {

        if (low < high) {
            int mid = (low + high) / 2;
            mergesort(low, mid, a);
            mergesort(mid + 1, high, a);
            merge(low, high, mid, a);
        }
    }

    private void merge(int low, int high, int mid, int a[]) {

        int i = low;
        int j = mid + 1;
        int k = low;
        int b[] = new int[a.length];

        while (i <= mid && j <= high) {
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
            while (j <= high) {
                b[k] = a[j];
                k++;
                j++;
            }
        } else {
            while (i <= mid) {
                b[k] = a[i];
                k++;
                i++;
            }
        }

        for ( int m = low; m <= high; m++ ) {
            a[m] = b[m];
        }
    }

//    **********************************************************************************************

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
            Log.d(TAG, "pop: Stack underflow:");
            return;
        }
        Log.d(TAG, "pop: element is:" + stack[top]);
        top = top - 1;
    }

    void peek() {
        if (top == -1) {
            Log.d(TAG, "peek: Stack is empty:");
            return;
        }
        Log.d(TAG, "peek: Top element is:" + stack[top]);
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
        if (front == limit) {
            Log.d(TAG, "dequeue: Queue is empty");
            return;
        }
        Log.d(TAG, "dequeue: Element is:" + queue[front]);
        front = front + 1;
    }

//    **************************************************************

    void displayQueue() {
        if (front == limit) {
            Log.d(TAG, "displayQueue: Queue is empty");
            return;
        }
        for ( int i = front; i < rear; i++ ) {
            Log.d(TAG, "displayQueue: " + queue[i]);
        }
    }

    void insertFront(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    void insertEnd(Node node) {
        if (head == null) {
            Log.d(TAG, "insertEnd: empty list ");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.next = null;
    }

    void insertAfter(Node after, Node node) {
        if (head == null) {
            Log.d(TAG, "inserAfter: Empty list");
            return;
        }
        Node temp = head;
        while (temp.data != after.data) {
            temp = temp.next;
        }
        node.next = after.next;
        after.next = node;
    }

    void deleteFront() {
        if (head == null) {
            Log.d(TAG, "deleteFront: Empty list");
            return;
        }

        head = head.next;
    }

    void displayList() {
        if (head == null) {
            Log.d(TAG, "displayList: empty list");
            return;
        }
        Node temp = head;
        while (temp != null) {
            Log.d(TAG, "displayList: " + temp.data);
            temp = temp.next;
        }
    }

    void checkforcircularList() {
        if (head == null) {
            Log.d(TAG, "List is empty: ");
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next != head) {
            temp = temp.next;
        }
        if (temp.next == head) {
            Log.d(TAG, "List is Circular list ");
        } else {
            Log.d(TAG, "List is Not Circular  list ");
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

}
