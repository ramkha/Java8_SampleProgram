package com.ramesh.example.sampleprogram.primitiveTypeFunctionalInterface;
import java.util.ArrayList;
import java.util.function.*;

/*
    Primitive Type Functional Interface:-
          To understand PTFI, we first need to have a understanding of three things :-
    1. Autoboxing :-
    => Autoboxing is the automatic conversion of primitive type to wrapper object.Until Java 1.4 , it was not allowed to declare primitive data type to object.
          e.g Integer i= 10 ; //This was Invalid, as 10 is a primitive type 'int' and Integer is an object
            but from 1.5 onwards, declaring Integer i= 10; was valid since compiler took responsibility to do conversion.
            on this example above, compiler will internally convert primitive int type to Integer object Type.
             i.e Integer i = 10 will be internally converted as Integer i = Integer.valueOf(10) by the java compiler
             ~ This whole concept is called AUTOBOXING concept.

     2. AutoUnboxing : -
     => AutoUnboxing is the automatic conversion of wrapper object to primitive type. It is a reverse concept of autoboxing.
           e.g Integer i = new Integer(10);
               int x = i  // compiler will convert object type Integer to primitive type int internally
               i.e internally int x = i.intValue(); will be executed by compiler

     3. Generics - Type parameter :-
     => Generics are indicted by '< >'. The only thing we need to know is, only object type is allowed for generic type parameter, primitive type is not supported and are invalid
         e.g ArrayList<Integer> list = new ArrayList<Integer>(); is valid since generic type is Integer
              but ArrayList<int> list = new ArrayList<int>(); is invalid as primitive type are not allowed in generic type

    "But the big need is to understand why do we need this primitive type functional interface"

   Primitive Type Functional Interface for Predicate : -
             For predicate there are 3 primitive type functional interfaces available
         1. interface IntPredicate {
             public boolean test(int i)  //always takes int as an input type
             //Rest of the default and static methods are same
         }

         2. interface LongPredicate {
             public boolean test(Long l)  //always takes long as an input type
             //Rest of the default and static methods are same
         }

         3. interface DoublePredicate {
             public boolean test(double d)  //always takes double as an input type
             //Rest of the default and static methods are same
         }

   Primitive Type Functional Interface Function : -
            For function there are 15 primitive type functional interfaces available

 # Input Type
         1. interface IntFunction <R> {
                public R apply(int i); // This always takes int as an input instead of Integer(requires conversion if used) and return type is R
            }
         2. interface LongFunction <R> {
                public R apply(long l); // This always takes long as an input instead of Integer(requires conversion if used) and return type is R
            }
         3. interface IntFunction <R> {
                public R apply(double d); // This always takes double as an input instead of Integer(requires conversion if used) and return type is R
            }

 # Return Type specify, and input type T
         4. interface ToIntFunction <T> {
                public int applyAsInt(T t); // This always return int regardless of any input type
            }
         5. interface ToLongFunction <T> {
                public long applyAsLong(T t); // This always return long regardless of any input type
            }
         6. interface ToDoubleFunction <T> {
                public double applyAsDouble(T t); // This always return double regardless of any input type
            }

 # inputToOutput
         7. interface IntToLongFunction {
                public long applyAsLong(int i); //
            }
         8. interface IntToDoubleFunction{
                public double applyAsDouble(int i); //
            }

 #
         9. interface LongToIntFunction {
                public int apply(long l);     //
            }
        10. interface LongToDoubleFunction {
                public double apply(long l);  //
            }
 #
        11. interface DoubleToIntFunction {
                public int apply(double d);   //
            }

        12. interface DoubleToLongFunction {
                public long apply(double d);  //
            }
 #
        13. interface ToIntBiFunction <T, U> {
                public int applyAsInt(T t, U u);
            }
        14. interface ToLongBiFunction <T, U> {
                public long applyAsLong(T t, U u);
            }
        15. interface ToDoubleBiFunction <T, U> {
                public double applyAsDouble(T t, U u);
            }

   primitive type functional interface for Consumer
                For Consumer there are 6 primitive type functional interfaces available
         1. interface IntConsumer {
              public void accept(int i);   // This always takes int as an input instead of Integer(requires conversion if used) and does not return anything
            }
         2. interface LongConsumer {
              public void accept(long l);   // This always takes long as an input instead of Integer(requires conversion if used) and does not return anything
            }
         3. interface DoubleConsumer {
              public void accept(double d);   // This always takes double as an input instead of Integer(requires conversion if used) and does not return anything
            }
         4. interface ObjIntConsumer<T> {
              public void accept(T t,int value);  // This always accepts and object and int as inputs instead of Integer(requires conversion if used) and does not return anything
            }
         5. interface ObjLongConsumer<T> {
              public void accept(T t,long value); // This always accepts and object and long as inputs instead of Integer(requires conversion if used) and does not return anything
            }
         6. interface ObjDoubleConsumer<T> {
              public void accept(T t,double value); // This always accepts and object and double as inputs instead of Integer(requires conversion if used) and does not return anything
            }

    primitive type functional interface for Supplier
            Basically supplier does not takes any input type, but always return R type which can be anything. We should go for primitive type for Supplier
              if we know we have to return some primitive data type. For Supplier there are 4 primitive type functional interfaces available
         1. interface IntSupplier {
              public int getAsInt();  // This always return int data type only
            }
         2. interface LongSupplier {
              public long getAsLong();  //This always return long data type only
            }
         3. interface DoubleSupplier {
              public double getAsDouble();  //This always return double type only
            }
         4. interface BooleanSupplier {
              public boolean getAsBoolean();  //This always return Boolean type only
            }

  */



