package com.ramesh.example.sampleprogram.funtionLambdaExample;


/*
  Function chaining is the operation performed on two function to perform more complex function using default function present in the Function interfaces
    Default function available inside Function interface :
      1) f1.andThen(f2) => here f1 operation will be applied first and then followed by f2
      2) f1.compose(f2) ==> here f2 operation will be applied first and then followed by f1 (reverse order)
 */

import java.util.function.Function;

//For demo of function chaining, we will take first function which will take string and convert it to the UPPERCASE
//                               we will take second function which will only consider first 9 character of the string(f1)
public class FunctionChainingExample {

    public static void main(String[] args) {

        Function<String, String> function1 = s -> s.toUpperCase(); //takes string and convert it into the Upper Case.

        Function<String,String> function2 = s -> s.substring(0,6); // substring will consider first 9 char, formula is 0 is starting index, and 6-1 = 5 is the ending index.

        System.out.println("Convert to Upper Case : " + function1.apply("RameshKhadka"));
        System.out.println("Consider first 6 char : " + function2.apply("RameshKhadka"));

        //Combine the both function1 and function2
        System.out.println("Combining function1 and function2 " + function1.andThen(function2).apply("RameshKhadka"));

        //or
        System.out.println("Combining function1 and function2 " + function2.compose(function1).apply("RameshKhadka"));
    }
}


//Demo on difference between andThen() and compose() method
class DifferenceBtnAndThenAndCompose {

    public static void main(String[] args) {

        Function<Integer, Integer> f1 = i -> i + i;  //f1 takes integer and return the double value of input

        Function<Integer,Integer> f2 = i -> i * i * i;  //f2 takes  integer and return the cubic value of input

        System.out.println("Using andThen() value is : " + f1.andThen(f2).apply(2));  //here for andThen(), input is 2 so f1 will give 4 andThen will perform operation on 4 resulting f2 = 64

        System.out.println("Using compose() value is : " + f1.compose(f2).apply(2)); //here for compose(), input is 2 soo first f2 will execute and give 8 , then f1 operates on it and results in 16


    }
}