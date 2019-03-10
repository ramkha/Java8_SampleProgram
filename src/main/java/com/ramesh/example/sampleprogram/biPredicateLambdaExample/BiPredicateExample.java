package com.ramesh.example.sampleprogram.biPredicateLambdaExample;


/*
   Unlike Predicate, that takes one input and return the boolean.
          Bi-predicate as name implies takes two input argument and return type is boolean,
              boolean <T t, U u> test();
                Everything else like default method and static method are same for both.
 */

import java.util.function.BiPredicate;

//This example takes two integer perform if the addition is even or not
public class BiPredicateExample {

  public static void main(String[] args) {
    //Bi-Predicate example
      BiPredicate<Integer,Integer> biPredicate = (a,b) -> ((a+b) %2 == 0);

      System.out.println("Sum of number is even? " + biPredicate.test(5,9));
  }
}
