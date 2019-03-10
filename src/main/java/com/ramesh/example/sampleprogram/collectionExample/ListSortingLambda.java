package com.ramesh.example.sampleprogram.collectionExample;

import java.util.ArrayList;
import java.util.Collections;

public class ListSortingLambda  {

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

        //Sort list in Customized order,using lambda expression replace the implementation class [comparator is an interface[functional] since it has only one abstract method]
        Collections.sort(arrayList, ((o1, o2) ->
                (o1 > o2) ? -1 : (o1 < o2) ? +1 : 0));
        System.out.println("After Customized Sorting [Descending] : " + arrayList); //After Sorting Descending : [20, 9, 8, 5, 0]
    }
}

/**
 with Lambda this implementation is not needed
 */
/* class CustomComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return (o1 > o2) ? -1 : (o1 < o2) ? +1 : 0;   //Shortcut for if-else using Ternary operator
    }
    ==> (o1, o2) ->   return (o1 > o2) ? -1 : (o1 < o2) ? +1 : 0;
}*/
