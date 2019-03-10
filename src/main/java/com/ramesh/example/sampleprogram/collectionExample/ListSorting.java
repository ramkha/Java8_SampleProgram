package com.ramesh.example.sampleprogram.collectionExample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSorting {

    public static void main(String[] args) {

        /**
         Use List if you want to preserve the Insertion order and duplicates object
         */
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(5);
        arrayList.add(8);
        arrayList.add(0);
        arrayList.add(9);
        arrayList.add(20);

        System.out.println("Before Sorting : " + arrayList);  //Before Sorting : [5, 8, 0, 9, 20]

        //Sort list in default natural order for Integer which is ascending
        Collections.sort(arrayList);
        System.out.println("After Natural Sorting [Ascending] : " + arrayList); //After Sorting : [0, 5, 8, 9, 20]


        //Sort list in Customized order, for that use comparator concept [comparator is an interface[functional] since it has only one abstract method]
        Collections.sort(arrayList, new CustomComparator());
        System.out.println("After Customized Sorting [Descending] : " + arrayList); //After Sorting Descending : [20, 9, 8, 5, 0]


        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("bac");
        stringList.add("abc");
        stringList.add("aa");

        System.out.println("Before Sorting String : " + stringList);

        Collections.sort(stringList);
        System.out.println("After Natural order Sorting String : " + stringList);

        Collections.sort(stringList, Comparator.reverseOrder());
        System.out.println("After Natural order Sorting String : " + stringList);

    }
}

 class CustomComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        //Traditional Java if else
          /*  if(o1 > 02){
                return -1;
            }
            else if (o1 < o2){
                return 1;
            }else
                return 0;
        }*/

        //Shortcut for if-else using Ternary operator
        return (o1 > o2)? -1 : (o1 < o2) ? +1 : 0;
    }
}