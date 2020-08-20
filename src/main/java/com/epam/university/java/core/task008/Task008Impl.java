package com.epam.university.java.core.task008;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Romin Nuro on 20.08.2020 23:54.
 */
public class Task008Impl implements Task008 {
    /**
     * Given a string with mathematical expression like "(1 + 2) * {[-3] - 4}". You need to check,
     * are all braces correct. Ex:
     * <p>
     * "(1 + 2) * {[-3] - 4}" - correct
     * "(1 + [2) + 3 - 4]" - incorrect
     * In expression can be used the following kinds of braces: {}, (), [].
     * Tip: it's better to implement stack structure.
     * Tip: You also can use Stack class but it's not recommended.
     * </p>
     *
     * @param sourceString string to check
     * @return is braces valid or source string is empty
     */
    private static final List<String> OPEN_BRACES = List.of("(", "[", "{");
    private static final List<String> CLOSE_BRACES = List.of(")", "]", "}");

    @Override
    public boolean isValid(String sourceString) {

        Deque<String> stack = new ArrayDeque<>();
        String regex = "[\\[\\]{}()]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sourceString);

        while (matcher.find()) {
            String brace = sourceString.substring(matcher.start(), matcher.end());
            if (isOpen(brace)) {
                stack.push(brace);
                continue;
            }
            if (stack.isEmpty()
                    || !braceMatch(brace, stack.peek())) {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }

    private boolean isOpen(String brace) {
        return OPEN_BRACES.contains(brace);
    }

    private boolean braceMatch(String close, String open) {
        return CLOSE_BRACES.indexOf(close) == OPEN_BRACES.indexOf(open);
    }
}
