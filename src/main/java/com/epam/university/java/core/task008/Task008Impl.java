package com.epam.university.java.core.task008;

import com.epam.university.java.core.util.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the Strings and braces task.
 */
public class Task008Impl implements Task008 {

    private static Map<Character, Character> braces;

    static {
        braces = new HashMap<>();
        braces.put('{', '}');
        braces.put('[', ']');
        braces.put('(', ')');
    }

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
     * @throws IllegalArgumentException if source string is null
     */
    @Override
    public boolean isValid(String sourceString) throws IllegalArgumentException {
        Utils.assertNonNull(sourceString);
        Stack<Character> stack = new Stack<>();
        for (char c : sourceString.toCharArray()) {
            if (braces.containsKey(c)) {
                stack.push(c);
            } else if (braces.containsValue(c) && c != braces.get(stack.pop())) {
                return false;
            }
        }
        return true;
    }

}
