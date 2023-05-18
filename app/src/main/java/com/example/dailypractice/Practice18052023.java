package com.example.dailypractice;

import android.util.Log;

import java.util.Collections;
import java.util.PriorityQueue;

public class Practice18052023 {

    private final String TAG = Practice18052023.class.getSimpleName();

    public void kthSmallestElement() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int k =3;
        int[] a = {10,4,7,99,12,45,5,6,1};

        for(int i=0;i<k;i++) {
            queue.add(a[i]);
        }

        for(int i = k+1; i< a.length; i++) {
            if(queue.peek() > a[i]) {
                queue.poll();
                queue.add(a[i]);
            }
        }
        Log.d(TAG,k+"th smallest element is :"+ queue.peek());

    }

}
