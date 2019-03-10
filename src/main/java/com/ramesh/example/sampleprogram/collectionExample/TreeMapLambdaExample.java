package com.ramesh.example.sampleprogram.collectionExample;

import java.util.TreeMap;

public class TreeMapLambdaExample {

    public static void main(String[] args) {

        // new TreeMap<Integer, String>(); here comparator object is passed using lambda on constructor, which mean the treeMap object will be sorted in descending order
        //With the use of Lambda expression, we no more need to write the class that implements Comparator class and implement compare() method, this saves huge coding
        // Note, Since treeSet implements the sorting, we are able to pass the Comparator object on constructor, this cannot be done for list and set as they dont implement sort mechanism by default

        TreeMap<Integer,String> treeMap = new TreeMap<Integer, String>((((o1, o2) -> (o1 > o2) ? -1 : (o1 < o2) ? +1 : 0)));
        treeMap.put(2, "Ramesh");
        treeMap.put(3, "Shyam");
        treeMap.put(1, "Hari");
        treeMap.put(8, "Aditya");
        treeMap.put(6, "Sai");

        System.out.println("Sorting [Desceding ] treeMap value : " + treeMap);
    }
}

