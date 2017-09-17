package com.epam.university.java.core.task003;

/**
 * Created by Doomsday Device on 17.09.2017.
 */
public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }

        char[] sourceChar = source.toCharArray();
        char[] convertedChars = new char[source.length()];

        for (int i = 0; i < sourceChar.length; i++) {
            convertedChars[i] = sourceChar[sourceChar.length - i - 1];
        }

        String convertedSource = new String(convertedChars);

        return convertedSource;
    }
}
