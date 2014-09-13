package com.sample.calculatorapp;

/**
 * Created by BFineRocks on 9/12/14.
 */
import java.util.Scanner;
import java.util.ArrayList;


/**
 * This Calculator App will take in user input and perform the requested operations.
 * The user will input the operation (addition, subtraction, multiplication, division, or square root)
 * they would like to perform, then 1 or 2 digits and the app will output the answer.
 * After displaying the answer, the app will then ask the user if they would like to perform another operation. If so,
 * the app will begin again. If not, it will stop. It will include error handling for bad input using a method.
 */

public class CalculatorApp {
    static public void main(String[] args){
        String add, subtract, multiply, divide, welcome, requestForOperation, options, requestForDigits;
        Scanner userInput;

        welcome = "Welcome to the AutoCalc 3000 Bfinity Edition.";
        requestForOperation = "Please select your requested operation by typing the choice in below.";
        options = "Add, Subtract, Multiply, Divide, Square Root";
        requestForDigits = "Please enter digits you are calculating. (You must enter at least one)";



    }


    public int checkUserRequest (String inputToCheck)
    {
        ArrayList<String> posOperations;
        boolean operationListed;
        String checkOperation, opListed;
        int selection;

        posOperations = new ArrayList<String>();
        operationListed = false;
        checkOperation = inputToCheck;
        selection = 0;

        posOperations.add("add");
        posOperations.add("subtract");
        posOperations.add("multiply");
        posOperations.add("divide");
        posOperations.add("square root");

        while(!operationListed)
        {
            for(int i = 0; i < posOperations.size(); i++)
            {
                opListed = posOperations.get(i);
                if(checkOperation.contains(opListed))
                {
                    selection = i + 1;
                    operationListed = true;
                }
            }
            System.out.println("Selection not found. Please try again.");
        }
        return selection;
    }

    public int checkUserDigits (int digitsToCheck)
    {

    }
}