public class AutoBoxingExample {

  public static void main(String[] args) {
    //Compiler will automatically convert primitive int type to object type Integer
      Integer i = 10;      //Autoboxing concept being executed by compiler
      System.out.println(i);
  }
}

class AutoUnboxingExample {
  public static void main(String[] args) {
    //Compiler will automatically convert Object type to primitive int type,
      Integer i = new Integer(10);
      int x = i;   //AutoUnboxing concept

    System.out.println(x);
  }
}

class GenericTypeParamExample {
  public static void main(String[] args) {
         ArrayList<Integer> arrayList = new ArrayList<Integer>(); // valid since generic type is Integer, which is object type
      // ArrayList<int> arrayList1 = new ArrayList<int>(); // invalid since primitive type are not valid generic type parameter
  }
}

//This class outline the drawback of using the other functional interfaces in some scenario's which drastically drains the performance using find even number example
class WhyPrimitiveTypeFunInterf {
  public static void main(String[] args) {

     int[] x = {0,1,2,3,4,5,6,7,8,9};   // declaring int(primitive data type),

     //Tradition Predicate interface use
      Predicate<Integer> predicate = i -> i % 2 ==0;  //Here predicate takes input type Integer( Integer type Object )
                                                    // i is Integer type as a input param, but to perform the mathematical operation, i has to be a primitive data type,
                                                   // int this case int. so here autoUnboxing occurs for i
      for(int x1 : x){
          if(predicate.test(x1)){  //Here x1 is a int(Primitive data type) and whenever test() is called, since predicate accepts Integer(Object type) only, for each x1 autoboxing occurs
              System.out.println("Even numbers are : " +x1);
          }
      }
      //In conclusion for this small piece of code, autoboxing is performed 10 times and autoUnboxing is performed 10 times
      // ?? bad practise, right! so question is when should we know what to use and not.

      // Simple, when we know the input and return type is any primitive data type then instead of using this traditional functional interface we should
      // always go for primitive type functional interfaces, and why? to improve the performance!
  }
}

//This example demonstrate the use of primitive type functional interface in Predicate Interface
class UsingPrimitiveTypeFunInterfOnPredicate {
  public static void main(String[] args) {

      int[] x = {0,1,2,3,4,5,6,7,8,9};   // declaring int(primitive data type),

      IntPredicate predicate = i -> i % 2 == 0; //IntPredicate is a primitive type functional interface, which does not require any type param as Int is already there
                                                // No autoboxing and autoUnboxing required as long as we pass primitive data type int.
      for(int x1 : x){
          if(predicate.test(x1)){
              System.out.println("Even numbers are : " +x1);
          }
      }
  }
}

//This example using function interface we will get the square of the given int and draw the performance issues
class UsingFunctionToOutlineDrawback {
  public static void main(String[] args) {

      Function<Integer,Integer> function = integer -> integer * integer;
      System.out.println("square of 4 is :" + function.apply(4));       // here 4 is a primitive int data type, everytime we call apply(),
                                                                        // int has to be converted to Integer(Autoboxing), and again Integer has to be converted to int(Unboxing)
                                                                       // and again after that int has to be again converted back to the Integer, since return type is Integer
                                                                      // lots of Mumbo-jumbo so better use the function with primitive type functional interface
  }
}

//In this example, we will see how we can accelerate the performance using  primitive type fun interface
class UsingPrimitiveTypeFunInterfOnFunction {
  public static void main(String[] args) {
      IntFunction<Integer> function = i -> i*i;  //here we don't required to mention the input type Integer, but return type has to be implied,
                                                // that means only during returning the result autoboxing has to be performed, this reduced the
                                                // half of the conversion and boost the performance
      System.out.println("Square is : " + function.apply(5));
  }
}

   //In his example, we will use one more primitive type functional interface for function that can reduce the conversion or possibly eliminate
 //Example takes String as an input and returns the length
