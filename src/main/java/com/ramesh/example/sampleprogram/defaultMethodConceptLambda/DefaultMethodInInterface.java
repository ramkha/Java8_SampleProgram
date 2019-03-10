package com.ramesh.example.sampleprogram.defaultMethodConceptLambda;

/*
  With java 8, any number default class can be declared in the Interface class.
 */
 interface DefaultMethodInInterface {
    default void defaultMethod(){
        System.out.println("This is the default method");
    }
}

/*
  This class implements interface which have default methods. Implementation class can directly access the method implementation.
 */
class AccessDefaultMethodInInterface implements DefaultMethodInInterface {

    public static void main(String[] args) {
        AccessDefaultMethodInInterface newObj = new AccessDefaultMethodInInterface();
        newObj.defaultMethod();
    }
}

/*
  This class implements interface which have default methods. The default methods can be override by implementation class
 */
class OverrideDefaultMethodInInterface implements DefaultMethodInInterface {

    @Override
    public void defaultMethod() {
        System.out.println("This method gets override");
    }

    public static void main(String[] args) {
        OverrideDefaultMethodInInterface newObj = new OverrideDefaultMethodInInterface();
        newObj.defaultMethod();
    }
}
