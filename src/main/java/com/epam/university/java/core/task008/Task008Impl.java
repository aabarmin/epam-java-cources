package com.epam.university.java.core.task008;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {
        List<String> samplesOfBraces = new ArrayList<>(Arrays.asList("{", "}", "(", ")", "[", "]"));
        List<String> pullOfBraces =Arrays.stream(sourceString.split("")).
                filter((n)->samplesOfBraces.contains(n)).
                collect(Collectors.toList());
        Stack<String> stack = new Stack<>();
        for (String current:pullOfBraces){
            if (current.equals("[") || current.equals("(") || current.equals("{")){
                stack.push(current);
                continue;
            }
            if (stack.empty()){
                return false;
            }
            if (current.equals(")") && !stack.peek().equals("(")
                    ||(current.equals("}") && !stack.peek().equals("{")
                    ||current.equals("]") && !stack.peek().equals("["))){
                return false;
            }
            else stack.pop();
        }
        if (stack.empty()) return true;
        else return false;
    }
}
