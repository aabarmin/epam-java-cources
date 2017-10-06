package com.epam.university.java.core.task025;

import com.epam.university.java.core.utils.common.Validator;

/**
 * Class implements Task025.
 */
public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        Validator.validateNotNull(sourceMessage,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        int errorsCount = 0;
        for (int i = 0; i < sourceMessage.length(); i++) {
            int j = i + 3;
            if (j % 3 == 0 || j % 3 == 2) {
                if (!(sourceMessage.charAt(i) == 'S')) {
                    errorsCount++;
                }
            }
            if (j % 3 == 1) {
                if (!(sourceMessage.charAt(i) == 'O')) {
                    errorsCount++;
                }
            }
        }
        return errorsCount;
    }
}