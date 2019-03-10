package com.ramesh.example.sampleprogram.biPredicateLambdaExample;

/*
   Unlike Function, that takes one input Type T , apply some operation and return Type R
          Bi-Function as name implies takes two input argument and return type R
              R apply(T t, U u);
                Everything else like default method and static method are same for both.
 */

import java.util.ArrayList;
import java.util.function.BiFunction;

//This example takes two input value int perform multiplication and return the value
public class BiFunctionExample {

  public static void main(String[] args) {

      BiFunction<Integer,Integer,Integer> biFunction = (a,b) -> (a*b);

    System.out.println("Multiplication of value a and b is : " + biFunction.apply(5,5));
  }
}

//POJO student
class Student {

    String name;
    int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
}

//This example takes two input name and roll no and create a student object
class GenerateStudentUsingBiFunction {

  public static void main(String[] args) {

      BiFunction<String, Integer, Student> biFunction = (a,b) -> new Student(a, b);

      ArrayList<Student> students = new ArrayList<>();
      students.add(biFunction.apply("Ramesh", 13));

      for(Student student : students) {
      System.out.println("Student Name : " + student.name);
      System.out.println("Student Roll No : " + student.rollNo);
      System.out.println();
      }
  }
}