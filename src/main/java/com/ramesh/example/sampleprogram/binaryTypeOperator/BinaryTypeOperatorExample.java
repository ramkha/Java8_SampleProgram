package com.ramesh.example.sampleprogram.binaryTypeOperator;


import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

 /*
   BinaryOperator is the child class of BiFunction which can take two inputs T, U and return type R.
     The BiFunction interface takes three type parameter <T,U, R> , T and U as input and R as return
          If the input type and return type are same type, then binary operator can be used
         Syntax :- Normal BiFunction example
                          BiFunction <Integer, Integer, Integer> //here two input type is Integer and return type is Integer as well, this can be replace wih binary Operator
                   Binary operator example
                          BinaryOperator<Integer>  //Here type param is only one and will act as input type and return type also

      primitive type functional interface for BinaryOperator
        1. interface IntBinaryOperator {
             public int applyAsInt(int i);
           }
        2. interface LongBinaryOperator {
             public long applyAsLong(long l);
           }
        3. interface DoubleBinaryOperator {
             public double applyAsDouble(double d);
           }
 */

public class BinaryTypeOperatorExample {

  public static void main(String[] args) {
    // Traditional BiFunction interface
      BiFunction<String,String,String> biFunction = (a,b) -> a + b ;

      //Since the input types and return types are same we can replace this with binary operator
      BinaryOperator<String > binaryOperator = (a,b) -> a + b;

    System.out.println("Join the String : " + biFunction.apply("Ramesh","Khadka"));

      System.out.println("Join the String : " + binaryOperator.apply("Ramesh","Khadka"));

  }
}


class PrimitiveBinaryOperatorExample {

  public static void main(String[] args) {

      //BinaryOperator<Integer> binaryOperator = (a,b) -> a + b;  //Since the input types and return types are same we can replace this with binary operator,
                                                                 //Here, we will get the performance issues since int type has to be converted to object type Integer.
                                                                // we can reduce this conversion by using available primitive version of BinaryOperator
      IntBinaryOperator binaryOperator = (a,b) -> a + b;
      System.out.println("Add the int : " + binaryOperator.applyAsInt(2,3));

  }
}