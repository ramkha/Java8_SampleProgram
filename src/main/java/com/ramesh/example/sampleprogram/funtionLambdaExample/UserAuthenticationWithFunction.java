package com.ramesh.example.sampleprogram.funtionLambdaExample;
import java.util.Scanner;
import java.util.function.Function;
/*
For this example requirements are
        user can provide anything, but our application accepts only first 6 character from the input and should be "ramesh";
        User must provide Java as a password, anything else will fail
 */

//POJO class for User
class User {
    String userName;
    String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}

public class UserAuthenticationWithFunction {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter UserName : ");
        String userName = scanner.next();
        System.out.println();
        System.out.print("Enter Password : ");
        String password = scanner.next();

        Function<String, String> lowerCaseFunction = s -> s.toLowerCase(); //convert provided string to the lowercase

        Function<String, String> considerFirstSix = s -> s.substring(0,6); //consider only first 6 char from the string

        if(lowerCaseFunction.andThen(considerFirstSix).apply(userName).equals("ramesh") && password.equals("Java")){
            System.out.println("Valid User");
        }else{
            System.out.println("Invalid User");
        }

    }
}
