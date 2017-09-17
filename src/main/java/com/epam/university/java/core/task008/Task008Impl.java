package com.epam.university.java.core.task008;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Dremina on 16.09.2017.
 */
public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {

        Deque<Character> stack =  new ArrayDeque<Character>();
        for (char c : sourceString.toCharArray()) {
            switch (c){
                case '(' :
                case '{' :
                case '[' :
                    stack.addLast(c); break;
                case ')' :
                    if (stack.isEmpty() || !stack.removeLast().equals('(')){
                        return false;
                    }
                    break;
                case '}' :
                    if (stack.isEmpty() || !stack.removeLast().equals('{')){
                        return false;

                    }
                    break;
                case ']' :
                    if (stack.isEmpty() || !stack.removeLast().equals('[')){
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }
}
