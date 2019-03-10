package com.ramesh.example.sampleprogram.collectionExample;

import java.util.TreeSet;

public class TreeSetExample {

    /**
     TreeSet by defaults sort the object on natural order base for Integer [Ascending] and for String [Alpha numeric]
     */
    public static void main(String[] args) {

        // new TreeSet<>() here () empty constructor will implements the default behavior of treeSet
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(8);
        treeSet.add(0);
        treeSet.add(9);
        treeSet.add(20);

        System.out.println("Default Sorting : " + treeSet);  //Default Sorting :  [0, 5, 8, 9, 20]
    }


}
