package edu.handong.csee.java.hw3;


/**

This class represents a calculator that can perform various computations using different engines.
It has a main method to run the program and a run method to execute the computations based on the input provided.
The computations available are: LCM, GCD, SQRT, FACTORIAL, FIBONACCI, MAX, MIN, CUBEVOL, and SPHEREVOL.
It takes a command line argument for the desired engine, and the input values for the computation.
*/

import edu.handong.csee.java.hw3.engines.Computable;
import edu.handong.csee.java.hw3.engines.CubeVolEngine;
import edu.handong.csee.java.hw3.engines.FactorialEngine;
import edu.handong.csee.java.hw3.engines.FibonacciEngine;
import edu.handong.csee.java.hw3.engines.GCDEngine;
import edu.handong.csee.java.hw3.engines.LCMEngine;
import edu.handong.csee.java.hw3.engines.MaxEngine;
import edu.handong.csee.java.hw3.engines.MinEngine;
import edu.handong.csee.java.hw3.engines.SQRTEngine;
import edu.handong.csee.java.hw3.engines.SphereVolEngine;
import edu.handong.csee.java.hw3.exception.InvalidCommandException;
import edu.handong.csee.java.hw3.exception.OneInputException;

public class Calculator {

/**
 * This is the main method which runs the calculator program.
 * It creates a Calculator object and calls the run method.
 * 
 * @param args the command line arguments, with the first argument being the engine option, and the rest being the input values.
 */

    public static void main(String[] args) {

        Calculator myCalculator = new Calculator();
        try {
            myCalculator.run(args);
        } catch (InvalidCommandException e) {
            System.out.println(e.getMessage());
        } catch (OneInputException e) {
            System.out.println(e.getMessage());
        }
    }

/**
 * This method executes the computation based on the input provided.
 * It first checks if there is any input provided, and prints an error message if there isn't.
 * It then identifies the engine option provided, creates the corresponding engine object, and calls the compute method.
 * Finally, it prints the result of the computation.
 * 
 * @param args the command line arguments, with the first argument being the engine option, and the rest being the input values.
 * @throws OneInputException
 */

    public void run(String[] args) throws InvalidCommandException, OneInputException{
        // try{
        if (args.length == 0) {
            throw new InvalidCommandException(" ");
        }
        // }
        // catch(Exception e){
        //     System.out.println(e.getMessage()); 
        // } 

        String engineName = args[0].toUpperCase();

        Computable engine =null;

        switch(engineName) {
            case "LCM":
                engine = new LCMEngine();
                break;
            case "GCD":
                engine = new GCDEngine();
                break;
            case "SQRT":
                engine = new SQRTEngine();
                break;
            case "FACTORIAL":
                engine = new FactorialEngine();
                break;
            case "FIBONACCI":
                engine = new FibonacciEngine();
                break;
            case "MAX":
                engine = new MaxEngine();
                break;
            case "MIN":
                engine = new MinEngine();
                break;
            case "CUBEVOL":
                engine = new CubeVolEngine();
                break;
            case "SPHEREVOL":
                engine = new SphereVolEngine();
                break;
            default:
                throw new InvalidCommandException(engineName);
         
        }
        if (args.length <= 1) {
            throw new InvalidCommandException(" ");

        }

        // engine.setInput(args);
        // engine.compute();
        String[] inputs = new String[args.length - 1];
        System.arraycopy(args, 1, inputs, 0, inputs.length);
        engine.setInput(inputs);
        engine.compute();

        System.out.println("The result of " +  engineName + " is " + engine.getResult() + ".");

    }


}
