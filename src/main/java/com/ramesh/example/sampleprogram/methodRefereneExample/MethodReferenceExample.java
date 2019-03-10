package com.ramesh.example.sampleprogram.methodRefereneExample;

/*
     Functional Interface can refer to the Lambda expression and method reference,
        hence method reference can be the alternative to the Lambda expression.
     Method reference is another powerful feature that comes with Java 1.8. Method reference is implied using ::
       The main objective of method reference is for the code re usability. and is the alternative syntax to the Lambda expression.
          As the name refers the method reference is just a way to reference to another method which serves the same purpose. so that the same blocks of code does not have to be written all over again for functional interface
     :: (Double colon operator )is used for method reference and constructor reference

      Requirement to use ::
        ~ To be able to use method reference, the method argument must be same. method Name, access modifier and return type can be different
        ~ to be able to use method reference, the target method (the method you want to use) can be static method or instance method.
           For Static Method
             ~ Syntax : className :: methodName     //Just the methodName, No(parenthesis)
           For Instance Method (non static method)
             ~ Syntax : ObjectReference :: methodName
               e.g Test t = new Test()  // t is the object reference
                   t :: methodName      //method Reference
      Restriction to use ::
        ~
 */

//Functional interface
interface someInterface {
    void someMethod1();
}

//This example demonstrate how to use method reference for static methods
public class MethodReferenceExample {
    public static void someMethod2(){
    System.out.println("I want to reuse this again!");
    }
  public static void main(String[] args) {
        someInterface interf = MethodReferenceExample :: someMethod2;  //Here the someMethod2() has the block of code that I need for someMethod1() so instead of
                                                                      // writing the same code block, with method reference I can use the code block of someMethod2()
        interf.someMethod1();
  }
}

/*
   In this example, lets double up the thread
     since we know there are two ways to initiate the thread
         1. By extending the Thread Class
         2. By implementing the Runnable interface , contains one method Run() method.
             There are three ways we can define the thread
                a) Runnable r = new MyRunnable()   // I will write myRunnable class to write the implementation
                b) Runnable r = Lambda Expression  //Using lambda expression
                c) Runnable r = method reference   //Using method reference
              then, Thread t = new Thread(t);
                    t.start();

 */

//This example demonstrate how we can initiate a thread using lamnda expression
class ThreadUsingLambda {

  public static void main(String[] args) {

      Runnable r = () -> {
          for(int i = 0; i < 5; i++) {
              System.out.println("Child Thread");
          }
      };

      Thread t = new Thread(r);
      t.start();
    for (int i = 0;i < 5; i++) {
        System.out.println("Main thread");
    }

  }
}

class ThreadUsingMethodReference {

    public void method(){             //Here method() has the same argument type as run() so run can be referenced with method()
        for(int i = 0; i < 5; i++) {
            System.out.println("Child Thread");
        }
    }

  public static void main(String[] args) {

      ThreadUsingMethodReference obj = new ThreadUsingMethodReference();   //instantiating object for class ThreadUsingMethodReference
      Runnable r = obj :: method;     //Since method is an instance method, it has to be reference using the object reference of the class

      Thread t = new Thread(r);
      t.start();

    for (int i = 0; i < 5; i++){
      System.out.println("Main Thread");
    }
  }
}


//Constructor reference example
class Sample {
    //No-Args constructor
    public Sample(){
       System.out.println("Constructor execution");
    }
}

interface Interf {
     Sample get();
}

class ConstructorReferenceExampleUsingLambda {

  public static void main(String[] args) {

      Interf interf = () -> {
          Sample sample = new Sample();
          return sample;
      };

      Sample sample = interf.get();
  }
}

class ConstructorReferenceExampleUsingMethodReference {

  public static void main(String[] args) {
    Interf interf = Sample::new;        //since For class Sample new keyword will refer the no args constructor
      Sample sample = interf.get();
  }
}


//Another Example from Dzone
@FunctionalInterface
interface IntPredicate {
    boolean check(int i);
}

class IntPredicatesChecker {
    // A static method for checking if  a number is positive
    public static boolean isPositive(int n) {
        return n > 0;
    }
    // A static method for checking if a number is even
    public static boolean isEven(int n) {
        return (n % 2) == 0;
    }
}


class StaticMethodReferenceDemo {

    //o-args / default constructor
    public StaticMethodReferenceDemo() {
    }

    // This method takes a functional interface as the type of its first parameter. Thus it can accept a reference to any instance of that
    // interface, including one created by a method reference
    public boolean numCheck(IntPredicate p, int n) {
        return p.check(n);
    }

    public static void main(String[] args) {
        StaticMethodReferenceDemo demo = new StaticMethodReferenceDemo();
        boolean result;

        int num = 9;
        // Here, Using lambda expression to check if a number is even
        IntPredicate lb1 = number -> (number % 2) ==0;
        result = demo.numCheck(lb1, num);
        System.out.println("Using lambda expression: " + num + " is even: " + result);

        // Here, a method reference to  static method isEven of IntPredicatesChecker is passed to numCheck().
        result = demo.numCheck(IntPredicatesChecker::isEven, num);
        System.out.println("Using static method reference: " + num + " is even: " + result);

        // Here, Using lambda expression to check if a number is positive
        IntPredicate lb2 = number -> number > 0;
        result = demo.numCheck(lb2, num);
        System.out.println("Using lambda expression: " + num + " is positive: " + result);

        // Here, a method reference to  static method isPositive of IntPredicatesChecker is passed to numCheck().
        result = demo.numCheck(IntPredicatesChecker::isPositive, num);
        System.out.println("Using static method reference: " + num + " is positive: " + result);
    }
}