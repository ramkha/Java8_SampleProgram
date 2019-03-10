package com.ramesh.example.sampleprogram.defaultMethodConceptLambda;

interface LeftClass{
    default void sameMethod(){
        System.out.println("This is coming from Left Class");
    }
}

interface RightClass{
    default void sameMethod(){
        System.out.println("This is coming from Right Class");
    }
}


/*
This class implements multiple interface class, which have same default method.
 */
class SolveAmbiguityProblemByOverridingTheMethod implements LeftClass,RightClass {

    //1. First way to solve the problem is to override the default method that exist on both interface class
    @Override
    public void sameMethod() {
        System.out.println("Over riding the default method solved the issues");
    }

    public static void main(String[] args) {

        SolveAmbiguityProblemByOverridingTheMethod newobj = new SolveAmbiguityProblemByOverridingTheMethod();
        newobj.sameMethod();
    }
}

/*
This class implements multiple interface class, which have same default method.
 */
class SolveAmbiguityProblemByCallingTheSpecificImplClass implements LeftClass,RightClass {

    //2.Second way to solve the problem is to call the parent interface class default method using super class.
    @Override
    public void sameMethod() {
        LeftClass.super.sameMethod();  //Print the implementation method from that specific Left interface class
        RightClass.super.sameMethod();  //Print the implementation method from that specific Right interface class
    }

    public static void main(String[] args) {
        SolveAmbiguityProblemByCallingTheSpecificImplClass newobj = new SolveAmbiguityProblemByCallingTheSpecificImplClass();
        newobj.sameMethod();
    }
}