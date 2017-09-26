package com.epam.university.java.core.task008;

import java.util.HashMap;
import java.util.Map;

public class Task008Impl implements Task008 {
    /**
     * Given a string with mathematical expression like "(1 + 2) * {[-3] - 4}". You need to check,
     * are all braces correct. Ex:
     * <p>
     *     "(1 + 2) * {[-3] - 4}" - correct
     *     "(1 + [2) + 3 - 4]" - incorrect
     *     In expression can be used the following kinds of braces: {}, (), [].
     *     Tip: it's better to implement stack structure.
     *     Tip: You also can use Stack class but it's not recommended.
     * </p>
     *
     * @param sourceString string to check
     * @return is braces valid or source string is empty
     */
    @Override
    public boolean isValid(String sourceString) {

        if (sourceString == null) {
            throw new IllegalArgumentException();
        }

        Map<Character, Character> braceMapping = new HashMap<>();
        braceMapping.put('{', '}');
        braceMapping.put('(', ')');
        braceMapping.put('[', ']');

        Stack<Character> stack = new StackImpl<>();

        for (char c : sourceString.toCharArray()) {

            if (braceMapping.containsKey(c)) {
                stack.push(c);
            } else if (braceMapping.containsValue(c)) {
                if (stack.size() == 0) {
                    return false;
                } else if (c != braceMapping.get(stack.pop())) {
                    return false;
                }
            }

        }


        return stack.size() == 0;

    }
}
