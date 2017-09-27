package com.epam.university.java.core.task008;

import com.epam.university.java.core.task003.NullChecker;
import com.epam.university.java.core.task003.SimpleNullChecker;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by ilya on 09.09.17.
 */
public class Task008Impl implements Task008 {

    NullChecker checker = new SimpleNullChecker();

    @Override
    public boolean isValid(String sourceString) {
        checker.check(sourceString);

        Map<Character, Character> target = new HashMap<>();
        target.put('(', ')');
        target.put('[', ']');
        target.put('{', '}');

        // I readed that Stack isn't good for use,
        // because it inhereted from Vector.
        // And I used Deque, but like Stack
        Deque<Character> stack = new LinkedList<>();

        char[] sequence = sourceString.toCharArray();

        for (char symbol : sequence) {
            if (target.containsKey(symbol)) {
                stack.push(symbol);
            } else if (target.containsValue(symbol)) {
                if (!stack.isEmpty() && target.get(stack.peek()).equals(symbol)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
