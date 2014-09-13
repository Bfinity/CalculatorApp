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

//Calculator Main Method. This runs the calculator program. It operates on a loop, until the user exits the program.
public class CalculatorApp {
    static public void main(String[] args) {
        String welcome, requestForOperation, options, operationEntered;
        double calcAnswer;
        int selectionHolder;
        Scanner userInput;

        welcome = "Welcome to the AutoCalc 3000 Bfinity Edition.";
        requestForOperation = "Please select your requested operation by typing the choice in below.";
        options = "Add, Subtract, Multiply, Divide, Square Root";


    }

/**
 * This method checks if the user inputted an operation that the calculator can complete. It uses an arraylist that
 * lists all the possible operations, then using a for loop and contains method checks the operation entered. This
 * returns an int representation of the selection if found. If not found it loops to request a new entry.
 * @param inputToCheck a string from main method, requested operation
 * @return int representation of operation
 */

    public int checkUserRequest(String inputToCheck) {
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

        while (!operationListed) {
            for (int i = 0; i < posOperations.size(); i++) {
                opListed = posOperations.get(i);
                if (checkOperation.contains(opListed)) {
                    selection = i + 1;
                    operationListed = true;
                }
            }
            System.out.println("Selection not found. Please try again.");
        }
        System.out.println("You have chosen to " + posOperations.get(selection-1).toString());
        return selection;
    }

    /**
     * This method checks if the user entered doubles that can be calculated. It uses a Scanner and the hasNextDouble
     * method. If a double is not entered it requests a new entry in a loop. It returns the double.
     * @return double
     */


    public double checkUserDigits() {
        Scanner numbersIn;
        String requestForDigits;
        double numberToCompute;
        boolean numberOkay;

        numberOkay = false;
        numbersIn = new Scanner(System.in);
        numberToCompute = 0;

        requestForDigits = "Please enter digit you are calculating.";
        while (!numberOkay) {
            System.out.println(requestForDigits);
            if (numbersIn.hasNextDouble()) {
                numberToCompute = numbersIn.nextDouble();
                numberOkay = true;
            }
            else
            {
                System.out.println("You did not enter a number. Please try again.");
            }
        }
        System.out.println("Number Entered: " + numberToCompute);
        return numberToCompute;
    }

    /**
     * This method completes the calculation selected. It uses a switch and defaults if a calculation can not be completed.
     * @param opSelection the selected operation to complete.
     * @param firstEntry the first double entered.
     * @param secondEntry the second double entered (if entered).
     * @return answer of calculation
     */

    public double calculationMaster (int opSelection, double firstEntry, double secondEntry)
    {
        double answer;
        answer = 0;

        switch(opSelection){
            case 1:
                answer = firstEntry + secondEntry;

            case 2:
                answer = firstEntry - secondEntry;

            case 3:
                answer = firstEntry * secondEntry;

            case 4:
                answer = firstEntry / secondEntry;

            case 5:
                answer = Math.sqrt(firstEntry);

            default:
                System.out.println("Ooops. There appears to be a computation error. Please contact someone. Anyone. Hurry!");
        }
        return answer;


    }

}










