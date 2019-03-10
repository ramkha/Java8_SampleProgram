package com.ramesh.example.sampleprogram.collectionExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Employee {
    int empNo;
    String empName;

    //Constructor to instantiate the class
    public Employee(int empNo, String empName) {
        this.empNo = empNo;
        this.empName = empName;
    }

    //For Meaningful representation / printing of the object
    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", empName='" + empName + '\'' +
                '}';
    }
}

class Test {

    public static void main(String[] args) {
        //Employee ramesh = new Employee(1, "Ramesh_Khadka");
        //System.out.println(ramesh);

        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(5,"Shyam"));
        employees.add(new Employee(3,"Hari"));
        employees.add(new Employee(4,"Ram"));
        employees.add(new Employee(1,"Pandu"));
        employees.add(new Employee(2,"Jhandu"));

        System.out.println("Employees :" + employees);

        //Sort the Employees on Ascending order, using comparator [replaced with Lambdas]
        Collections.sort(employees,(e1,e2)-> (e1.empNo<e2.empNo)?-1:(e1.empNo>e2.empNo)?1:0);
        System.out.println("After Customized Sorting [Ascending]" +employees);

        //Using Anonymous Inner class
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
              return  (e1.empNo<e2.empNo)?-1:(e1.empNo>e2.empNo)?1:0 ;
            }
        });

        //Using traditional class
        Collections.sort(employees,new MyOwnImplementationCustom());

    }
}

class MyOwnImplementationCustom implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
       return (o1.empNo<o2.empNo)?-1:(o1.empNo>o2.empNo)?1:0;
    }
}