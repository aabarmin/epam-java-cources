package com.epam.university.java.core.task003;

/**
 * Created by Romin Nuro on 19.08.2020 1:30.
 */
public class MappingOperationImpl implements MappingOperation {
    /**
     * Convert source string in accordance with conditions.
     *
     * @param source source string
     * @return converted string
     * @throws IllegalArgumentException if source string not provided
     */
    @Override
    public String map(String source) {
        char[] sourceArray = source.toCharArray();
        String result = "";
        for (int i = sourceArray.length - 1; i >= 0; i--) {
            result = result.concat(String.valueOf(sourceArray[i]));
        }
        return result;
    }
}