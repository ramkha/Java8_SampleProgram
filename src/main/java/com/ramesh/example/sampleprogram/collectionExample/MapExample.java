package com.ramesh.example.sampleprogram.collectionExample;

import java.util.HashMap;

public class MapExample {

    public static void main(String[] args) {


        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("E", "Elephant");
        hashMap.put("K", "Anything");
        hashMap.put("A","Apple");
        hashMap.put("B","Ball");
        hashMap.put("C","Cat");
        hashMap.put("D","Dog");

        System.out.println(hashMap);
    }
}
