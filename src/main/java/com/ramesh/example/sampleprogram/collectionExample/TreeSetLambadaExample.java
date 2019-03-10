package com.ramesh.example.sampleprogram.collectionExample;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetLambadaExample {

    /**
     TreeSet by defaults sort the object on natural order base for Integer [Ascending] and for String [Alpha numeric]
     */
    public static void main(String[] args) {

        //If you want to customarily sort the object then use compare method from comparator interface, better replace with lambda since compactor is functional interface
        TreeSet<Integer> treeSet2 = new TreeSet<>(new mySetSortImplementaion());
        treeSet2.add(5);
        treeSet2.add(8);
        treeSet2.add(0);
        treeSet2.add(9);
        treeSet2.add(20);

        System.out.println("Custom Sorting [Descending] : " + treeSet2);  //Before Sorting :  [20, 9, 8, 5, 0]


        //Using Anonymous inner class
        TreeSet<Integer> treeSet = new TreeSet<>( new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
              return (o1 > o2) ? -1 : (o1 < o2) ? +1 : 0 ;
            }
        });
        treeSet.add(5);
        treeSet.add(8);
        treeSet.add(0);
        treeSet.add(9);
        treeSet.add(20);

        System.out.println("Custom Sorting [Descending] : " + treeSet);  //Before Sorting :  [20, 9, 8, 5, 0]

        //If you want to customarily sort the object then use compare method from comparator interface, better replace with lambda since compactor is functional interface
        TreeSet<Integer> treeSet1 = new TreeSet<>(((o1, o2) -> (o1 > o2) ? -1 : (o1 < o2) ? +1 : 0));
        treeSet1.add(5);
        treeSet1.add(8);
        treeSet1.add(0);
        treeSet1.add(9);
        treeSet1.add(20);

        System.out.println("Custom Sorting [Descending] : " + treeSet1);  //Before Sorting :  [20, 9, 8, 5, 0]
    }
}

class mySetSortImplementaion implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return (o1 > o2) ? -1 : (o1 < o2) ? +1 : 0 ;
    }
}
