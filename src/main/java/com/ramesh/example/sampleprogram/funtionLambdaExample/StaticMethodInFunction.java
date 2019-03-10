package com.ramesh.example.sampleprogram.funtionLambdaExample;

/*
     Function interface has a static method , identity(), as name implies, it returns the same function provided to it like replica of the function. use of this static method is very rare but still
     can be useful in the handful scenario
         static <T> Function<T,T> identity() , returns a function tat always returns its input argument
 */

import java.util.function.Function;

//Demo class for identity()
public class StaticMethodInFunction {

    public static void main(String[] args) {

        Function<String, String> function = Function.identity();  //calling static method using interface class name
        String s = function.apply("Ramesh");                   //passing string "Ramesh" as an input argument and identity() will return exact same thing
        System.out.println(s);                                  //Returns same input string "Ramesh" and assign it tot the s
    }

}
