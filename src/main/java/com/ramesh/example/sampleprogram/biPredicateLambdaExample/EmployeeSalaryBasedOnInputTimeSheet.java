package com.ramesh.example.sampleprogram.biPredicateLambdaExample;

/*
  Calculate the employee monthly salary using Bi-Function since, Bi-function takes two input,
         which in this case is employee and timesheet , then perform operation on it and return the salary.

 */
import java.util.function.BiFunction;

//POJO Employee
class Employee{
    int empNo;
    String empName;
    double empDailyPay;

    public Employee(int empNo, String empName, double empDailyPay) {
        this.empNo = empNo;
        this.empName = empName;
        this.empDailyPay = empDailyPay;
    }
}

//POJO Timesheet
class TimeSheet {

    int empNo;
    int days;

    public TimeSheet(int empNo, int days) {
        this.empNo = empNo;
        this.days = days;
    }
}

//This example takes in the timesheet of any employee and calculates the monthly salary based on the timesheet
public class EmployeeSalaryBasedOnInputTimeSheet {

  public static void main(String[] args) {

      Employee employee = new Employee(1, "Ramesh", 300.00);
      TimeSheet timeSheet = new TimeSheet(1,30);

      //Defining bifunction that take two input and return Double type.
      BiFunction<Employee,TimeSheet,Double> function = (e,t) -> {
        if(e.empNo == t.empNo){
             return  e.empDailyPay * t.days;
          }
        return 0.0;
      };

    System.out.println("Salary of the employee Ramesh : " + function.apply(employee,timeSheet));
  }
}
