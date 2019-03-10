package com.ramesh.example.sampleprogram.consumerLambdaExample;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//student POJO class
class Student {

    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

// This example display the student display that has marks > 60 .
//     for this we have three Condition
//        1. student > 60 = we can use predicate to filter
//        2. Get the Grades of the filtered student  = we can use Function to perform operation on
// filtered student
//        3. Display the details of those student   = we can use Consumer to display the student
public class StudentDisplayExample {

  public static void main(String[] args) {
    ArrayList<Student> students = new ArrayList<>();
    populateStudent(students);

    // First condtion to filter out the student having marks > 60 are filtered using Prdicate
      Predicate<Student> p = student -> student.marks >= 60;

    // On the filtered student we want to get the Grades based on the marks of the student
    Function<Student, String> f =
        student -> { // Gets the marks from the student and based on the marks return the grades
          int marks = student.marks;
          return (marks >= 80)
              ? "A [Distinction]"
              : (marks >= 60)
                  ? "B [First class]"
                  : (marks >= 50)
                      ? "C [Second class]"
                      : (marks >= 40) ? "D [Third Class]" : "F [Fail]";
        };

    //Consumer to display the student details
      Consumer<Student> c = s -> {
          System.out.println("Student Name : " + s.name);
          System.out.println("Student Marks : " + s.marks);
          System.out.println("Grade of student : " + f.apply(s));
          System.out.print("\n");

      };

    // Display the student with marks > 60
    display(p,c,students);
  }

  public static void populateStudent(ArrayList<Student> students) {
    students.add(new Student("Ram", 75));
    students.add(new Student("Shyam", 55));
    students.add(new Student("Hari", 85));
    students.add(new Student("Krishna", 90));
    students.add(new Student("Sita", 30));
  }

  public static void display(Predicate<Student> predicate, Consumer<Student> consumer ,ArrayList<Student> students) {
    for (Student student : students) {
      if (predicate.test(student)) {
          consumer.accept(student);
      }
    }
  }
}