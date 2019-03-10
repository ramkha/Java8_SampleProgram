package com.ramesh.example.sampleprogram.predicateLambdaExample;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;

 //Traditional way to handle boolean results
public class PredicateExample {

    //some method that takes one input type and return boolean [True/False]
    public boolean checkNumber(int i) {
        if (i < 5) {
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        PredicateExample newObj = new PredicateExample();
        boolean ans = newObj.checkNumber(5);
        System.out.println(ans);
    }
}



//Using Predicate Interface and Lambda to check Integer value
class PredicateWithIntegerTypeLambdaBooleanExample {

    public static void main(String[] args) {

          /*
        With java 1.8, predefined functional interfaces like predicate interface is present which contains an abstract method test()
        which takes an input, perform check and return boolean value. Since its already
        available to us, we don't need to create our own method to serve this purpose.
        Use predicate when there is a need of conditional checking. and serves the following purpose
         1.Use when your have to perform some conditional operation
         2. Predicate takes any Type and abstract method test() also takes only one input parameter
         3. Predicated always returns boolean value.
        */
        Predicate<Integer> ans = i -> i<5 ; //more simplified, if return value is boolean, then lambda is smart enough to return value based on the result.
                /*(i) -> {
            if (i < 5) {
                return true;
            } else
                return false;
        };*/
        System.out.println(ans.test(3));  //prints True
        System.out.println(ans.test(10));  //prints False
        }
}

//Using Predicate Interface and Lambda to check String value
class PredicateWithStringTypeLambdaBooleanExample {

    public static void main(String[] args) {

           /*
        With java 1.8, predicate interface is present which contains an abstract method test() which takes an input, perform check and return boolean value. Since its already
        available to us, we don't need to create our own method to serve this purpose.
        Use predicate when there is a need of conditional checking. and serves the following purpose
         1.Use when your have to perform some conditional operation
         2. Predicate takes any Type and abstract method test() also takes only one input parameter
         3. Predicated always returns boolean value.
        */
        Predicate<String> ans = s -> s.length() > 5 ; //more simplified, if return value is boolean, then lambda is smart enough to return value based on the result.
                /*(i) -> {
            if (i > 5) {
                return true;
            } else
                return false;
        };*/
        System.out.println("Length of Ramesh > 5 : "+ans.test("Ramesh"));  //prints True
        System.out.println("Length of Ram > 5 : " + ans.test("Ram"));  //prints False
    }
}

//Using Predicate Interface and Lambda to check Collection
class PredicateWithCollectionTypeLambdaBooleanExample {

    public static void main(String[] args) {
        /*
        With java 1.8, predicate interface is present which contains an abstract method test() which takes an input, perform check and return boolean value. Since its already
        available to us, we don't need to create our own method to serve this purpose.
        Use predicate when there is a need of conditional checking. and serves the following purpose
         1.Use when your have to perform some conditional operation
         2. Predicate takes any Type and abstract method test() also takes only one input parameter
         3. Predicated always returns boolean value.
        */
        Predicate<Collection> ans = s -> s.isEmpty() ; //more simplified, if return value is boolean, then lambda is smart enough to return value based on the result./

        ArrayList notEmpty = new ArrayList();
        notEmpty.add("anything");

        ArrayList empty = new ArrayList();

        System.out.println("Check of s is empty with value added on it : " + ans.test(notEmpty));  //prints False

        System.out.println("Check of s is empty with no value on it : " + ans.test(empty));  //prints False
    }
}


/*
 Predicate Joining , checking multiple condition and joining those predicate
 For Example we have, predicate P_1 = > Checks if the given number is greater than 10 ?
                      predicate P_2 => Checks if the given number is Even number or not ?

      Possible Required operation that we want to perform on predicate P_1 and P_2
      1. What if on P_1 we want to get the reverse result, i.e if given number is smaller than 10>
         => P_1.negate() , using this method available inside the Predicate interface, we can get the reverse result.
      2. what if we want the result based on the combined result of predicate P_1 and P_2 i.e , we want a number which greater than 10 and also a even number?
         => P_1.and(P_2) , using this we can get the combined result
      3. What if we want to get either one result from P_1 and P_2,
         => P_1.or(p_2) , using this method available inside the Predicate interface, we can get the either result that match the condition

    methods negate(), and(), or() are the defaults method inside the Predicate interface.
  */

class PredicateJoining {

    public static void main(String[] args) {

        int [] x = {0,5,10,15,20,25,30};   //array of int initialization

        Predicate<Integer> p1 = i -> i > 10 ; // predicate that checks if the given integer i is greater than 10 ?

        Predicate<Integer> p2 = i -> i % 2 == 0; // predicate that checks if the give input integer i is even ?

        System.out.println("The numbers greater than 10 : ");
        method(p1,x);

        System.out.println("The even numbers : ");
        method(p2,x);

        //Default method example
        System.out.println("The numbers NOT greater than 10 : ");
        method(p1.negate(),x);   //using negate() to get the reverse results

        System.out.println("The numbers greater than 10 AND even number : ");
        method(p1.and(p2),x);

        System.out.println("The numbers greater than 10 OR even number : ");
        method(p1.or(p2),x);
    }

