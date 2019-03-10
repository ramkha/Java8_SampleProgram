package com.ramesh.example.sampleprogram.unaryTypeOperator;


import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

/*
    Unary Type operator are the child class of Function interface.
        The Function interface takes two type paramter <T, R> , T as input and R as return
          If the input type and return type are same type, then Unary operator can be used
         Syntax :- Normal function example
                          Function <Integer, Integer> //here input type is Integer and return type is Integer as well, this can be replace wih unary Operator
                   Unary operator example
                          UnaryOperator<Integer>  //Here type param is only one and will act as input type and return type also

      primitive type functional interface for UnaryOperator
        1. interface IntUnaryOperator {
             public int applyAsInt(int i);
           }
        2. interface LongUnaryOperator {
             public long applyAsLong(long l);
           }
        3. interface DoubleUnaryOperator {
             public double applyAsDouble(double d);
           }
 */

public class UnaryTypeOperatorExample {

  public static void main(String[] args) {
    //Tradition Function example
      //Function<Integer,Integer> function = i -> i*i;

    //Unary operator ; takes an int and return the square of it
       //If we observe here, the lot of boxing and unboxing is going to happen, since int type has to be converted to Integer as well.
          //so its better to go with primitive version of the unary operator to boost the performance
      UnaryOperator<Integer> unaryOperator = i -> i*i;
      System.out.println("Square of the value is : " + unaryOperator.apply(5));
  }
}

class PrimitiveUnaryTypeOperatorExample {

  public static void main(String[] args) {

      IntUnaryOperator unaryOperator = i -> i * i;
    System.out.println("Square value is : " + unaryOperator.applyAsInt(5));
  }
}
