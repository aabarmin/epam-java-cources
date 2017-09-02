package com.epam.university.java.core.task001;

/**
 * Created by ilya on 02.09.17.
 */
public class Task001Impl implements Task001 {
    private final Checker checker;
    private final Tokenizer tokenizer;
    private final Parser parser;

    public Task001Impl() {
        checker = new ArgumentChecker();
        tokenizer = new NumberTokenizer();
        parser = new SimpleDoubleParser();
    }

    private double[] getArguments(String firstNumber, String secondNumber){
        double[] arguments = new double[2];
        arguments[0] = makeDoubleArgument(firstNumber);
        arguments[1] = makeDoubleArgument(secondNumber);
        return arguments;
    }

    private double makeDoubleArgument(String number){
        checker.check(number);
        number = tokenizer.tokenize(number);
        return parser.parse(number);
    }

    @Override
    public double addition(String firstNumber, String secondNumber) {
        double arguments[] = getArguments(firstNumber,secondNumber);
        return arguments[0]+arguments[1];
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        double arguments[] = getArguments(firstNumber,secondNumber);
        return arguments[0]-arguments[1];
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        double arguments[] = getArguments(firstNumber,secondNumber);
        return arguments[0]*arguments[1];
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        double arguments[] = getArguments(firstNumber,secondNumber);
        return arguments[0]/arguments[1];
    }



}
