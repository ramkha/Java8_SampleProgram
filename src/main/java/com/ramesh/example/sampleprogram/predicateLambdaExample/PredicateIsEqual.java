package com.ramesh.example.sampleprogram.predicateLambdaExample;

import java.util.function.Predicate;

//Predicate interface has a static method isEqual which takes any  Type t and check the input against that t, and returns boolean value
public class PredicateIsEqual {
    public static void main(String[] args) {

        //Observe to call the static method we have use the interface name, here Predicate is the interface name so we are directly calling it with Predicaate.
        Predicate<String> p = Predicate.isEqual("Checking");

        System.out.println("Is it equal? " +  p.test("wrongSting"));
        System.out.println("Is it equal? " + p.test("Checking"));

        //System.out.println("is it equal" + Predicate.isEqual("Checking"));
    }
}