package com.ramesh.example.sampleprogram.anonymousInnerClassExample;


@FunctionalInterface
interface TryMe{
    void someMethod(); // This is eligible for lambda Expression
}

 /*
    Another Differences between Anonymous class and Lambda Expression is the use of 'this' reference
    Following class is an implementation example on how 'this' keyword references to the current instance object of the inner class.
 */
public class ThisReferenceWithAnonymousClass extends ThisMethod {

    public static int someVariable = 555;  //Instance variable ca

    public void method1(){
        TryMe t = new TryMe() {
            int someVariable = 999; // Instance variable can be declared inside the anonymous inner class ; one of the powerful feature of using anonymous inner class
            @Override
            public void someMethod() {
                System.out.println("Value of someVariable from innerclass : " + this.someVariable); // prints 999, since AIC will always refers to the current Internal anonymous class object
                //Example to print this reference of external class
               // System.out.println("Value of someVariable from innerclass : " + ThisReferenceWithAnonymousClass.this.someVariable); // prints 555
            }
        };
        System.out.println("Value of someVariable from class : " + this.someVariable); // prints 999, since AIC will always refers to the current Internal anonymous class object
       // System.out.println("Value of someVariable from class : " + someVariable); // prints 999, since AIC will always refers to the current Internal anonymous class object
        System.out.println("This is super class variable " + super.someVariable);
        t.someMethod();
    }

    public static void main(String[] args) {
        ThisReferenceWithAnonymousClass newObj = new ThisReferenceWithAnonymousClass();
        newObj.method1();
    }
}

class ThisMethod {
    public int someVariable = 222;
}
/*
   Another Differences between Anonymous class and Lambda Expression is the use of this reference
   Following class is an implementation example using Lambda Expression, and explores on how 'this' keyword references to the external class instance object only.
   One of the drawback of the Lambda expression, since Lambda does not have object concept.
*/

class ThisReferenceWithLambdaExpression {

    public int someVariable = 555; // Instance variable ca

    public void method1(){
        int someVariable = 999; // this will be treated as a local variable instead of creating it as instance variable; Lambda does not have concept of object creation
        TryMe t = () -> {
            System.out.println("Value of someVariable from Lambda Expression : " + this.someVariable); //prints 555, in lambda will always refers to the current External object
        };
        t.someMethod();
    }

    public static void main(String[] args) {
        ThisReferenceWithLambdaExpression newObj = new ThisReferenceWithLambdaExpression();
        newObj.method1();
    }
}


/*
   Variable declared inside the method, and referenced from lambda are considered as local variable, and they are explicitly final variable meaning the value are freeze and hence cannot be changed at all.
*/
class LocalVariableLambdaExample {

    public int x = 111; //class level enclosure variable

    public void method(){

        int y = 666; // local variable, is explicitly final and value is freeze if referenced fromm the lambda expression

        TryMe t = () -> {
            int z = 888;
            System.out.println("Value of External class variable : " + x);  // prints 111, class level variable are totally accessible from lambda expression
            System.out.println("Value of local Lambda variable : " + y );   // printa 666, Local variable are totally accessible from Lambda Expression

            x = 222;
            System.out.println("Value of External class variable : " + x);  // prints 222,  Since its class level variable, value can be altered as it is not final

            //y = 777;
           //System.out.println("Value of local Lambda variable : " + y ); // This will give us Compile Time Error, as local variable are explicitly final,are freeze inside Lambda, and cannot be altered.

            System.out.println("Value of z wihtin lambda expression " + z);

            z = 999;
            System.out.println("Value of z will change since its within a control of lamnbda expression  " + z);
        };
        t.someMethod();
    }

    public static void main(String[] args) {
        LocalVariableLambdaExample newObj = new LocalVariableLambdaExample();
        newObj.method();
    }
}

