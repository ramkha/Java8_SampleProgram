package com.ramesh.example.sampleprogram.consumerLambdaExample;

import java.util.function.Consumer;

/*
   Consumer Interface is a functional interface provide by java,
       It contains an abstract method, void accept(T t), which accept Type t, perform operation and does not return anything unlike Predicate and Function interface abstract method
*/
public class ConsumerLambdaExample {

  public static void main(String[] args) {

    Consumer<String> consumer =
        s -> {
          System.out.println(s);
          System.out.println(s);
        };

   consumer.accept("Print This");
  }
}



