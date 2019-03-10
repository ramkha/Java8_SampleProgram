package com.ramesh.example.sampleprogram.staticMethodConceptLambda;

interface StaticMethodClass{
    /*
       The main purpose of declaring static method is to define the GENERAL UTILITY METHOD which can be used by everyone, implementation and non-implementation class
     */
     public static void staticMethod(){
        System.out.println("This is message from the static method");
    }
}

//Implementation class, it holds example on how the static method in interface class can be called
public class StaticMethodInIInterfaceClass implements StaticMethodClass {

    public static void main(String[] args) {

        //1. Cannot call the static method directly because the method is not available to the implementation class
             //staticMethod();

        //2. We cannot call the static method using implementation class object because by default static method is not available to the implementation class object
            /* StaticMethodInIInterfaceClass newObj = new StaticMethodInIInterfaceClass();
               newObj.staticMethod();
              */

        //3. We cannot call the static method using Implementation class Name because by default static method is not available to the implementation class
            // StaticMethodInIInterfaceClass.staticMethod();

        //4. The only way to call the static method from Interface class is by using Interface name only whether its being called from implementation class or non-implementation class
            StaticMethodClass.staticMethod();
    }
}


 //Overriding concept is not applicable for static method in Interface class, because static method is not available to the implementation class,
//Example - 1 - Even with the same static method name as interface class, it is not OVERRIDING
class SameMethodNameAsStaticMethod implements StaticMethodClass{

    //This is completely applicable, even after having same static method name it is not OVERRIDING
    public static void staticMethod(){
        System.out.println("This is not the overriding of the static method from interface class");
    }

    public static void main(String[] args) {
        SameMethodNameAsStaticMethod newObj = new SameMethodNameAsStaticMethod();
        newObj.staticMethod();
    }
}

//Example - 2 - changing static to non static
class SameMethodNameWithoutStatic implements StaticMethodClass{

    //This is completely valid, even after removing static method name it will execute fine, because the static method in interface and the below method are different as
    // the static method is not available to the implementation class. In normal scenario, the static method cannot be modified to non-static while overriding it. since it is not overriding
    // the interface static method, this is valid.
    public void staticMethod(){
        System.out.println("This is not the overriding of the static method from interface class - This is non-static method ");
    }

    public static void main(String[] args) {
        SameMethodNameWithoutStatic newObj = new SameMethodNameWithoutStatic();
        newObj.staticMethod();
    }
}


//Example - 3 - changing modifier from public to private
class SameMethodNameWithChangingModifier implements StaticMethodClass{

    //This is completely valid, even after changing the modifier method, it will execute fine, because the static method in interface and the below method are different as
    // the static method is not available to the implementation class. In normal scenario, the public static method modifier cannot be modified  while overriding it. since it is not overriding
    // the interface static method, this is valid.
    private static void staticMethod(){
        System.out.println("This is not the overriding of the static method from interface class - This is after modifying the modifier");
    }

    public static void main(String[] args) {
        SameMethodNameWithChangingModifier newObj = new SameMethodNameWithChangingModifier();
        newObj.staticMethod();
    }
}


//After Java 1.8 since we can declare static method inside interface class, we can also declare main method and run and compile interface class from command prompt
interface mainMethod {
    public static void main(String[] args) {
        System.out.println("This is main method from Interface class, how coool");
    }
}