package com.example.dailypractice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Do not delete
        /*practice13022022.head = new Practice13022022.Node(10);
        practice13022022.head.next = new Practice13022022.Node(20);
        practice13022022.head.next.next = new Practice13022022.Node(30);
        practice13022022.head.next.next.next = new Practice13022022.Node(40);
        practice13022022.head.next.next.next.next = new Practice13022022.Node(50);
        practice13022022.head.next.next.next.next.next = practice13022022.head;//to make list circualr
        practice13022022.checkforcircularList();*/

        Practice15062022 practice15062022 = new Practice15062022();
        practice15062022.selectionSort();
    }
}