    public static void method(Predicate<Integer> p, int[] values){

        for(int value : values) {   // iterating over the values that is passed
            if (p.test(value)) {     //calling the Predicate interface method test() and if anny values come then print
                System.out.println(value);
            }
        }
    }
}

//Examples to have more hands on the Predicate
// Program to display names starts with some letters -- lets write it
class PredicateMoreExample {

    public static void main(String[] args) {

        String [] names = {"Harry","Henry","hising", "Kate","kevin", "Steven", "Bryan","bijay", "Hina"};  //Initialze the string arrays with names

        Predicate<String> namesWithH = s -> s.charAt(0) == 'H';  // gets the string and gets the first index and check if its equal to char 'h'

        Predicate<String> namesWithB = s -> s.startsWith("B");   // gets the string and checck if the string starts with B

        Predicate<String> namesWithKork = s -> s.toLowerCase().startsWith("k"); // gets the string starting with k regardless of caps or not

        System.out.println("Names that starts with character 'H' : ");
        checkMetohd(namesWithH, names);

        System.out.println("Names that starts with 'B' : ");
        checkMetohd(namesWithB, names);

        System.out.println("Names that does not start with 'B'");
        checkMetohd(namesWithB.negate(),names);

        System.out.println("Names that start with 'k' or 'K'");
        checkMetohd(namesWithKork, names);

    }

    public static void checkMetohd(Predicate<String> p , String[] strings ){
        for(String value : strings) {
            if(p.test(value)){
                System.out.println(value);
            }
        }
    }
}

//Program to remove null values and empty strings from the exiting list
//This is useful because if null and
class PredicateRemoveNullAndEmpty {

    public static void main(String[] args) {

        String[] stringsList = {"anthing", null, "Nand", "Ram", "Hari", "", null , "" };  // This arraylist will give us a null pointer exception if proceed without filtering out the null and empty

       Predicate<String> removeNullandEmpty = s -> s != null && s.length() != 0; //This check if the string with length 0 and null

       //Predicate<String> easyWayToRemoveNullAndEmpty = s -> !StringUtils.isEmpty(s); //This checks if the string is null or empty

        ArrayList<String> filterdStrings = new ArrayList<String >();

        for (String value: stringsList){
            if(removeNullandEmpty.test(value)){
                filterdStrings.add(value);
            }
        }

      /*  for (String value: stringsList){
            if(easyWayToRemoveNullAndEmpty.test(value)){
                filterdStrings.add(value);
            }
        }*/

        System.out.println("Valid strings are : " + filterdStrings);
    }
}


//Example program to authenticate user using predicate
class User {

    String name;
    String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public static void main(String[] args) {

        //("Ramesh").equals(user.name) this avoids NULL pointer exception !! whereas user.password.equals("Nepal") throws null pointer exception
        Predicate<User> checkUserNameAndPassword = user -> ("Ramesh").equals(user.name) &&  user.password.equals("Nepal"); //This will do strict checking of upper and lower case

      // Predicate<User> chechUserAndpass = user -> user.name.equalsIgnoreCase("Ramesh") && user.password.equalsIgnoreCase("Nepal"); //this wiil ignore the upper and lower case and hence authentication will pass

        User user1 = new User(null, "Nepal");

     //   User user2 = new User("ramesh","nepal");

        if(checkUserNameAndPassword.test(user1)) {
            System.out.println("Authentication Passed for user1!" );
        }else
            System.out.println("Authentication Failed for user1!");

   /*  if(chechUserAndpass.test(user2)) {
        System.out.println("Authentication Passed for user2!");
    }else
            System.out.println("Authentication Failed for user2!")*/;
}
}


//Program to check whether SoftwareEngineer is allowed into pub or not by using Predicate?
class SoftwareEngineer {
    String name;
    int age;
    boolean isHavingGf;

    SoftwareEngineer(String name,int age,boolean isHavingGf)
    {
        this.name=name;
        this.age=age;
        this.isHavingGf=isHavingGf;
    }

    public String toString()
    {
        return name;
    }
}

    class Test {
    public static void main(String[] args){
        SoftwareEngineer[] list = {
                new SoftwareEngineer("harry",60,false),
                new SoftwareEngineer("rick",25,true),
                new SoftwareEngineer("dick",26,true),
                new SoftwareEngineer("jay",28,false),
                new SoftwareEngineer("manu",17,true)
        };

          Predicate<SoftwareEngineer> allowed= se -> se.age>= 18 && se.isHavingGf;   // condition satisfied is age over 18 and should have gf

          System.out.println("The Allowed Members into Pub are:");
          for(SoftwareEngineer se : list) {
              if (allowed.test(se)) {
                  System.out.println(se);
              }
          }
        }
    }
