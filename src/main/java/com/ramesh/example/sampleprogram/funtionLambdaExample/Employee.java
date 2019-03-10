package com.ramesh.example.sampleprogram.funtionLambdaExample;


import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class Employee {

    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("[%s,%.2f]", name, salary);
    }

}

//This example evaluates the total salary paid to the employees
class ExecuteEmployee {
    public static void main(String[] args) {
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        addEmployeeIntoTheList(employeeArrayList);

        System.out.println("Employee List" + employeeArrayList);

        Function<ArrayList<Employee>, Double> function = employees -> {
            double totalSalary = 0;
            for(Employee employee : employees){
                totalSalary = totalSalary + employee.salary;
            }
            return totalSalary;
        };
        System.out.println("The total salary of the employees is " + function.apply(employeeArrayList));

        /*
           With  this example Below I want to increase the salary of the employee with salary less than 4000 by 500
              Steps to be considered , 1) Filter out the employee having salary less than 4000
                                       2) Apply the increment of 500 on them.
         */

        Predicate<Employee> predicate = employee -> employee.salary <= 4000; //check if the employee salary is less than equal to 4000

        // Function<Employee, Double> f = employee -> employee.salary + 500;  //Adds 500 to the salary
        // displayFilteredEmployee(predicate, f, employeeArrayList);


        //Second way is to get employee object increase the salary and return the updated employee, and add that to the new arraylist of updated employee list
        Function<Employee, Employee> f = employee -> {
            employee.salary  = employee.salary + 500;
            return employee;
        };

        ArrayList<Employee> salaryUpdatedEmployee = new ArrayList<>();


        for(Employee employee : employeeArrayList) {
            if(predicate.test(employee)) {
                f.apply(employee);
                salaryUpdatedEmployee.add(employee);
            }
        }

        System.out.println("List of employee whose salary is raised by 500 : " + salaryUpdatedEmployee);
        }


   //Method to add employee object in the employee List
    public static void addEmployeeIntoTheList(ArrayList<Employee> employeeArrayList){
        employeeArrayList.add( new Employee("Dan", 5000));
        employeeArrayList.add( new Employee("harry", 2000 ));
        employeeArrayList.add( new Employee("steven",  4000 ));
        employeeArrayList.add( new Employee("henry", 2500 ));
        employeeArrayList.add( new Employee("david",  9000 ));
        employeeArrayList.add( new Employee("prem",  10000 ));
    }

    public static void displayFilteredEmployee(Predicate<Employee> predicate, Function<Employee, Double> function,  ArrayList<Employee> employees){
     for(Employee employee : employees){
         if(predicate.test(employee)){
             System.out.println("Salary Increased by 500 for : ");
             System.out.println(" Employee Name : " + employee.name);
             System.out.println(" Employee new Salary : " + function.apply(employee));
             System.out.println();
         }
     }
  }
}