class UsingPrimitiveTypeToIntFunInterfOnFunction {

  public static void main(String[] args) {
      //Traditional way without using primitive type interface

      /*
          Function<String, Integer> function = s -> s.length(); // here once s.length() gives result in int, it has to be converted back to Integer
          System.out.println("square of 4 is :" + function.apply("Ramesh"));
      */

      ToIntFunction<String > function = s -> s.length(); //Here no matter the input type, Int will be the return type. hence no unboxing required
      System.out.println("square of 4 is :" + function.applyAsInt("Ramesh"));  //instead of apply() we need to use applyAsInt() method.
  }
}

   //In his example, we will use one more primitive type functional interface for function that can reduce the conversion or possibly eliminate
 //Example takes int as an input and returns the double
class UsingPrimitiveTypeIntToDoubleFunInterfOnFunction {

    public static void main(String[] args) {
        //Traditional way without using primitive type interface
        /*
           Function<Integer, Double> function = i -> Math.sqrt(i);  // here once Math.sqrt() executed it hold double value, then for return type result has to be converted back to the Double from double
           System.out.println("square root of 5 is :" + function.apply(5));
      */
        IntToDoubleFunction function = i -> Math.sqrt(i);  //Here no conversion requires
        System.out.println("square root of 4 is :" + function.applyAsDouble(4));  // instead of apply we need to use applyAsDouble() method.
    }
}

//This example demonstrate the use of primitive type functional interface for Consumer that can reduce the conversion or possibly eliminate
//Example takes the input Type T and returns nothing(Consumer perform operation only, doesnot return anything back).
class UsingPrimitiveTypeIntConsumer {

  public static void main(String[] args) {
    //Tradition Consumer Use
    /*
      Consumer<Integer> consumer = integer -> System.out.println("Square is : " + integer * integer);
      consumer.accept(10);   //passing int to the consumer that accept Integer "Boxing and unboxing involves here reduce the performance"
      */

      IntConsumer consumer = i -> System.out.println("Square is : " + i * i);  //Here IntConsumer only accepts int so no conversion requires as we are passing int to it
      consumer.accept(10);
  }
}

// This example demonstrate the use of available primitive type functional interface on Consumer
class Employee {
  String name;
  double salary;

  public Employee(String name, double salary) {
    this.name = name;
    this.salary = salary;
     }
  }

  class IncreaseEmpSalary {

  public static void main(String[] args) {

      //We will execute the two ways we can achieve this and see how performance boost with primitive type fun inter

      //1. Using traditional BiConsumer concept that takes two input and perform operation on it
      BiConsumer<Employee,Double> biConsumer = (e, s) -> e.salary = e.salary + s; //Here with this approach everytime double value will be passed, which has to be converted to Double object type "performance will go down"

      //2. Using primitive type functional interface for this Consumer, we can boost the performance
      ObjDoubleConsumer<Employee> objDoubleConsumer = (e,s) -> e.salary = e.salary + s; //Here since ObjDoubleConsumer takes double value only no conversion required

      ArrayList<Employee> employees = new ArrayList<>();
      //Lets populate the employee
      populateEmployee(employees);



      for(Employee employee : employees){
         // biConsumer.accept(employee,300.00);
          objDoubleConsumer.accept(employee, 300.00);
       }

      for(Employee employee : employees){
      System.out.println("Employee Name : " + employee.name);
      System.out.println("Employee Salary : " + employee.salary);
      }
  }

        public static void populateEmployee(ArrayList<Employee> employees){
            employees.add(new Employee("Ramesh",500.00));
            employees.add(new Employee("Shyam",800.00));
        }
  }

// This example demonstrate the use of available primitive type functional interface on Supplier
//This example demonstrate how supplier can be used in a case where we required OTP concept, digit only
class GenerateOneTimePassword {
  public static void main(String[] args) {

    // We will see two ways we can acheive this and see how using primitive type boost the prformance

       // 1. Here Supplier return type is Integer, which means the result of int has to be converted to Integer. again performance issue?
     Supplier<Integer> supplier =
        () -> (int) (Math.random() * 10); // generate the random value from 0 to 9

      // 2. Here we will use the primitive type functional interface, which will eliminate the conversion of int to Integer
     IntSupplier sup = () ->  (int) (Math.random() * 10); // generate the random value from 0 to 9

    String OTP = ""; // Empty String to hold 6 digit random value;

    for (int i = 0; i < 6; i++) {
     // OTP = OTP + supplier.get();    // requires the conversion of int to Integer
      OTP = OTP + sup.getAsInt();    //using .getAsInt() will ensure that the no conversion is required
    }
    System.out.println("One Time Password : " + OTP);
   }
}