package org.example;

/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 first_name last_name
 */
/*
Exercise 17 - Blood Alcohol Calculator
        Sometimes you have to perform a more complex calculation based on some provided inputs and then use that result to make a determination.

        Create a program that prompts for your weight, gender, total alcohol consumed (in ounces), and the amount of time since your last drink. Calculate your blood alcohol content (BAC) using this formula

        BAC = (A × 5.14 / W × r) − .015 × H
        where

        A is total alcohol consumed, in ounces (oz).
        W is body weight in pounds.
        r is the alcohol distribution ratio:
        0.73 for men
        0.66 for women
        H is number of hours since the last drink.
        Display whether or not it’s legal to drive by comparing the blood alcohol content to 0.08.

        Example Output
        Enter a 1 is you are male or a 2 if you are female: 1
        How many ounces of alcohol did you have? 3
        What is your weight, in pounds? 175
        How many hours has it been since your last drink? 1

        Your BAC is 0.049323
        It is legal for you to drive.


        Enter a 1 is you are male or a 2 if you are female: 1
        How many ounces of alcohol did you have? 5
        What is your weight, in pounds? 175
        How many hours has it been since your last drink? 1

        Your BAC is 0.092206
        It is not legal for you to drive.
        Constraint
        Prevent the user from entering non-numeric values.
*/
import java.util.Scanner;

public class App {



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        double your_last_drink;
        int the_gender;
        double num_of_ounces;
        double num_of_pounds;

        System.out.println("Enter a 1 is you are male or a 2 if you are female: ");
        the_gender = 0;
        while(the_gender != 1 && the_gender != 2)
        {
            the_gender = input.nextInt();
        }

        System.out.println("How many ounces of alcohol did you have?  ");
        num_of_ounces = input.nextDouble();

        System.out.println("What is your weight, in pounds? ");
        num_of_pounds = input.nextDouble();

        System.out.println("How many hours has it been since your last drink? ");
        your_last_drink = input.nextDouble();

        final  double MALE = 0.73;
        final  double WOMAN = 0.66;

        if(the_gender == 1) {
            double malebac = (num_of_ounces * 5.14 / num_of_pounds * MALE) - (.015 * your_last_drink);
            System.out.printf("Your BAC is %f\n", malebac);

            String reading = (malebac < 0.08) ? "It is legal for you to drive" : "It is not legal for you to drive";
            System.out.println(reading);
        }
        else if(the_gender == 2){
            double femalebac = ((num_of_ounces * 5.14)/ (num_of_pounds * WOMAN)) - (.015 * your_last_drink);

            System.out.printf("Your BAC is %f", femalebac);


            String the_output = femalebac<.08 ? "It is legal for you to drive." : "It is not legal for you to drive.";
            System.out.print(the_output);
        }
        else {
            System.out.println("This is a input not valid for \"female\" or \"male\"");
        }
    }
}
