package com.ramesh.example.sampleprogram.supplierLambdaExample;

import java.util.Date;
import java.util.function.Supplier;
/*
    Supplier Interface is an opposite terminology of Consumer, meaning it will not take anything as an input type but will R return type. This interface contains
        an abstract method R get() that does not takes any input and return R type
            ~ R get();
        supplier does not contain any default and static method.
 */

//This example supply us a system date time
public class SupplierLambdaExample {

  public static void main(String[] args) {

      Supplier<Date> supplier = () -> new Date();   //Defining Supplier (does not take any input) that returns Date type.
    System.out.println("Current Date : " + supplier.get());
  }
}

//This example demonstrate how we can get random name of the string array every time it is called
class GetRandomName{

  public static void main(String[] args) {

      Supplier<String> supplier = () -> {             //Defining supplier that gets random number and return String i.e Name
          String [] names = {"Ram","Shyam","Hari","Dan"};
          int x = (int) (Math.random()*4);   //The logic here is Math.random() generates the value between 0 and 0.9999 max, so multiplying that by 4 will get us 0 to 3 after type casting int
          return names[x];   //and 0 to 3 is index for array names. perfect!
      };
    System.out.println("What name got printed : " + supplier.get());
  }
}

//This example demonstrate how supplier can be used in a case where we required OTP concept, digit only
class GenerateOneTimePassword {

  public static void main(String[] args) {

      Supplier<String> supplier = () -> {
          String OTP = "";   //Empty String to hold 6 digit random value;

          for(int i = 0; i< 6; i++) {
              OTP = OTP + (int)(Math.random() *10);   //Concatenating random generated int value to string OTP
          }
          return OTP;
      };

    System.out.println("One Time Password : " + supplier.get());
  }
}

/* This example generates a random password of length 8,
    Requirements:
       1) Must return random password of length 8
       2) position 1,3,5,7 must be Upper case alphabet or may contains special character @#$
       3) position 2,4,6,8 must be random digit
  */

class GenerateRandomPassword {

  public static void main(String[] args) {

    Supplier<String> supplier =
        () -> { // Defined a supplier which return String (password)
          String password = ""; // Initialize password string to hold a randomly generated password

          Supplier<Integer> digit =
              () -> { // Defined a supplier to randomly generate a digit
                return (int) (Math.random() * 10);
              };

          String characters =
              "ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$"; // characters contains all the alphabet and special
                                               // character allowed in the password,
          // based on the randomly generated index, character will be returned

          Supplier<Character> character =
              () -> { // Defined a supplier that returns character
                return characters.charAt((int) (Math.random() * 29));
              };

          for (int i = 1; i <= 8; i++) {
            if (i % 2 == 0) {
              password = password + digit.get();
            } else {
              password = password + character.get();
            }
          }
          return password;
        };
    System.out.println("Randomly generated password : " + supplier.get());
  }
}

