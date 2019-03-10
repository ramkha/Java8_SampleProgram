package com.ramesh.example.sampleprogram.collectionExample;

import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {

        // new TreeMap<Integer, String>(); here () empty constructor is being passed which mean by default the treeMap object will be sorted in default natural order [Ascending]

        TreeMap<Integer,String> treeMap = new TreeMap<Integer, String>();
        treeMap.put(2, "Ramesh");
        treeMap.put(3, "Shyam");
        treeMap.put(1, "Hari");
        treeMap.put(8, "Aditya");
        treeMap.put(6, "Sai");

        System.out.println("Default treeMap value : " + treeMap);
    }
}
