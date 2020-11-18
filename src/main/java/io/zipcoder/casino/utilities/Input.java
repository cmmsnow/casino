package io.zipcoder.casino.utilities;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Input {
    public static Scanner scan = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        String userInput;
        System.out.print(prompt);
        if (scan.hasNextLine()){
           userInput = scan.next();
        } else {
            userInput = getStringInput("Incorrect input, try again:  ");
        }
        return userInput;
    }

    public static Integer getIntInput(String prompt) {

        System.out.print(prompt);
        Integer userInput = scan.nextInt();
        return userInput;
    }

    public static Double getDoubleInput(String prompt) {
        Double userInput;
        System.out.print(prompt);
        if(scan.hasNextDouble()){
            userInput = scan.nextDouble();
        }
        else{
            userInput = getDoubleInput("Incorrect input, try again:  ");
        }
        return userInput;
    }
}
