package com.epam.university.java.core.task027;

import com.epam.university.java.core.utils.common.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class implements Task027.
 */
public class Task027Impl implements Task027 {
    private int maxDigitsNumber;
    private List<Integer> extractedList = new ArrayList<>();

    /**
     * Extract the growing numbers in the right order from the string with
     * the length more than 1.
     *
     * @param sourceString  source string with numbers
     * @param startPosition starting position of the current
     *                      extraction
     * @param digitNumber   digit number of the current extraction
     * @throws IllegalArgumentException if <code>sourceString</code> is null or
     *                                  if at least one of the <code>int</code>
     *                                  parameters is negative
     */
    private void extractRecursion(String sourceString, int startPosition, int
            digitNumber) {
        Validator.validateNotNull(sourceString,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Validator.validateNotNegative(startPosition, digitNumber,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NEGATIVE,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NEGATIVE);
        extractedList.add(Integer.parseInt(sourceString.substring(startPosition,
                startPosition + digitNumber)));
        int upperLimit;
        if (digitNumber == 1) {
            upperLimit = sourceString.length() - 1;
        } else {
            upperLimit = sourceString.length() - digitNumber - 1;
        }
        if (startPosition >= upperLimit) {
            extractedList = new ArrayList<>();
        } else {
            for (int i = startPosition; i < upperLimit; i += digitNumber) {
                if (Integer.parseInt(sourceString.substring(startPosition,
                        startPosition + 1)) == 0) {
                    extractedList = new ArrayList<>();
                    break;
                }
                int currentNumberToCheckFirst = Integer.parseInt(sourceString
                        .substring(i, i + digitNumber));
                int currentNumberToCheckSecond = Integer.parseInt(sourceString
                        .substring(i + digitNumber, i + 2 * digitNumber));
                if (currentNumberToCheckSecond - currentNumberToCheckFirst == 1) {
                    extractedList.add(currentNumberToCheckSecond);
                } else {
                    if (digitNumber == maxDigitsNumber) {
                        extractedList = new ArrayList<>();
                        break;
                    }
                    if (sourceString.length() < i + 2 * digitNumber + 1) {
                        extractedList = new ArrayList<>();
                        break;
                    }
                    if (Integer.parseInt(sourceString.substring(i + digitNumber,
                            i + 2 * digitNumber + 1))
                            - currentNumberToCheckFirst == 1) {
                        extractRecursion(sourceString, i
                                + digitNumber, digitNumber + 1);
                    } else {
                        extractedList = new ArrayList<>();
                        extractRecursion(sourceString, 0,
                                digitNumber + 1);
                    }
                    break;
                }
            }
        }
    }

    /**
     * Get max possible digit number from the given string.
     *
     * @param sourceString source string with numbers
     * @return <code>int</code> max digit number
     * @throws IllegalArgumentException if parameter is null
     */
    public int getMaxDigitNumber(String sourceString) {
        Validator.validateNotNull(sourceString,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        if (sourceString.length() % 2 == 1) {
            return (sourceString.length() + 1) / 2;
        }
        return sourceString.length() / 2;
    }

    @Override
    public Collection<Integer> extract(String sourceString) {
        Validator.validateNotNull(sourceString,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        maxDigitsNumber = getMaxDigitNumber(sourceString);
        if (sourceString.length() > 1) {
            extractRecursion(sourceString, 0, 1);
        } else {
            return extractedList;
        }
        return extractedList;
    }
}