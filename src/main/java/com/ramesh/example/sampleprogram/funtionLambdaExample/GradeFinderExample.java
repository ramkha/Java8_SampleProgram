package com.ramesh.example.sampleprogram.funtionLambdaExample;

import java.util.ArrayList;
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

//This example demonstrate the find the grade of the student using Funtion interface
public class GradeFinderExample {

    public static void main(String[] args) {

       ArrayList<Student > students = new ArrayList<>();
        populateStudent(students);

        Function<Student,String> f = student -> {           //Gets the marks from the student and based on the marks return the grades
            int marks = student.marks;
            return (marks >= 80) ? "A [Distinction]" : (marks >= 60) ? "B [First class]":(marks >= 50) ? "C [Second class]" : (marks >= 40) ? "D [Third Class]" : "F [Fail]";
        };

        //Display students with Function
        System.out.println("Displaying all the student list ");
        display(f, students);

        Predicate<Student> p = student -> student.marks >= 60;

        //Display function with Function and predicate
        System.out.println("Displaying student with marks greater than 60");
        displayWithPredicate(p,f,students);
    }

    public static void populateStudent(ArrayList<Student> students){
        students.add(new Student("Ram", 75));
        students.add(new Student("Shyam", 55));
        students.add(new Student("Hari", 85));
        students.add(new Student("Krishna", 90));
        students.add(new Student("Sita", 30));
    }

    public static void display(Function<Student,String > function, ArrayList<Student> students){
        for(Student student : students){
            System.out.println("Student Name : " + student.name);
            System.out.println("Student Marks : " + student.marks);
            System.out.println("Grade of student : " + function.apply(student));
            System.out.print("\n");
        }
    }
    public static void displayWithPredicate(Predicate<Student> predicate,Function<Student, String > function, ArrayList<Student> students){
        for(Student student : students){
            if(predicate.test(student)) {
                System.out.println("Student Name : " + student.name);
                System.out.println("Student Marks : " + student.marks);
                System.out.println("Grade of student : " + function.apply(student));
                System.out.print("\n");
            }
        }
    }

}
