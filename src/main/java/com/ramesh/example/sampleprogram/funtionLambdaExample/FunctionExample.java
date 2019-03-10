package com.ramesh.example.sampleprogram.funtionLambdaExample;
import com.sun.org.apache.xpath.internal.compiler.FunctionTable;

import java.util.function.Function;

/*
  Function is a predefined interface provided by Java in java.util.function
  Like Predicate take a Type T and always returns boolean
           Function takes a Type T and return R as a method argument. Function<T, R> ; T is an input Type, and R is a return type
  Like Predicate has  boolean test(T t) , as an abstract method,
           Function has  R apply(T t) , as an abstract method.
 */


//This function example takes String and returns the length of the string. Input type is String and return type is Integer
public class FunctionExample {
    public static void main(String[] args) {

        Function<String,Integer> f = s -> s.length();  //Here Function interface with input type String and return type as Integer

        System.out.println("Length of the given string : " + f.apply("Ramesh")); // print 6
    }
}

//This example takes Integer and returns the square of it using Function
class SquareUsingFunctionInterface {
    public static void main(String[] args) {
        Function<Integer,Integer> f = i -> i*i;
        System.out.println("Square of given integer : "+ f.apply(5));
    }
}

//This example removes spaces from the string provided
class RemoveSpaceFromString {
    public static void main(String[] args) {
        Function<String,String > f = s -> s.replaceAll(" ", ""); //this will replace space
        System.out.println("String after removing spaces : " + f.apply("Lets remove the spaces from the statement"));
    }
}

//This example counts how many spaces are there in the provided in the statement
class CountNumberOfSpaces {
    public static void main(String[] args) {
        Function<String, Integer> f = s -> s.length() - s.replaceAll(" ", "").length(); // This returns the value after subtracting the length of string with spaces and length of string with space
        System.out.println("The number of space in the provided string is : "+ f.apply("lets find how many spaces we have here in this example"));
    }
}

