package com.ramesh.example.sampleprogram.predicateLambdaExample;

import org.springframework.util.StringUtils;
import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.function.Predicate;


public class Employee {

    String name;
    String designation;
    double salary;
    String city;

    public Employee(String name, String designation, double salary, String city) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %.2f, %s]", name, designation, salary, city);
    }

    //This is must to compare the object based on field level, if not we will get object not equal to all the time
    @Override
    public boolean equals(Object obj) {
    Employee employee = (Employee) obj;
    if(name.equals(employee.name) && designation.equals(employee.designation) && salary == employee.salary && city.equals(employee.city)) {
        return true;
    }else
        return false;
    }
}


class ExecuteEmployee {

    public static void main(String[] args) {

        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        addEmployeeIntoTheList(employeeArrayList);

        System.out.println("Employee List" + employeeArrayList);


        Predicate<Employee> getManger = employee -> employee.designation.equalsIgnoreCase("Manager"); //get the manager from the list
        System.out.println("Manager from ths employee list ");
        display(getManger, employeeArrayList); //display the manager only

        Predicate<Employee> getIrving = employee -> employee.city.equalsIgnoreCase("Irving");  //get the employee from the Irving
        System.out.println("Employees from the city Irving ");
        display(getIrving, employeeArrayList);  // display employee from Irving

        Predicate<Employee> getSalary = employee -> employee.salary < 40000;  // get the employee with salary less than 40000
        System.out.println("Employee with salary less that 40000 : ");
        display(getSalary, employeeArrayList);

        //predicate joining on employee who is a manager and from Irving [use and() default method]
        System.out.println("filter out the manager from irving only");
        display(getManger.and(getIrving), employeeArrayList);   // since predicate getManager is filtering out manager and getIrving is filtering out the city Irving we can use AND method to get the joined result

        //using  .or() default method
        System.out.println("Mangers with salary less than 40000");
        display(getManger.or(getSalary), employeeArrayList);

        //Display the employees who are not managers
        System.out.println("Employees who are not managers");
        display(getManger.negate(),employeeArrayList);

        //Use Static method isEqual to define an object and check it any other object is equal to that or not
        Predicate<Employee> isCEO = Predicate.isEqual(new Employee("harry", "CEO", 70000 ,"Irving"));  //here we created a predicate isCEO which holds an employee object

        Employee Emp1 = new Employee("Dan", "Developer", 80000 ,"Saint louis");
        Employee Emp2 =  new Employee("harry", "CEO", 70000 ,"Irving");
        System.out.println("Is emp1 CEO ? " + isCEO.test(Emp1));  //False
        System.out.println("Is emp2 CEO ? " + isCEO.test(Emp2)); //True
        //Note to get the equals method on the employee object we have to override the equals method if not the the equal method
        // from object class will be called resulting in false result
   }

   //Method to add employee object in the employee List
    public static void addEmployeeIntoTheList(ArrayList<Employee> employeeArrayList){
        employeeArrayList.add( new Employee("Dan", "Developer", 80000 ,"Saint louis"));
        employeeArrayList.add( new Employee("harry", "CEO", 70000 ,"Irving"));
        employeeArrayList.add( new Employee("steven", "Manager", 30000 ,"Irving"));
        employeeArrayList.add( new Employee("henry", "BA", 100000.0 ,"arizona"));
        employeeArrayList.add( new Employee("david", "Manager", 40000 ,"oklahoma"));
        employeeArrayList.add( new Employee("prem", "DevOps", 600000.00 ,"newYork"));
    }

    //Display the filtered result
    public static void display(Predicate<Employee> predicate, ArrayList<Employee> employees){

        for(Employee employee : employees){
            if(predicate.test(employee)){
                System.out.println(employee);
            }
        }
    }
}

