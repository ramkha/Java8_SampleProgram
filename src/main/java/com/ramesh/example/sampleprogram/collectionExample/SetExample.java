package com.ramesh.example.sampleprogram.collectionExample;

import java.util.Collections;
import java.util.HashSet;

public class SetExample {

    public static void main(String[] args) {

        /**
         Use Set when you don't want to preserve the Insertion order and want to eliminate the duplicate object insertion
         */
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("Ramesh");
        hashSet.add("Aditya");
        hashSet.add("Sai");
        //hashSet.add("Ramesh");

        System.out.println(hashSet);
    }
}
