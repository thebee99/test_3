package edu.handong.csee.java.hw3;

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
import edu.handong.csee.java.hw3.exceptions.InvalidCommandException;
import edu.handong.csee.java.hw3.exceptions.OneInputException;

public class Calculator {

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

    public void run(String[] args) throws InvalidCommandException, OneInputException {
        if (args.length == 0) {
            throw new InvalidCommandException(" ");
        }

        String engineName = args[0].toUpperCase();

        Computable engine = null;

        switch (engineName) {
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

        String[] inputs = new String[args.length - 1];
        System.arraycopy(args, 1, inputs, 0, inputs.length);
        engine.setInput(inputs);
        engine.compute();

        System.out.println("The result of " + engineName + " is " + engine.getResult() + ".");
    }
}
