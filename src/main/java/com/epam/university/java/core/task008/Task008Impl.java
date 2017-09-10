package com.epam.university.java.core.task008;

import java.util.EmptyStackException;
import java.util.Stack;

public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {
        char[] sourceArr = sourceString.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sourceArr.length; i++) {
            switch (sourceArr[i]){
                case '(' :
                case '[' :
                case '{' :
                    stack.push(sourceArr[i]);
                    break;
                case ')' :
                    try{
                        if(stack.pop() == '(')
                            break;
                        else{
                            return false;
                        }
                    }catch(EmptyStackException e){
                        return false;
                    }
                case ']' :
                    try{
                        if(stack.pop() == '[')
                            break;
                        else{
                            return false;
                        }
                    }catch(EmptyStackException e){
                        return false;
                    }
                case '}' :
                    try{
                        if(stack.pop() == '{')
                            break;
                        else{
                            return false;
                        }
                    }catch(EmptyStackException e){
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}
