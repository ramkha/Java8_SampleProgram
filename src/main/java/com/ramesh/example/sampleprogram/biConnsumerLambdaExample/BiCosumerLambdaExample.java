package com.ramesh.example.sampleprogram.biConnsumerLambdaExample;


/*
   Unlike Consumer, that takes one input type T and does not return anything.
           BiConsumer takes two input Argument Type T and U and returns nothing.
              void accept(T t, U u);
 */

import java.util.function.BiConsumer;

//This sample example takes two input, concatenate and prints the output
public class BiCosumerLambdaExample {

  public static void main(String[] args) {

      BiConsumer<String,String> biConsumer = (a,b) -> System.out.println(a+b);

      biConsumer.accept("Ramesh", "Khadka");

  }
}
