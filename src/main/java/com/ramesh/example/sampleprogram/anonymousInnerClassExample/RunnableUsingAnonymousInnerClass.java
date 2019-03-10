package com.ramesh.example.sampleprogram.anonymousInnerClassExample;

/*
 Not all Anonymous class can be replaced with  Lambda Expression.
 Anonymous Inner class are very powerful and have more control than Lambda Expression.
 For Example, Anonymous class can be implemented for class that extends abstract class ; Lambda Expression cannot be implemented here
              Anonymous class can be implemented for class that extends Concrete class ;  Lambda Expression cannot be implemented here
              Anonymous class can be implemented for class that implements interface class with multiple abstract methods in it ;  Lambda Expression cannot be implemented here
              Anonymous class can be implemented for class that implements Functional interface class ;  Lambda Expression can be implemented here instead of anonymous inner class
 This is the class that implements Runnable interface to instantiate thread using anonymous inner class
 */

public class RunnableUsingAnonymousInnerClass {
    public static void main(String[] args) {

        //Anonymous inner class implementation
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5 ; i++) {
                    System.out.println("Child Thread");
                }
            }
        };

        Thread t = new Thread(r);
        t.start(); //As we start the thread now there are two threads i.e Main thread and child thread, main thread will continue implementing the main class, where as child thread will implement runnable method

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread");
        }
    }
}


/*
 Anonymous Inner class replaced with Lambda Expression!
 */
class RunnableUsingLambdaExpression {

    public static void main(String[] args) {

        Runnable r = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Child Thread");
            }
        };

        Thread t = new Thread(r);
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread");
        }
    }
}


/*
 Lambda Expression can be passed as an argument!
 Here In the Thread() method, we are passing the procedure/implementation body of runnable as an argument.
 */
class RunnableUsingLambdaExp {

    public static void main(String[] args) {

        Thread t = new Thread( () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Child Thread");
            }
        });

        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread");
        }
    }
}

