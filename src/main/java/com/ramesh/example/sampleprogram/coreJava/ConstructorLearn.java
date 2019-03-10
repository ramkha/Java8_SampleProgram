package com.ramesh.example.sampleprogram.coreJava;

/*
# Class contains following 5 elements

1. Variables    -->  1.a) Local variables :-
                        => The scope of the local variables are within the block or method.

                     1.b) Instance variables :-
                        => The scope of the Instance variables are through out the application, means instance variable can be accessible throughout the application

                     1.c) Static variables :-
                        =>

2. Methods      -->  2.a) Instance Methods() :
                              ~ Instance method memories are allocated during object creation Time
                              ~

                     2.b) Static Methods()   =>

3. Constructors -->  3.1) Types of Constructor :-
                           => 3.1.a) Default Constructor
                                => ~ provided by the compiler if no constructor is provided, if any user provided constructor is provided,
                                     then compiler is not responsible for creating the default(0-args) constructor.
                                   ~ default constructor by default will have 0-args
                                   ~ No implementation by default on default constructors

                              3.1.b) User-Provided Constructor
                                => ~ provided by the user
                                   ~ Based on the requirements can be zero-args constructors or parametrized constructors

                     3.2) Advantages of Constructors
                        => 3.2.a) Since constructors are called during object creation, the implementation or logic inside the
                                  constructor gets executed during the object creation itself. so if we want to perform any operation during object
                                  creation itself, then the constructor is very useful. however this is just the basic usage only (around 25% advantage of using constructor)

                           3.2.b) Constructors are used to initialize the Instance variables during object creation.
                                  ~ Possible problem with this is, if Using default constructor(0-args) and logic implemented inside will be same each time the object is being created.
                                    this is a problem, when you are initializing the variables using default constructor, and variables value are hardcoded. every time the object for that class
                                    is being created, the variables will hold the same value.
                                  ~ To overcome this problem, the user-provided constructor (parametrized) should be used.

                               Note :- Conversion process of local variable to instance variable :-
                                    => During object creation, Using parametrized constructor we initialize the instance variables of the class,
                                        Here, when the arguments are passed to the constructor the variables declared in the constructor are local variables
                                         meaning, the scope of the variables are within the constructor method only. Then how do we convert the instance variables
                                           values provided in the constructor, assigned to the local variables.
                                           Answer is using 'this' keyword. In java this keyword represents the instance variable.
                                           so for example if
                                                int empId is local variable
                                            and int empId is instance variable, same variable name, then
                                            to differentiate, this keyword is used, this.empId refers to the instance variable empId

                     3.3) Calling constructor within the constructor
                         => if class contains multiple constructor, then within the same class from constructor, using 'this()' keyword, other constructor
                             class can be called and executed, but this() must be a first statement of the constructor, or else exception will be thrown.
                                but, what if there are two this() inside the constructor ? can we call two constructor from the constructor?
                                 => No only one constructor can be called from the constructor.





4. Instance Blocks

5. Statics Blocks


# How many formats are there for object creation?
=> There are two formats (coding pattern) for creating object
   1) Named object creation format :-
     example for class Test,
             Test t = new Test();

   2) Nameless object creation format :-
     example for class Test,
              new Test();


# In how many ways the object can be created/instantiated
    => In many ways, but some of the well known approaches in JAVA for object creation are :-

1. Using NEW keyword :
            => example,  Test t = new Test();
                Here,  Test  --> class name
                       t     --> reference variable ( reference to the object) or name of the object
                       =     --> assignment operator
                       new   --> keyword to create the object ( allocates the memory required for the object in the HEAP MEMORY )
                     Test()  --> Constructor (known as Default constructor for the class // zero parameter constructor)

2. Using INSTANCE FACTORY METHODS
3. Using STATIC FACTORY METHODS
4. Using PATTERN FACTORY METHODS
5. Using newInstance() method
6. Using clone() method
7. Using DESERIALIZATION process
*/

public class ConstructorLearn {
}
