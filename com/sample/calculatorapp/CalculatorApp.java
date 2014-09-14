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
        String welcome, requestForOperation, operationEntered, yourAnswer, goAgain;
        double calcAnswer, firstNumber, secondNumber;
        int selectionHolder;
        boolean stillWorking;
        Scanner userInput;

        welcome = "Welcome to the AutoCalc 3000 Bfinity Edition.";

        yourAnswer = "The answer to the calculation is: ";
        goAgain = "Do you have more calculations for me? Please enter Y for yes or N for no.";
        userInput = new Scanner(System.in);
        stillWorking = true;
        secondNumber = 0;


        System.out.println(welcome);

        while(stillWorking){
            System.out.println(requestForOperation);
            operationEntered = userInput.nextLine();
            selectionHolder = CalculatorApp.checkUserRequest(operationEntered);

            if (selectionHolder < 5)
            {
                firstNumber = CalculatorApp.checkUserDigits();
                secondNumber = CalculatorApp.checkUserDigits();
            }
            else
            {
                firstNumber = CalculatorApp.checkUserDigits();
            }

            calcAnswer = CalculatorApp.calculationMaster(selectionHolder, firstNumber, secondNumber);

            System.out.println(yourAnswer + calcAnswer);
            System.out.println(goAgain);

            if(!userInput.nextLine().contains("y") || !userInput.nextLine().contains("Y"))
            {
                stillWorking = false;
            }
            else
            {
                stillWorking = true;
            }
        }


    }

/**
 * This method checks if the user inputted an operation that the calculator can complete. It uses an arraylist that
 * lists all the possible operations, then using a for loop and contains method checks the operation entered. This
 * returns an int representation of the selection if found. If not found it loops to request a new entry.
 * @return int representation of operation
 */

    public static int checkUserRequest()
    {
        ArrayList<String> posOperations;
        boolean operationListed;
        String requestForOperation, checkOperation, opListed;
        int selection;
        Scanner userOpInput;

        posOperations = new ArrayList<String>();
        operationListed = false;
        selection = 0;
        userOpInput = new Scanner(System.in);
        checkOperation = "";
        requestForOperation = "Please select your requested operation by typing the choice in below. \n " +
                "Add, Subtract, Multiply, Divide, Square Root";
        posOperations.add("add");
        posOperations.add("subtract");
        posOperations.add("multiply");
        posOperations.add("divide");
        posOperations.add("square root");

        while (!operationListed)
        {
            System.out.println(requestForOperation);
            if(userOpInput.hasNextLine()) {
                checkOperation = userOpInput.nextLine();
                for (int i = 0; i < posOperations.size(); i++) {
                    opListed = posOperations.get(i);
                    if (checkOperation.equalsIgnoreCase(opListed)) {
                        selection = i + 1;
                        operationListed = true;
                        i = 6;
                    } else {
                        System.out.println("Selection not found. Please try again.");
                    }

                }
            }
            else
            {
                System.out.println("I need more information to continue.");
            }
            System.out.println("You have chosen to " + posOperations.get(selection - 1).toString());

        }
        return selection;
    }

    /**
     * This method checks if the user entered doubles that can be calculated. It uses a Scanner and the hasNextDouble
     * method. If a double is not entered it requests a new entry in a loop. It returns the double.
     * @return double
     */


    public static double checkUserDigits()
    {
        Scanner numbersIn;
        String requestForDigits;
        double numberToCompute;
        boolean numberOkay;

        numberOkay = false;
        numbersIn = new Scanner(System.in);
        numberToCompute = 0;

        requestForDigits = "Please enter digit you are calculating.";
        while (!numberOkay)
        {
            System.out.println(requestForDigits);
            if (numbersIn.hasNextDouble())
            {
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

    public static double calculationMaster (int opSelection, double firstEntry, double secondEntry)
    {
        double answer;
        answer = 0;

        switch(opSelection)
        {
            case 1:
                answer = firstEntry + secondEntry;
                break;

            case 2:
                answer = firstEntry - secondEntry;
                break;

            case 3:
                answer = firstEntry * secondEntry;
                break;

            case 4:
                answer = firstEntry / secondEntry;
                break;

            case 5:
                answer = Math.sqrt(firstEntry);
                break;

            default:
                System.out.println("Ooops. There appears to be a computation error. Please contact someone. Anyone. Hurry!");
                break;
        }
        return answer;


    }

}










