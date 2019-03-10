package com.ramesh.example.sampleprogram.lambdasConcept;
import java.util.function.BiConsumer;

/*
   Why Lambdas :-
      ~ Enables Functional programming [ Java is inevitably a OOP, here lambdas is just like another tool that can be used for better and concise programming ]
      ~ More Readable and concise code [ Reduce the boiler plate code ]
      ~ Easier to use API's and libraries
      ~ Enables parallel programming.

    So why functional programming over Object oriented programming?
      1. ~ Yes, anything can be achieved with OOP that Lambda offers, and there is nothing we cannot achieve with OOP.
           At the end of the day its all about assembly language, a machine language but we don't write code in the machine level ? why
             because its hard to write and maintain the syntax on assemble level. That is why we have so many programming paradigm.
               Consider lambda as one more programming paradigm, with one and only reason. To make coding better, elegant and reusable.
      2. Lets discuss some of the problem with OOP,
         ~ In OOP, everything is an object, all codes and block are associated with classes and objects.
              what if i want to write some functionality without associating it with any class or object, well
                 that is where the lambdas tries to solve this problem by enabling the functional programming
 */

//This example demonstrate how to handle exception within the lambdas expression
public class LambdasExceptionHandling {

  public static void main(String[] args) {

    int[] x = {1, 2, 3, 4, 5}; // int array values
    int key = 0; // Key holds value that i want to perform on array of int x

    process(x, key, (i, k) -> {
          try {
            System.out.println(i / k);
          } catch (ArithmeticException e) { // Here the key is 0 so we wil get the exception which has to be handled!
                                            // one way to do is by handling within the lambda itself nut is not the good process
                                            // The reason is it looks messy and not elegant lets, find the other way to handle exception
            System.out.println("can not divide by zero");
          }
        });
    }

  public static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer){
       for(int i : numbers){
           consumer.accept(i,key);
          /*
           try{
               consumer.accept(i,key);        //This is not a good idea, as we don't know what consumer operation we are passing
                                              // and as we change the consumer operation, the exception list will keep increasing
                                              // not a good idea to handle exception
           }catch (ArithmeticException e){
            System.out.println("Exception occured!");
             }
        */
       }
  }
}

//This example demonstrate how to handle exception with a wrapper class
class LambdasExceptionHandlingBetterWay {

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5}; // List of int values
        int key = 0; // Key holds value that i want to perform on lists of int x
        process(x, key, wrapperLambda((i, k) -> System.out.println(i / k)));  //Here I am calling wrapperLambda and passing the consumer operation that I want to execute
                                                                             // Basically its externalizing that block of try catch
    }

    public static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer){
        for(int i : numbers){
            consumer.accept(i,key);
        }
    }

    //Here we have created a wrapper class that does the same operation and with try catch block we can handle exception
    public static  BiConsumer<Integer, Integer> wrapperLambda( BiConsumer<Integer, Integer> consumer) {
        return (i,k) -> {
            try{
                consumer.accept(i,k);
            }catch (ArithmeticException e){
                System.out.println("Exception caught in Lambda expression!");
            }
        };
    }
}