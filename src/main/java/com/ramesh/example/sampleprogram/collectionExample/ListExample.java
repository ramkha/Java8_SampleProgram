package com.ramesh.example.sampleprogram.collectionExample;

import java.util.ArrayList;

public class ListExample {

    public static void main(String[] args) {

        /**
         Use List if you want to preserve the Insertion order and allow duplicates object
         */
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Ramesh");
        arrayList.add("Aditya");
        arrayList.add("Sai");
        arrayList.add("Jay");
        arrayList.add("Ramesh");

        System.out.print(arrayList);
    }
}
