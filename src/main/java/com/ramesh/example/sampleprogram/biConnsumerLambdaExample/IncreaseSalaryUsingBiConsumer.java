package com.ramesh.example.sampleprogram.biConnsumerLambdaExample;

/*
    Using Bifunction and Biconsumer, we will increase the salary of an existing employee,
        Here Bifunction will be used to create an employee object, (function takes input, perform operation and return some type)
                and Biconsumer will be used to increase the salary, (consumer will take input, and perform some operation and doesnot return anything)
 */

import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapAutoConfiguration;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

//Employee POJO
class Employee {

    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

//This example will demonstrate the use of bifunction and biconsumer
public class IncreaseSalaryUsingBiConsumer {

  public static void main(String[] args) {

      BiFunction<String, Double, Employee> biFunction = (n,s) -> new Employee(n,s);

      ArrayList<Employee> employees = new ArrayList<>();
      employees.add(biFunction.apply("Ramesh",50000.00));
      employees.add(biFunction.apply("Shyam",40000.00));
      employees.add(biFunction.apply("Hari",35000.00));

    BiConsumer<Employee,Double> biConsumer = (e,increment) -> e.salary = e.salary + increment;

    System.out.println("Incresing salary by 500 for all the employee : ");

    for (Employee employee : employees){
        biConsumer.accept(employee,500.00);
    }

    System.out.println("After Increasing Salary : " + employees);
    for (Employee e : employees ){
      System.out.println("Name : " + e.name);
      System.out.println("Salary : " + e.salary);
    }
  }
}
